package mx.gob.inadem


class Notification implements Serializable {
  String name
  Script script
  MailTemplate mailTemplate
  String description
  Boolean status
  String cronExpression

  static constraints = {
    description widget: 'textarea'
    description nullable: true
  }

  static mapping = {
    table 'NOTIFICACION'

    name column:'NOMBRE'
    description column: 'DESCRIPCION'
    status column: 'ESTADO'
    mailTemplate column: 'ID_PLANTILLA'
    cronExpression column: 'EXPRESION_TIEMPO'
    script column: 'ID_SCRIPT'

    id (generator:'sequence', params:[sequence:'NOTI_SEQ'])
  }
}