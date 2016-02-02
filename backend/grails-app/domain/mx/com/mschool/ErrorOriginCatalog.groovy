package mx.com.mschool

import grails.util.Environment

class ErrorOriginCatalog implements Serializable {

		String name
		String description

		Date dateCreated
		Date lastUpdated

    static constraints = {
				name unique: true
    }

		static mapping = {
				table 'CAT_ORIGEN_ERROR'
				sort "name"
        cache 'read-only'
				name column: 'NOMBRE'
        description column: 'DESCRIPCION', type: 'text', sqlType: 'text'

        id (generator:'sequence', params:[sequence:'ORI_ERR_SEQ'])
		}
}
