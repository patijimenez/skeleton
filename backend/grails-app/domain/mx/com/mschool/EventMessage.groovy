package mx.com.mschool

enum Severity {
  DANGER,
  WARNING,
  INFO
}

class EventMessage {

    String message
    Severity severity
 
    Date validFrom
    Date validTo

    Date dateCreated
    Date lastUpdated

    static constraints = {
    }

    static mapping = {
		table 'MENSAJE_EVENTO'
        message   column: 'MENSAJE', type: 'text', sqlType: 'text'
        validFrom column: 'VALIDO_DESDE'
        validTo   column: 'VALIDO_HASTA'
        severity  column: 'SEVERIDAD', enumType: 'ordinal'
    }

}
