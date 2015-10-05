package mx.gob.inadem

import grails.util.Environment

class Municipality implements Serializable {

		String name
		State state

		Date dateCreated
		Date lastUpdated

    BigDecimal idh
    Boolean hunger
    Boolean violence

    static constraints = {
        name nullable: false, blank: false, unique: true
        idh nullable: true
        hunger nullable: true
        violence nullable: true
    }

		static mapping = {
				table 'CAT_MUNICIPIO'
				sort "name"
				name column: 'NOMBRE'
        idh column: 'IDH'
				state column: 'ID_ENTIDAD_FEDERATIVA'
        hunger column: 'HAMBRE'
        violence column: 'VIOLENCIA'
        cache 'read-only'
        
				if(!Environment.isDevelopmentMode()) {
						id (generator:'sequence', params:[sequence:'MUN_SEQ'])
				}
		}

    String toString() {
        name
    }

}
