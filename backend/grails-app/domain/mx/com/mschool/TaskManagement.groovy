package mx.com.mschool

enum TaskStatus {
  COMPLETED(0),
  PROCESSING(1),
  CANCELED(2),
  SCHEDULED(3),
  REVIEWED(4),
  DEPRECATED(5),
  OMITTED_NOTIFY(6),
  OMITTED(7),
  EXPIRED(8)

  int val
  public TaskStatus(int val) {
      this.val = val
  }

  int value() { return value }
}

class TaskManagement implements Serializable {

  User user
  Task task
  TaskStatus status
  Date dateCreated
  Date lastUpdated
  Date expirationDate
  
  static constraints = {
    expirationDate nullable: true
  }

  static mapping = {
    table 'ADMINISTRACION_TAREA'
    user column: 'ID_USUARIO'
    status column: 'ESTATUS', enumType: 'ordinal'
    task column: 'ID_TAREA'
    expirationDate column: 'FECHA_VENCIMIENTO'

    id (generator:'sequence', params:[sequence:'TASK_MANAG_SEQ'])
  }

}
  
