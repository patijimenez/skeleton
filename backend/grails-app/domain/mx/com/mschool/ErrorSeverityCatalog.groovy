package mx.com.mschool

import grails.util.Environment

class ErrorSeverityCatalog implements Serializable {
		String name
		String description

		Date dateCreated
		Date lastUpdated

    static constraints = {
				name unique: true
    }

		static mapping = {
				table 'CAT_SEVERIDAD_ERROR'
				name column: 'NOMBRE'
        cache 'read-only'
				sort "name"

				description column: 'DESCRIPCION', type: 'text', sqlType: 'text'
				id (generator:'sequence', params:[sequence:'ORI_ERR_SEQ'])
		}

		String toString() {
				name
		}

}
