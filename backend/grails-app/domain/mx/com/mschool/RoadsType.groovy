package mx.com.mschool

import grails.util.Environment

class RoadsType implements Serializable {

		String name

		Date dateCreated
		Date lastUpdated

    static constraints = {
        name nullable: false, blank: false, unique: true
    }

		static mapping = {
				table 'CAT_TIPO_VIALIDAD'
        cache 'read-only'
				name column: 'NOMBRE'
				sort "name"
				if(!Environment.isDevelopmentMode()) {
						id (generator:'sequence', params:[sequence:'TIP_VIAL_SEQ'])
				}
		}


}
