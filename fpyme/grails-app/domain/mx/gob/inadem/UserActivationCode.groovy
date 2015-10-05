package mx.gob.inadem

import grails.util.Environment

class UserActivationCode implements Serializable {

		String key
		User user
		Date dateActivated
		Boolean used = false
		Date dateCreated
		Date lastUpdated

    static constraints = {
				dateActivated nullable: true
    }

		static mapping = {
				table 'CODIGO_ACTIVACION'
				if(!Environment.isDevelopmentMode()) {
						id (generator:'sequence', params:[sequence:'COD_A_SEQ'])
				}

				key column: 'LLAVE'
				user column: 'ID_USUARIO'
				dateActivated column: 'FECHA_ACTIVACION'
				used column: 'USADA'
		}
}
