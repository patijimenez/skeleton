package mx.com.mschool

import grails.util.Environment

class MailingCity implements Serializable {

		String name
		State state
		Municipality municipality

		Date dateCreated
		Date lastUpdated

    static constraints = {
				name nullable: false, blank: false
    }

		static mapping = {
				table 'CAT_SEPOMEX_CIUDAD'
        cache 'read-only'

				name column: 'NOMBRE'
				state column: 'ID_ENTIDAD_FEDERATIVA'
				municipality column: 'ID_MUNICIPIO'
				sort "name"
				
				if(!Environment.isDevelopmentMode()) {
						id (generator:'sequence', params:[sequence:'CI_SEP_SEQ'])
				}
		}

    String toString() {
        name
    }

}
