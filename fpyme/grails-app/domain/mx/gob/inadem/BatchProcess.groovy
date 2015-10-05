package mx.gob.inadem

class BatchProcess implements Serializable {

  static hasMany = [ events: BatchProcessEvent ]

  String name
  String description
  String tasksScript
  String functionalityScript
  String cronExpression
  Boolean businessProcess
  Boolean onDemand
  Boolean active
  Boolean multipleTasks
  Integer threadPoolSize
  User user

  Date dateCreated
  Date lastUpdated

  static constraints = {
    tasksScript nullable: true
    functionalityScript nullable: true
    description nullable: true
    cronExpression nullable: true
    onDemand nullable: true
    businessProcess nullable: true
    multipleTasks nullable: true
  }

  static mapping = {

    name column:'NOMBRE'
    description column: 'DESCRIPCION', sqlType : 'clob'
    tasksScript column: 'SCRIPT_TAREAS', sqlType : 'clob'
    functionalityScript column: 'SCRIPT_FUNCIONALIDAD', sqlType : 'clob'
    cronExpression column: 'EXPRESION_TIEMPO'
    businessProcess column: 'PROCESO_NEGOCIO'
    user column: 'ID_USUARIO'
    multipleTasks column: 'MULTIPLES_TAREAS'

    id (generator:'sequence', params:[sequence:'BATCH_SEQ'])
  }
}