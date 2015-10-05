package mx.gob.inadem

class BatchProcessLog implements Serializable {
  static belongsTo = [ event: BatchProcessEvent ]

  ProcessStatus status
  String parameters
  String result
  String errorCode

  Date startExecution
  Date endExecution
  Date dateCreated
  Date lastUpdated

  static constraints = {
    result nullable: true
    startExecution nullable: true
    endExecution nullable: true
    errorCode nullable: true
    parameters nullable: true
  }

  static mapping = {
    event column: 'ID_EVENTO_BATCH'
    result column: 'RESULTADO', type: 'text', sqlType: 'clob'
    parameters column: 'PARAMETROS', type: 'text', sqlType: 'clob'
    startExecution column: 'INICIO_EJECUCION'
    endExecution column: 'FIN_EJECUCION'
    errorCode column: 'CODIGO_ERROR'

    id (generator:'sequence', params:[sequence:'BATCH_LOG_SEQ'])
  }
}
