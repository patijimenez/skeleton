package mx.com.mschool.service

import javax.annotation.PostConstruct;
import mx.com.mschool.*
import mx.com.mschool.exception.*
import mx.com.mschool.job.*
import org.quartz.JobKey;
import org.quartz.TriggerKey;
import org.quartz.Trigger;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.JobDetail;
import static org.quartz.JobBuilder.*
import static org.quartz.TriggerBuilder.*
import static org.quartz.CronScheduleBuilder.*
import grails.util.Environment

class SchedulerService{

  def quartzScheduler
  def grailsApplication
  //def hazelcastInstance

  @PostConstruct
  def init() {
    //println hazelcastInstance
  }

  def isLeader() {
    def buildNumber = grailsApplication.metadata['app.buildNumber']
    def serverIdentifier = grailsApplication.metadata['serverIdentifier']

    def deploymentLog = DeploymentLog.findByBuildNumberAndServerIdentifier(buildNumber, serverIdentifier)
    (deploymentLog && deploymentLog.isLeader)
  }

  def triggerReportJob(def name, def description, def cronExpression, def query, def toList, def language){
    def result = [:]
    def jobLog = JobLog.findByName(name)
    if(jobLog){
      result.message = "Ya existe un reporte con ese nombre"
      result.status = false
      return  result
    }
    def to = ""

    if(toList.size() > 0){
      toList.each{
        to += "$it,"
      }
      to = to.substring(0,to.size() -1)
    }

    jobLog = new JobLog()
    jobLog.name = name
    jobLog.body = query
    jobLog.language = language
    jobLog.status = true
    jobLog.description = description
    jobLog.to = to
    jobLog.cronExpression = cronExpression

    def jobGroup = language == "sql" ? "DBReports" : "AppReports"
    jobLog.parseCsv = (jobGroup == "AppReports")
    if(jobLog.save(failOnError: true, flush:true)){
      JobDetail job = newJob(ReportsJob.class)
        .withIdentity(name, jobGroup)
        .usingJobData("name", jobLog.name)
        .build()

      def trigger = newTrigger()
        .withIdentity("trigger$name", "group1")
        .withSchedule(cronSchedule(cronExpression))
        .build();

      //schedule it
      println "schedule it"
      quartzScheduler.scheduleJob(job, trigger);
      result.status = true
    } else{
      result.status = false
      result.message = "Error al intentar guardar el job"
    }
    return result
  }

  def deleteJob(def name, def jobGroup){
    def jobKey = new JobKey(name,jobGroup)
    quartzScheduler.deleteJob(jobKey)
    def jobLog = JobLog.findByName(name)
    jobLog.delete(failOnError:true)
  }

  def pauseJob(def name, def jobGroup){
    def jobKey = new JobKey(name,jobGroup)
    println jobKey
    quartzScheduler.pauseJob(jobKey)
    def jobLog = JobLog.findByName(name)
    jobLog.status = false
    jobLog.save(failOnError: true)
  }

  def resumeJob(def name, def jobGroup){
    def jobKey = new JobKey(name,jobGroup)
    println jobKey
    quartzScheduler.resumeJob(jobKey)
    def jobLog = JobLog.findByName(name)
    jobLog.status = true
    jobLog.save(failOnError: true)
  }

  def triggerStoredJobs(){
    println "recuperando jobs"
    def jobList = JobLog.list().grep {
      it.body && it.to && it.language
    }
    jobList.each{ item->
      def jobGroup = item.language == "sql" ? "DBReports" : "AppReports"
      JobDetail job = newJob(ReportsJob.class)
        .withIdentity(item.name, jobGroup)
        .usingJobData("name", item.name)
        .build()

      def trigger = newTrigger()
        .withIdentity("trigger$item.name", "group1")
        .withSchedule(cronSchedule(item.cronExpression))
        .build();

      //schedule it
      println "schedule it"
      quartzScheduler.scheduleJob(job, trigger);
    }
    jobList.grep({ it.status == false }).each { job ->
      println "pause job: $job.name"
      def jobGroup = job.language == "sql" ? "DBReports" : "AppReports"
      pauseJob(job.name, jobGroup)
    }

  }

  def triggerNotificationJob(def notificationId, def name, def description, def cronExpression, def scriptId, def mailTemplateId){
    def result = [:]
    def notification
    if(notificationId){
      notification = Notification.get(notificationId)
    } else{
      notification = Notification.findByName(name)
      if(notification){
        result.message = "Ya existe una notificacion con ese nombre"
        result.status = false
        return  result
      }else{
        notification = new Notification()
      }
    }

    notification.name = name
    notification.status = true
    notification.description = description
    notification.cronExpression = cronExpression
    notification.script = Script.get(scriptId)
    notification.mailTemplate = MailTemplate.get(mailTemplateId)


    def notificationGroup = "notifications"
    if(notification.save(failOnError: true, flush:true)){
      JobDetail job = newJob(NotificationJob.class)
        .withIdentity(name, notificationGroup)
        .usingJobData("notificationId", notification.id)
        .build()

      def trigger = newTrigger()
        .withIdentity("notification_$name", "group1")
        .withSchedule(cronSchedule(cronExpression))
        .build();

      //schedule it
      println "schedule notification"
      quartzScheduler.scheduleJob(job, trigger);
      result.status = true
    } else{
      result.status = false
      result.message = "Error al intentar guardar la notificacion"
    }
    return result
  }

  def deleteNotificationJob(def name, def jobGroup){
    def jobKey = new JobKey(name,jobGroup)
    quartzScheduler.deleteJob(jobKey)
    def notification = Notification.findByName(name)
    notification.delete(failOnError:true)
  }

  def pauseNotificationJob(def name, def jobGroup){
    def jobKey = new JobKey(name,jobGroup)
    quartzScheduler.pauseJob(jobKey)
    def notification = Notification.findByName(name)
    notification.status = false
    notification.save(failOnError: true)
  }

  def resumeNotificationJob(def name, def jobGroup){
    def jobKey = new JobKey(name,jobGroup)
    quartzScheduler.resumeJob(jobKey)
    def notification = Notification.findByName(name)
    notification.status = true
    notification.save(failOnError: true)
  }

  def editNotificationJob(def notificationData, def jobGroup){
    def jobKey = new JobKey(notificationData.name,jobGroup)
    quartzScheduler.deleteJob(jobKey)
    triggerNotificationJob(notificationData.id, notificationData.name, notificationData.description, notificationData.cronExpression,
      notificationData.script, notificationData.mailTemplate)
  }

  def triggerStoredNotifications(){
    def notifications = Notification.executeQuery("select n from Notification n where n.cronExpression is not null")

    def notificationGroup = "notifications"
    notifications.each{ item->
      JobDetail job = newJob(NotificationJob.class)
        .withIdentity(item.name, notificationGroup)
        .usingJobData("notificationId", item.id)
        .build()

      def trigger = newTrigger()
        .withIdentity("notification_$item.name", "group1")
        .withSchedule(cronSchedule(item.cronExpression))
        .build();

      //schedule it
      println "schedule notification"
      quartzScheduler.scheduleJob(job, trigger);
    }
    notifications.grep({ it.status == false }).each { notification ->
      println "pause notification: $notification.name"
      pauseNotificationJob(notification.name, "notifications")
    }

  }

  def triggerProcessJob(def batchProcessId, def oldCronExpression) {
    def batchProccess = BatchProcess.get(batchProcessId)
    if (!batchProccess) {
      throw new RuntimeException('SchedulerService:No existe referencia al proceso.')
    }
    def jobGroup = "BatchProcess"
    def jobKey = new JobKey(batchProccess.name, jobGroup)
    //Process Job not exists
    if (!quartzScheduler.checkExists(jobKey)) {
      JobDetail job = newJob(BatchProcessJob.class)
        .withIdentity(batchProccess.name, jobGroup)
        .usingJobData("batchProccessId", batchProccess.id)
        .build()

      def trigger = newTrigger()
        .withIdentity("trigger$batchProccess.name", "group1")
        .withSchedule(cronSchedule(batchProccess.cronExpression))
        .build();

      //schedule it
      println "schedule it process: $batchProccess.name"
      quartzScheduler.scheduleJob(job, trigger)
    }//If the job already exists in the scheduler and the CronExpression changes
    else if(oldCronExpression != batchProccess.cronExpression){
      def triggerName = "trigger$batchProccess.name".toString()
      def triggerKey = new TriggerKey(triggerName,"group1")
      def cronTrigger = quartzScheduler.getTrigger(triggerKey)
      if(cronTrigger){
        println "Reschedule Job $batchProccess.name"
        def newTriggerIns = newTrigger()
          .withIdentity("trigger$batchProccess.name", "group1")
          .withSchedule(cronSchedule(batchProccess.cronExpression))
          .forJob(jobKey)
          .build()
        quartzScheduler.rescheduleJob(triggerKey, newTriggerIns)
      }
    }//Resume schedule
    else if(batchProccess.active == false){
      resumeProcessJob(batchProccess.name)
    }

    return true
  }

  def deleteProcessJob(def name){
    def jobGroup = "BatchProcess"
    def jobKey = new JobKey(name, jobGroup)
    if (quartzScheduler.checkExists(jobKey)) {
      println "Delete schedule for process job: $name"
      quartzScheduler.deleteJob(jobKey)
    }
    return true
  }

  def pauseProcessJob(def name){
    def jobGroup = "BatchProcess"
    def jobKey = new JobKey(name, jobGroup)
    if (quartzScheduler.checkExists(jobKey)) {
      println "Pause schedule for process job: $name"
      quartzScheduler.pauseJob(jobKey)
    }
    return true
  }

  def resumeProcessJob(def name){
    def jobGroup = "BatchProcess"
    def jobKey = new JobKey(name, jobGroup)
    if (quartzScheduler.checkExists(jobKey)) {
      println "Resume schedule for process job $name"
      quartzScheduler.resumeJob(jobKey)
    }
    return true
  }

  def triggerStoredProcessJobs(){
    println "recuperando pocesos"
    def instanceRoot = System.getProperty("com.sun.aas.instanceRoot")
    def processesServerConfig = AppConfig.findByName('batchProcessServerInstanceName')
    if(!Environment.isDevelopmentMode() && !(processesServerConfig && instanceRoot && instanceRoot.contains(processesServerConfig.value))){
      println "SchedulerService.triggerStoredProcessJobs : No es la instancia de procesos batch."
      return
    }

    def batchProcessList = BatchProcess.findAllByCronExpressionIsNotNull()

    batchProcessList.each{ batchProcess->
      triggerProcessJob(batchProcess.id, null)
    }
    batchProcessList.grep({ it.active == false }).each { batchProcess ->
      pauseProcessJob(batchProcess.name)
    }

  }
}
