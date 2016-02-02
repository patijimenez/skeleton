package mx.com.mschool.api

import grails.converters.JSON
import mx.com.mschool.*
import mx.com.mschool.exception.*
import org.hibernate.FetchMode

import java.text.SimpleDateFormat


class ApiBatchProcessController {

  def batchProcessService
  def logService
  def userService

  //Batch Process
  def listBatchProcesses(){
    def max = request.JSON.max
    def offset = max * (request.JSON.currentPage - 1)
    def searchCriteria = request.JSON.searchCriteria
    searchCriteria = searchCriteria ? searchCriteria.trim() : null
    def processesList = BatchProcess.withCriteria{
      fetchMode 'user', FetchMode.JOIN
      if(searchCriteria){
        ilike 'name', '%' + searchCriteria + '%'
      }
      if(max){
        maxResults max
      }
      if(offset){
        firstResult offset
      }
      order 'id', 'asc'
    }
    def total = BatchProcess.withCriteria{
      if(searchCriteria){
        ilike 'name', '%' + searchCriteria + '%'
      }
      projections{
        count 'id'
      }
    }.first()
    def processesData = processesList.collect{ process ->
      marshallProces(process)
    }
    def data = [processesList: processesData, total: total]
    render data as JSON
  }

  def getBatchProcess(){
    def processId = request.JSON.processId
    def batchProcess = BatchProcess.get(processId)

  }

  def saveBatchProcess(){
    logService.attachSessionId("GUARDAR PROCESO BATCH")
    def processData = request.JSON.processData
    def user = userService.loggedUser
    def result = [:]
    try{
      def savedProcess = batchProcessService.saveProcess processData, user
      result.process = marshallProces(savedProcess)
      result.status = true
    }catch(Exception ex){
      result.status = false
      result.errorMessage = ex.getMessage()
      logService.logUserRootException(ex, user)
    }finally{
      logService.cleanRequestId()
    }
    render result as JSON
  }

  def executeBatchProcess(){
    def processId = request.JSON.processId
    def user = userService.loggedUser
    def result = [:]
    result = batchProcessService.triggerAsyncProcessEvent processId, user.username
    render result as JSON
  }

  def disableBatchProcess(){
    logService.attachSessionId("DESHABILITAR PROCESO BATCH")
    def batchProcessId = request.JSON.batchProcessId
    def user = userService.loggedUser
    def result = [:]
    try{
      result.status = batchProcessService.disableBatchProcess batchProcessId
    }catch(Exception ex){
      result.status = false
      result.errorMessage = ex.getMessage()
      logService.logUserRootException(ex, user)
    }finally{
      logService.cleanRequestId()
    }
    render result as JSON
  }

  def enableBatchProcess(){
    logService.attachSessionId("HABILITAR PROCESO BATCH")
    def batchProcessId = request.JSON.batchProcessId
    def user = userService.loggedUser
    def result = [:]
    try{
      result.status = batchProcessService.enableBatchProcess batchProcessId
    }catch(Exception ex){
      result.status = false
      result.errorMessage = ex.getMessage()
      logService.logUserRootException(ex, user)
    }finally{
      logService.cleanRequestId()
    }
    render result as JSON
  }

  def deleteBatchProcess(){

  }

  //Batch Process Events
  def listBatchProcessEvents(){
    def data = [:]
    if(request.JSON.processId) {
      def processId = request.JSON.processId.toLong()
      def max = request.JSON.max
      def offset = max * (request.JSON.currentPage - 1)
      def searchCriteri = request.JSON.searchCritria
      def process = BatchProcess.get(processId)
      def eventsList = BatchProcessEvent.withCriteria{
        fetchMode 'user', FetchMode.JOIN
        batchProcess{
          eq 'id', processId
        }
        if(max) maxResults(max)
        if(offset) firstResult(offset)
        order 'id', 'desc'
      }
      def total = BatchProcessEvent.withCriteria{
        batchProcess{
          eq 'id', processId
        }
        projections{
          count('id')
        }
      }.first()
      def dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
      def eventsData = eventsList.collect{ event ->
        def errorStatus = [ ProcessStatus.ERROR,  ProcessStatus.APPLICATION_ERROR]
        def queuedTotal = BatchProcessLog.countByEventAndStatus(event, ProcessStatus.QUEUED)
        def completedTotal = BatchProcessLog.countByEventAndStatus(event, ProcessStatus.OK)
        def errorTotal = BatchProcessLog.countByEventAndStatusInList(event, errorStatus)
        [ id: event.id,
          status: event.status.toString(),
          startExecution: event.startExecution ? dateFormat.format(event.startExecution) : null ,
          endExecution: event.endExecution ? dateFormat.format(event.endExecution) : null,
          threadPoolSize: event.threadPoolSize,
          numTasks: event.numTasks,
          user: event.user.username,
          queuedTotal: queuedTotal,
          completedTotal: completedTotal,
          errorTotal: errorTotal
        ]
      }
      data = [ eventsList: eventsData, process: marshallProces(process), total: total]
    }else{
      data = [eventsList: null, process: null, status: false]
      response.status = 500
    }
    render data as JSON
  }

  //Batch Process Tasks Log
  def listBatchProcessTasksLog(){
    def processEventId = request.JSON.processEventId.toLong()
    def max = request.JSON.max
    def offset = max * (request.JSON.currentPage - 1)
    def searchCriteria = request.JSON.searchCriteria

    def processEvent = BatchProcessEvent.get(processEventId)

    def tasksList = BatchProcessLog.withCriteria{
      event{
        eq 'id', processEventId
      }
      if(searchCriteria){
        eq 'status', ProcessStatus."$searchCriteria"
      }
      if(max) maxResults(max)
      if(offset) firstResult(offset)
      order 'id', 'desc'
    }

    def total = BatchProcessLog.withCriteria{
      event{
        eq 'id', processEventId
      }
      if(searchCriteria){
        eq 'status', ProcessStatus."$searchCriteria"
      }
      projections{
        count('id')
      }
    }.first()

    def dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
    def tasksData = tasksList.collect{ taskLog ->
      [
        id: taskLog.id,
        status: taskLog.status?.toString(),
        startExecution: taskLog.startExecution ? dateFormat.format(taskLog.startExecution) : null,
        endExecution: taskLog.endExecution ? dateFormat.format(taskLog.endExecution) : null,
        parameters: taskLog.parameters,
        result: taskLog.result,
        errorCode: taskLog.errorCode
      ]
    }

    def data = [ tasksLogList: tasksData, total: total, event: [ id: processEvent.id ],
                 process: [ id: processEvent.batchProcess.id, name: processEvent.batchProcess.name ]
    ]
    render data as JSON
  }

  def getConsoleBatchProcessEvent(){
    def processEventId = request.JSON.processEventId.toLong()
    def processEvent = BatchProcessEvent.get(processEventId)
    def data, consoleLog
    if(processEvent){
      if(processEvent.status == ProcessStatus.PROCESSING)
        consoleLog = batchProcessService.getConsoleProcessEvent processEventId
      else
        consoleLog = processEvent.executionLog
    }

    data = [
      consoleLog: consoleLog,
      processId: processEvent ? processEvent.batchProcess.id : null,
      processEvent: processEvent ? [ processEventId: processEvent.id, status: processEvent.status.toString() ] : [:]
    ]
    render data as JSON

  }

  def executeSingleTask(){
    def taskLogId = request.JSON.taskLogId.toLong()
    logService.attachSessionId("EJECUTAR TAREA BATCH")
    def user = userService.loggedUser
    def result = [:]
    try{
      result.status = batchProcessService.executeSingleTask taskLogId, user
    }catch(Exception ex){
      result.status = false
      result.errorMessage = ex.getMessage()
      logService.logUserRootException(ex, user)
    }finally{
      logService.cleanRequestId()
    }
    render result as JSON
  }

  private marshallProces(def process){
    [ id: process.id,
      name: process.name,
      description: process.description,
      tasksScript: process.tasksScript,
      functionalityScript: process.functionalityScript,
      cronExpression: process.cronExpression,
      onDemand: process.onDemand != null ? process.onDemand.toString() : null,
      user: process.user.username,
      active: process.active,
      threadPoolSize: process.threadPoolSize,
      businessProcess: process.businessProcess,
      multipleTasks: process.multipleTasks != null ? process.multipleTasks: false
    ]
  }

}