package mx.com.mschool

enum NotificationStatus {
	SENT, 
	ERROR		
}

class NotificationLog implements Serializable {
  	Notification notification
	NotificationStatus status
  	User user
  	String message
	String errorKey
  	String trigger
	Date dateCreated
	Date lastUpdated

  static constraints = {
    	dateCreated nullable: true
		lastUpdated nullable: true
		status nullable: true
		errorKey nullable: true
		message nullable: true
		user nullable: true
    	trigger nullable: true
  }

  static mapping = {
    table 'NOTIFICACION_LOG'

    notification column:'ID_NOTIFICACION'
    user column: 'ID_USUARIO'
   	status column: 'ESTATUS'
	errorKey column: 'ERROR_KEY'
	message column: 'MENSAJE'
    trigger column: 'TRIGGER'

    id (generator:'sequence', params:[sequence:'NOTI_LOG_SEQ'])
  }
}
