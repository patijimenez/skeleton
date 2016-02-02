package mx.com.mschool

import grails.util.Environment

class ErrorLog implements Serializable {

		String key
		String businessId
		String errorCode
		String message
		User user
		ErrorOriginCatalog origin
		ErrorSeverityCatalog severity

		Date dateCreated
		Date lastUpdated

    static constraints = {
				key unique: true
				message nullable: true
				businessId nullable: true
				user nullable: true
				origin nullable: true
    }

		static mapping = {
				table 'BITACORA_ERROR'
				key name: 'LLAVE'
				businessId name: 'ID_TRAMITE'
        message name: 'CUERPO', type: 'text', sqlType: 'text'
				user column: 'ID_USUARIO'
				origin column: 'ID_ORIGEN'
				severity column: 'ID_SEVERIDAD'

				id (generator:'sequence', params:[sequence:'BIT_ERR_SEQ'])
		}


}
