package mx.gob.inadem

import grails.util.Environment

class ScriptVariable implements Serializable {

    String name
    String defaultValue

    static belongsTo = [script: Script]

    static constraints = {
    }

    static mapping = {
        table 'VAR_SCRIPT'
        name column: 'NOMBRE'
        defaultValue column: 'VALOR_DEFECTO'

				id (generator:'sequence', params:[sequence:'VSCRIPT_SEQ'])

    }
}
