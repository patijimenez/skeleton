package mx.com.mschool

import grails.util.Environment

class UserPasswordCode implements Serializable {

		String key
		User user
		Date dateUsed
		Boolean used = false
		Date dateCreated
		Date lastUpdated

    static constraints = {
				dateUsed nullable: true
    }

		static mapping = {
				table 'CODIGO_PASSWORD'
				if(!Environment.isDevelopmentMode()) {
						id (generator:'sequence', params:[sequence:'COD_P_SEQ'])
				}

				key column: 'LLAVE'
				user column: 'ID_USUARIO'
				dateUsed column: 'FECHA_USO'
				used column: 'USADA'
		}
}
