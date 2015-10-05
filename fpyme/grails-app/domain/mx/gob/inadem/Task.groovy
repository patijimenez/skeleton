  package mx.gob.inadem

class Task implements Serializable {
  
  String name
  String description
  Date dateCreated
  Date lastUpdated
  
  static constraints = {
  }

  static mapping = {
    table 'TAREA'
            name column: 'NOMBRE'
            description column: 'DESCRIPTION'
    id (generator:'sequence', params:[sequence:'TASK_SEQ'])
  }
  
}
    

