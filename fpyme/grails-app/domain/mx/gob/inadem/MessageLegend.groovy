package mx.gob.inadem

import grails.util.Environment

class MessageLegend implements Serializable {

    	String key
    	String defaultMessage
		String message

		Date dateCreated
		Date lastUpdated

    static constraints = {
        key nullable: false, blank: false
        message nullable: false, blank: false
    }

		static mapping = {
				table 'CAT_MENSAJE_LEYENDA'
				sort "key"

    			key columne: 'LLAVE'
				message column: 'MENSAJE', type: 'text', sqlType: 'clob'
				defaultMessage column: 'MENSAJE_DEFAULT', type: 'text', sqlType: 'clob'
        id (generator:'sequence', params:[sequence:'MEN_LEY_SEQ'])
		}
}
