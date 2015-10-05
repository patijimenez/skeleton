package mx.gob.inadem

import grails.util.Environment

class JobLog implements Serializable {
    String name
    String body
    String language
    String trigger
    String variables
    String description
    Boolean status
    Boolean parseCsv
    String to
    String cronExpression

    static constraints = {
        body widget: 'textarea'
        description widget: 'textarea'
        variables nullable: true
        description nullable: true
        trigger nullable:true
        parseCsv nullable: true
        to nullable:true
    }

    static mapping = {
        table 'JOB'

        language column: 'LENGUAJE'
        name column:'NOMBRE'
        body column: 'CODIGO', type: 'text', sqlType: 'clob'
        trigger column: 'SCR_TRIGGER'
        variables column: 'VARIABLES'
        description column: 'DESCRIPCION'
        status column: 'ESTADO'
        to column: 'DESTINATARIOS'
        parseCsv column: 'PROCESA_CSV'
        cronExpression column: 'EXPRESION_TIEMPO'

        id (generator:'sequence', params:[sequence:'JOB_SEQ'])
    }
}
