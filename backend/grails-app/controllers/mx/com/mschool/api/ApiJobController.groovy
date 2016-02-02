package mx.com.mschool.api

import grails.converters.JSON
import mx.com.mschool.*

class ApiJobController {

  def schedulerService
  def reportsService

  def triggerReportJob(){
    def report =  request.JSON.report
    def result = [:]
    if(report.to && !report.isNull('to') && report.to.size() > 0){
      result = schedulerService.triggerReportJob report.name, report.description, report.cronExpression, report.query, report.to, report.language
    }else{
      result.message = "No ingreso los destinatarios"
      result.status = false
    }
    render result as JSON
  }


  def pauseJob(){
    def  report =  request.JSON.report
    def result = [:]
    try{
      def jobGroup = report.language == "sql" ? "DBReports" : "AppReports"
      schedulerService.pauseJob report.name, jobGroup
      result.status = true
    }catch(Exception ex){
      println ex
      result.message = "Error al pausar el job"
      result.status = false
    }
    render result as JSON
  }

  def resumeJob(){
    def  report =  request.JSON.report
    def result = [:]
    try{
      def jobGroup = report.language == "sql" ? "DBReports" : "AppReports"
      schedulerService.resumeJob report.name, jobGroup
      result.status = true
    }catch(Exception ex){
      println ex
      result.message = "Error al reiniciar el job"
      result.status = false
    }
    render result as JSON
  }

  def deleteJob(){
    def report = request.JSON.report
    def result = [:]
    try{
      def jobGroup = report.language == "sql" ? "DBReports" : "AppReports"
      schedulerService.deleteJob report.name, jobGroup
      result.status = true
    }catch(Exception ex){
      println ex
      result.status = false
    }
    render result as JSON
  }

  def sendReportNow(){
    def report = request.JSON.report
    def result = [:]

    try {
      result.status = reportsService.sendReportNow(report)
    } catch(Exception ex){
      ex.printStackTrace()
      throw ex
    }

    render result as JSON
  }

  def getJobsList(){
    def searchCriteria = request.JSON.searchCriteria? request.JSON.searchCriteria.trim() : null
    def rows = request.JSON.maxSize
    def offset = rows * (request.JSON.currentPage - 1)

    def jobList = JobLog.withCriteria{
      if(searchCriteria){
        ilike("name", "%" + searchCriteria + "%")
      }
      if(rows){
        maxResults(rows)
      }

      if(offset) {
        firstResult(offset)
      }
    }

    def total = JobLog.withCriteria{
      if(searchCriteria){
				ilike("name", "%" + searchCriteria + "%")
      }
      projections{
        count("id")
      }
    }

    jobList = jobList.collect{
      [
        id : it.id,
        name : it.name,
        body : it.body,
        language : it.language,
        trigger : it.trigger,
        variables : it.variables,
        description : it.description,
        status : it.status,
        to : it.to,
        prettyTo : it.to.split(",").join(",\n"),
        cronExpression : it.cronExpression
      ]
    }

    def data = [
      jobs : jobList,
      total : total
    ]

    render data as JSON
  }

  def triggerNotificationJob(){
    def  notificationData =  request.JSON.notification
    def result = [:]
    //try{
    if(!notificationData.isNull('id')){
      schedulerService.editNotificationJob notificationData, "notifications"
      result.status = true
    }else{
      result = schedulerService.triggerNotificationJob null, notificationData.name, notificationData.description, notificationData.cronExpression,
          notificationData.script, notificationData.mailTemplate
    }
    /*}catch(Exception ex){
      println ex
      result.message = "Error al guardar la notificacion"
      result.status = false
    }       */
    render result as JSON
  }


  def pauseNotificationJob(){
    def  notification =  request.JSON.notification
    def result = [:]
    try{
      schedulerService.pauseNotificationJob notification.name, "notifications"
      result.status = true
    }catch(Exception ex){
      println ex
      result.message = "Error al pausar la notificacion"
      result.status = false
    }
    render result as JSON
  }

  def resumeNotificationJob(){
    def  notification =  request.JSON.notification
    def result = [:]
    try{
      schedulerService.resumeNotificationJob notification.name, "notifications"
      result.status = true
    }catch(Exception ex){
      println ex
      result.message = "Error al reiniciar la notificacion"
      result.status = false
    }
    render result as JSON
  }

  def deleteNotificationJob(){
    def notification = request.JSON.notification
    def result = [:]
    try{
      schedulerService.deleteNotificationJob notification.name, "notifications"
      result.status = true
    }catch(Exception ex){
      println ex
      result.status = false
    }
    render result as JSON
  }

  def getNotificationsList(){
    def notifications = Notification.list()
    def data = notifications.collect{
      [ id: it.id,
          description: it.description,
          cronExpression: it.cronExpression,
          name: it.name,
          status: it.status,
          script: [ id: it.script.id, name: it.script.name ],
          mailTemplate: [id: it.mailTemplate.id, key: it.mailTemplate.key]
      ]
    }
    render data as JSON
  }

  def getScriptsAndTemplatesForNotifications(){
    def scripts = Script.findAllByTrigger("NOTIFICATION")
    def mailTemplates = MailTemplate.list()
    def data = [ scripts: scripts, mailTemplates: mailTemplates ]
    render data as JSON
  }

  def pauseProcessJob(){

  }
}
