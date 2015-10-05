package mx.gob.inadem.job

import mx.gob.inadem.*
import org.quartz.Job;
import org.quartz.JobKey;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

class BatchProcessJob implements org.quartz.Job {


  public void execute(JobExecutionContext context) throws JobExecutionException {
    def grailsApplication = org.codehaus.groovy.grails.commons.ApplicationHolder.getApplication()
    def batchProcessService = grailsApplication.mainContext.getBean("batchProcessService")
    def logService = grailsApplication.mainContext.getBean("logService")

    def batchProcess
    BatchProcess.withTransaction{
      try {
        logService.attachSessionId("EJECUTAR JOB DE PROCESO BATCH")
        JobKey key = context.getJobDetail().getKey()
        JobDataMap dataMap = context.getJobDetail().getJobDataMap()
        def batchProccessId = dataMap.getLongValue("batchProccessId")
        batchProcess = BatchProcess.get(batchProccessId)
        println "BatchProcessJob"
        if (!batchProcess) {
          println "BatchProcesss id:$batchProccessId doesnt exist!"
          return
        }

        //Check process server instance
        if(!batchProcessService.validateProcessesServer()){
          println "BatchProcessJob: No es la instancia de procesos batch."
          return
        }

        println "Ejecutnado el proceso batch $batchProcess.name"
        batchProcessService.triggerAsyncProcessEvent batchProcess.id, batchProcess.user.username

      }catch(Exception ex) {
        logService.logUserRootException(ex, batchProcess.user)
      }finally{
        logService.cleanRequestId()
      }
    }
  }
}
