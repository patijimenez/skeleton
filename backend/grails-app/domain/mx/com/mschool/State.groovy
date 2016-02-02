package mx.com.mschool

import grails.util.Environment

class State implements Serializable {

		String name
		String abbreviation

		Date dateCreated
		Date lastUpdated

    static constraints = {
        name nullable: false, blank: false, unique: true

    }

		static mapping = {
				table 'CAT_ENTIDAD_FEDERATIVA'
				sort "name"
        cache 'read-only'

				name column: 'NOMBRE'
				abbreviation column: 'ABREVIATURA'


        id column: "sco_id", generator:'assigned'
				if(!Environment.isDevelopmentMode()) {
						id (generator:'sequence', params:[sequence:'EST_SEQ'])
				}
		}


    String toString() {
        name
    }

}
