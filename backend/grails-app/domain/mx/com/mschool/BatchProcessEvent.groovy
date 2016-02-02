package mx.com.mschool

enum ProcessStatus{
  OK,
  QUEUED,
  PROCESSING,
  PAUSED,
  ERROR,
  CANCELED,
  APPLICATION_ERROR
}

class BatchProcessEvent implements Serializable {

  static belongsTo = [ batchProcess: BatchProcess ]
  static hasMany = [ logs: BatchProcessLog ]

  ProcessStatus status
  Date startExecution
  Date endExecution
  Date dateCreated
  Date lastUpdated
  Integer threadPoolSize
  String executionLog
  Integer numTasks
  User user

  static constraints = {
    status nullable: true
    startExecution nullable: true
    endExecution nullable: true
    numTasks nullable: true
    executionLog nullable: true
  }

  static mapping = {
    batchProcess column: 'ID_PROCESO_BATCH'
    user column: 'ID_USUARIO'
    startExecution column: 'INICIO_EJECUCION'
    endExecution column: 'FIN_EJECUCION'
    numTasks column: 'NUMERO_TAREAS'
    executionLog column: 'LOG_EJECUCION', type: 'text', sqlType: 'text'

    id (generator:'sequence', params:[sequence:'BATCH_EV_SEQ'])
  }
}