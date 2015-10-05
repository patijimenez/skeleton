package mx.gob.inadem.service

import grails.plugin.jms.*

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger
import mx.gob.inadem.*
import mx.gob.inadem.exception.*
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.annotation.Propagation
import java.text.SimpleDateFormat
import org.hibernate.FetchMode
import grails.converters.JSON
import grails.util.Environment


class BatchProcessService{

  static exposes = ["jms"]
  def logService
  def developerService
  def jmsService
  def schedulerService

  public processConcurrentMap = new ConcurrentHashMap()

  def initExecutorByProcessEvent(def processEventId, def threadPoolSize, def processName){
    def executorService
    def poolSize = threadPoolSize
    //If there is thread configuration
    //If executorService already exists for this process event
    def concurrentProcessObj = processConcurrentMap[processEventId]
    if(concurrentProcessObj && concurrentProcessObj.executorService){
      executorService = concurrentProcessObj.executorService
      executorService.shutdownNow()
    }else{
      processConcurrentMap[processEventId] = [ executorService: null, countPendingTasks: null , stringLog: new String()]
    }

    executorService = Executors.newFixedThreadPool(poolSize, new ThreadFactory() {
      def current = new AtomicInteger(0)
      @Override
      public Thread newThread(Runnable r) {
        def threadId = current.getAndIncrement()
        def name = "$processName Event: $processEventId Thread: $threadId"
        Thread t = new Thread(r, name);
        t.setDaemon(true);
        return t;
      }
    });

    processConcurrentMap[processEventId].executorService = executorService
  }

  def shutdownExecutorService(def processEventId){
    def concurrentProcessObj = processConcurrentMap[processEventId]
    if(concurrentProcessObj && concurrentProcessObj.executorService){
      concurrentProcessObj.executorService.shutdownNow()
      processConcurrentMap.remove(processEventId)
    }
  }

  @Queue(name="jms/executeBatchProcessQueue")
  def executeBatchProcess(msgData) {
    def processEvent = BatchProcessEvent.get(msgData.processEventId)
    if(!processEvent){
      updateErrorTaskLog msgData.batchProcessLogId, msgData.userId, null, "No existe información del evento $processEvent.id", null
      return
    }
    def process = processEvent.batchProcess
    def concurrentProcessObj = processConcurrentMap[processEvent.id]
    def executorService = concurrentProcessObj?.executorService
    //ExecutorService doesn't exists
    if (!executorService) {
      updateErrorTaskLog msgData.batchProcessLogId, msgData.userId, null, "No fue inicializado el executorService del evento $processEvent.id", null
      return
    }

    executorService.execute(new Runnable() {
      @Override
      public void run() {
        logService.attachSessionId("$process.name Event: $processEvent.id")
        try {
          def scriptConsoleOutput = executeSingleBatchTask msgData, process.functionalityScript, process.businessProcess
          if (scriptConsoleOutput) logConsoleOutputProcessEvent msgData.processEventId, scriptConsoleOutput
        }catch(Exception ex){
          def exMessage = ex instanceof AppException ? ex.getMessage() : ""
          updateErrorTaskLog msgData.batchProcessLogId, msgData.userId, new Date(), exMessage, ex
        } finally {
          logService.cleanRequestId()
          if(concurrentProcessObj && concurrentProcessObj.countPendingTasks){
            concurrentProcessObj.countPendingTasks.countDown()
          }else{
            //If monitor is off
            if(msgData.taskIndex == msgData.totalTasks){
              BatchProcessEvent.withTransaction{
                def consoleLog = getConsoleProcessEvent(processEvent.id)
                shutdownExecutorService(processEvent.id)
                updateProcessEvent(processEvent.id, ProcessStatus.OK, consoleLog)
              }
            }
          }

        }
      }
    });

  }

  def executeSingleBatchTask(def msgData, def functionalityScript, def businessProcess){
    def batchProcessLog
    def startExecutionDate = new Date()
    def scriptConsoleOutput = null
    BatchProcessLog.withTransaction {
      //logConsoleOutputProcessEvent processEvent.id, "Procesando el mensaje $msgData"
      def parameters = null
      def output = [:]

      batchProcessLog = BatchProcessLog.get(msgData.batchProcessLogId)
      batchProcessLog.startExecution = startExecutionDate

      if (batchProcessLog.parameters) {
        parameters = JSON.parse(batchProcessLog.parameters)
      }
      if (businessProcess) {
        def grailsApplication = org.codehaus.groovy.grails.commons.ApplicationHolder.getApplication()
        def serviceName = msgData.serviceName
        def methodName = msgData.methodName
        logConsoleOutputProcessEvent msgData.processEventId, "Ejecutando un proceso batch de negocio"
        logConsoleOutputProcessEvent msgData.processEventId, "Service: $serviceName"
        logConsoleOutputProcessEvent msgData.processEventId, "Method: $methodName"
        logConsoleOutputProcessEvent msgData.processEventId, "Args:"
        logConsoleOutputProcessEvent msgData.processEventId, parameters.toString()
        def relService = grailsApplication.mainContext.getBean(serviceName)
        output = relService."$methodName"(parameters)
      } else {
        (output, scriptConsoleOutput) = developerService.executeOutputAndParamScript(functionalityScript, parameters, output)
      }
      batchProcessLog.result = output?.toString()
      batchProcessLog.errorCode = null
      batchProcessLog.status = ProcessStatus.OK
      batchProcessLog.endExecution = new Date()
      batchProcessLog.save(flush: true)
    }
    scriptConsoleOutput
  }

  @Queue(name="jms/monitorBatchProcessQueue")
  def monitorBatchProcessEvent(def msg){
    def concurrentProcessObj = processConcurrentMap[msg.processEventId]
    if(concurrentProcessObj && concurrentProcessObj.countPendingTasks && concurrentProcessObj.executorService){
      try{
        println "Iniciando Monitoreo el evento $msg.processEventId"
        logConsoleOutputProcessEvent msg.processEventId, "Iniciando Monitoreo el evento $msg.processEventId .${new Date()}"
        //Wait all tasks
        concurrentProcessObj.countPendingTasks.await()
        logConsoleOutputProcessEvent msg.processEventId, "Se terminó la ejecución de todas las tareas."
        //Shutdown executor and remove from hashmap
        logConsoleOutputProcessEvent msg.processEventId, "Shuting down executor service. ${new Date()}"
        def consoleLog = getConsoleProcessEvent(msg.processEventId)
        shutdownExecutorService(msg.processEventId)
        updateProcessEvent(msg.processEventId, ProcessStatus.OK, consoleLog)

      }catch(Exception ex){
        logService.logUserRootException(ex, User.get(msg.userId))
      }
    }else{
      println "No fue inicializado correctamente el proceso $msg.processEventId"
    }
    return
  }

  def triggerAsyncBusinessProcessEvent(def processName, def username, def serviceName, def methodName, def args){
    logService.attachSessionId("TRIGGER BUSINESS PROCESS EVENT")

    def resultData = [:]
    def user = User.findByUsername(username)
    def process = BatchProcess.findByName(processName)

    if(!process){
      throw new RuntimeException("Error al ejecutar el proceso de negocio. No existe el proceso configurado")
    }
    def processEvent = createProcessEvent(user, process.threadPoolSize, process)
    logConsoleOutputProcessEvent processEvent.id, "Creando Pool de executors $process.name event: $processEvent.id"
    initExecutorByProcessEvent(processEvent.id, process.threadPoolSize, process.name)
    try{
      processEvent.numTasks = 1
      processEvent.save(flush: true)
      logConsoleOutputProcessEvent processEvent.id,  "1 Tarea para procesar"
      def concurrentProcessObj = processConcurrentMap[processEvent.id]
      if(concurrentProcessObj){
        concurrentProcessObj.countPendingTasks = new CountDownLatch(1)
        jmsService.send("jms/monitorBatchProcessQueue", [ processEventId: processEvent.id, userId: user.id])
      }else{
        println "No se esta monitoreando el evento."
        println processConcurrentMap
      }
      def batchProcessLog = new BatchProcessLog()
      batchProcessLog.parameters = (args as JSON).toString()
      batchProcessLog.status = ProcessStatus.QUEUED
      batchProcessLog.event = processEvent
      batchProcessLog.save(flush: true)

      def message = [
        taskIndex: 1,
        processEventId   : processEvent.id,
        batchProcessLogId: batchProcessLog.id,
        userId           : user.id,
        serviceName: serviceName,
        methodName: methodName,
        totalTasks: 1
      ]
      jmsService.send("jms/executeBatchProcessQueue", message)
      resultData.processEventId = processEvent.id
      resultData.processId = process.id
    } catch (Exception ex) {
      logService.logUserRootException(ex, User.findByUsername(username))
      updateProcessEvent(processEvent.id, ProcessStatus.ERROR, "\nError al procesar las tareas: \n ${ex.stackTrace} \n ${ex.getMessage()}")
      resultData.status = false
    } finally {
      logService.cleanRequestId()
    }
    resultData.status = true
    resultData
  }

  @Transactional(propagation = Propagation.REQUIRED)
  def triggerAsyncProcessEvent(def processId, def username){
    def user = User.findByUsername(username)
    def process = BatchProcess.get(processId)
    def processEvent = createProcessEvent(user, process.threadPoolSize, process)

    logConsoleOutputProcessEvent processEvent.id, "Creando Pool de executors $process.name event: $processEvent.id"
    initExecutorByProcessEvent(processEvent.id, process.threadPoolSize, process.name)

    def executorTasks = Executors.newFixedThreadPool(1);
    executorTasks.execute(new Runnable() {
      @Override
      public void run() {
        logConsoleOutputProcessEvent processEvent.id, "Lanzando proceso asincrono para obtener tareas ${new Date()}"
        triggerProcessEvent(processEvent.id, username, process.tasksScript, process.multipleTasks)
      }
    });
    executorTasks.shutdown()
    return [status: true, processEventId: processEvent.id]
  }

  def triggerProcessEvent(def processEventId, def username, def tasksScript, def multipleTasks){
    logService.attachSessionId("TRIGGER PROCESS EVENT")

    try {
      def user
      def processEvent, scriptConsoleOutput = null
      def paramsList = []
      BatchProcessEvent.withTransaction{
        user = User.findByUsername(username)
        processEvent = BatchProcessEvent.get(processEventId)
        if(multipleTasks){
          (paramsList, scriptConsoleOutput) = developerService.executeOutputParamScript(tasksScript, paramsList, 'paramsList')
          logConsoleOutputProcessEvent processEventId, scriptConsoleOutput
        }else{
          paramsList.push([:])
        }
        processEvent.numTasks = paramsList ? paramsList.size() : 0
        processEvent.save(flush: true)
      }
      if (!processEvent) {
        throw new RuntimeException('Error al encontrar la referencia al proceso')
        return
      }
      if (paramsList && paramsList.size() > 0) {
        logConsoleOutputProcessEvent processEventId,  "${paramsList.size()} Tareas para procesar"
        def concurrentProcessObj = processConcurrentMap[processEvent.id]
        def totalTasks = paramsList.size()
        if(concurrentProcessObj){
          concurrentProcessObj.countPendingTasks = new CountDownLatch(totalTasks)
          jmsService.send("jms/monitorBatchProcessQueue", [ processEventId: processEvent.id, userId: user.id])
        }else{
          println "No se esta monitoreando el evento."
          println processConcurrentMap
        }
        paramsList.eachWithIndex { params, index ->
          def batchProcessLog
          BatchProcessEvent.withTransaction{
            def parameters = (params as JSON).toString()
            batchProcessLog = new BatchProcessLog()
            batchProcessLog.parameters = parameters
            batchProcessLog.status = ProcessStatus.QUEUED
            batchProcessLog.event = processEvent
            batchProcessLog.save(flush: true)
          }
          def message = [
            taskIndex: index+1,
            processEventId   : processEvent.id,
            batchProcessLogId: batchProcessLog.id,
            userId           : user.id,
            totalTasks: totalTasks
          ]
          //logConsoleOutputProcessEvent processEventId,  "Encolando el mensaje: $message"
          jmsService.send("jms/executeBatchProcessQueue", message)
        }
      } else {
        logConsoleOutputProcessEvent processEventId,  "No se encontraron tareas para procesar este evento."
        logConsoleOutputProcessEvent processEventId, "Shuting down executor service ${new Date()}"
        def consoleLog = getConsoleProcessEvent(processEventId)
        shutdownExecutorService(processEventId)
        updateProcessEvent(processEventId, ProcessStatus.OK, consoleLog)
        return [status: false, messageError: 'No se encontraron tareas para ejecutar.']
      }

    } catch (Exception ex) {
      logService.logUserRootException(ex, User.findByUsername(username))
      shutdownExecutorService(processEventId)
      updateProcessEvent(processEventId, ProcessStatus.ERROR, "\nError al procesar las tareas: \n ${ex.stackTrace}")
    } finally {
      logService.cleanRequestId()
    }
  }

  def logConsoleOutputProcessEvent(def processEventId, def str){
    def concurrentProcessObj = processConcurrentMap[processEventId]
    if(concurrentProcessObj) {
      try {
        if(!concurrentProcessObj.stringLog) concurrentProcessObj.stringLog = new String()
        concurrentProcessObj.stringLog = concurrentProcessObj.stringLog + "\n" + str
      }catch(Exception ex){}
    }
  }

  def getConsoleProcessEvent(def processEventId){
    def concurrentProcessObj = processConcurrentMap[processEventId]
    def logStr = null
    if(concurrentProcessObj) {
      try {
        if(!concurrentProcessObj.stringLog) concurrentProcessObj.stringLog = new String()
        logStr = concurrentProcessObj.stringLog
      }catch(Exception ex){}
    }
    logStr
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  def createProcessEvent(def user, def poolSize, def process){
    def processEvent = new BatchProcessEvent()
    processEvent.status = ProcessStatus.PROCESSING
    processEvent.startExecution = new Date()
    processEvent.threadPoolSize =  poolSize
    processEvent.user = user
    processEvent.batchProcess = process
    processEvent.save(failOnError: true, flush: true)
    processEvent
  }

  @Transactional(propagation = Propagation.REQUIRED)
  def saveProcess(def processData, def user){
    def savedProcess
    if(processData.isNull('cronExpression') || (!processData.isNull('cronExpression') && validateProcessesServer()) ) {
      def prevProcessDefinition = processData.isNull('id') ? null : BatchProcess.get(processData.id)
      def oldCronExpression = prevProcessDefinition ? prevProcessDefinition.cronExpression : null
      savedProcess = innerSaveProcess(processData, user)
      //println processData.cronExpression
      //println oldCronExpression
      //CronExpression not null and Active not null and Active = true
      if (!processData.isNull('cronExpression') && !processData.isNull('active') && processData.active) {
        //Create schedule and reschedule job with the new cronExpression
        schedulerService.triggerProcessJob(savedProcess.id, oldCronExpression)
      } //CronExpression not null and Active not null and Active = false
      else if(!processData.isNull('cronExpression') && !processData.isNull('active') && !processData.active){
        //Pause schedule job
        schedulerService.pauseProcessJob(savedProcess.name)
      } //New CronExpression null and prev CronExpression not null
      else if (oldCronExpression && processData.isNull('cronExpression')) {
        //delete schedule job
        schedulerService.deleteProcessJob(savedProcess.name)

      }
    }else{
      throw new RuntimeException("No te encuentras en la instancia destinada para ejecutar procesos batch (Programados)")
    }
    savedProcess
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  def innerSaveProcess(def processData, def user){
    def process
    //Save
    if(processData && !processData.isNull('id')){
      process = BatchProcess.get(processData.id)
    }else{ //Create
      process = new BatchProcess()
    }
    process.name = !processData.isNull('name') ? processData.name : null
    process.description = !processData.isNull('description') ? processData.description : null
    process.active = !processData.isNull('active') ? processData.active : null
    process.businessProcess = !processData.isNull('businessProcess') ? processData.businessProcess : null
    if( process.businessProcess){
      processData.cronExpression = null
      processData.onDemand = null
    }
    process.onDemand = !processData.isNull('onDemand') ? new Boolean(processData.onDemand) : null
    process.cronExpression = !processData.isNull('cronExpression') ? processData.cronExpression : null
    process.tasksScript = !processData.isNull('tasksScript') ? processData.tasksScript : null
    process.functionalityScript = !processData.isNull('functionalityScript') ? processData.functionalityScript : null
    process.threadPoolSize = !processData.isNull('threadPoolSize') ?  new Integer(processData.('threadPoolSize')) : 1
    process.multipleTasks = !processData.isNull('multipleTasks') ? new Boolean(processData.multipleTasks) : true
    process
    process.user = user
    if(!process.save(failOnError: true)){
      throw new RuntimeException("Error al guardar el proceso")
    }
    process
  }

  def updateErrorTaskLog(def batchProcessLogId, def userId, def startExecutionDate, def output, def ex){

    def codeKey = null
    BatchProcessLog.withTransaction{
      if(ex){
        codeKey = logService.logUserRootException(ex, User.get(userId))
      }
      def batchProcessLog = BatchProcessLog.get(batchProcessLogId)
      if(batchProcessLog){
        batchProcessLog.errorCode = codeKey
        batchProcessLog.status = ex instanceof AppException ? ProcessStatus.APPLICATION_ERROR : ProcessStatus.ERROR
        batchProcessLog.startExecution = startExecutionDate ? startExecutionDate : new Date()
        batchProcessLog.endExecution = new Date()
        batchProcessLog.result = output?.toString()
        batchProcessLog.save(flush:true)
      }
    }
  }

  def updateProcessEvent(def processEventId, def status, def consoleLog){
    def codeKey = null
    BatchProcessEvent.withTransaction{
      def batchProcessEvent = BatchProcessEvent.get(processEventId)
      if(batchProcessEvent){
        batchProcessEvent.endExecution = new Date()
        batchProcessEvent.status = status
        batchProcessEvent.executionLog = consoleLog
        batchProcessEvent.save(flush:true)
      }
    }
  }

  def validateProcessesServer(){
    def instanceRoot = System.getProperty("com.sun.aas.instanceRoot")
    def processesServerConfig = AppConfig.findByName('batchProcessServerInstanceName')
    if(!Environment.isDevelopmentMode() && !(processesServerConfig && instanceRoot && instanceRoot.contains(processesServerConfig.value))){
      return false
    }
    return true
  }

  @Transactional(propagation = Propagation.REQUIRED)
  def disableBatchProcess(def batchProcessId){
    def batchProccess = BatchProcess.get(batchProcessId)
    if (!batchProccess) {
      throw new RuntimeException('BathcProcessService:No existe referencia al proceso.')
    }
    if(batchProccess.cronExpression && validateProcessesServer()) {
      if (batchProccess.cronExpression) {
        schedulerService.pauseProcessJob(batchProccess.name)
      }
      batchProccess.active = false
      batchProccess.save()
    }
    return true
  }

  @Transactional(propagation = Propagation.REQUIRED)
  def enableBatchProcess(def batchProcessId){
    def batchProccess = BatchProcess.get(batchProcessId)
    if (!batchProccess) {
      throw new RuntimeException('BathcProcessService:No existe referencia al proceso.')
    }
    if(batchProccess.cronExpression && validateProcessesServer()) {
      if (batchProccess.cronExpression) {
        schedulerService.resumeProcessJob(batchProccess.name)
      }
      batchProccess.active = true
      batchProccess.save()
    }else {
      println "No"
    }
    return true
  }

  @Transactional(propagation = Propagation.REQUIRED)
  def executeSingleTask(def taskLogId, def user){
    def batchProcessLog = BatchProcessLog.get(taskLogId)
    if(batchProcessLog){
      def parameters
      def process = batchProcessLog.event.batchProcess
      batchProcessLog.status = ProcessStatus.PROCESSING
      batchProcessLog.startExecution = new Date()
      batchProcessLog.save(flush:true)
      if (batchProcessLog.parameters) {
        parameters = JSON.parse(batchProcessLog.parameters)
      }
      def msgData = [
        taskIndex: 1,
        processEventId   : batchProcessLog.event.id,
        batchProcessLogId: batchProcessLog.id,
        userId           : user.id,
        totalTasks: 1
      ]

      def executorTasks = Executors.newFixedThreadPool(1);
      executorTasks.execute(new Runnable() {
        @Override
        public void run() {
          try{
            def scriptConsoleOutput = executeSingleBatchTask msgData, process.functionalityScript, process.businessProcess
          }catch(Exception ex){
            def exMessage = ex instanceof AppException ? ex.getMessage() : ""
            updateErrorTaskLog msgData.batchProcessLogId, msgData.userId, new Date(), exMessage, ex
          }
        }
      });
      executorTasks.shutdown()
    }
    true
  }

}
