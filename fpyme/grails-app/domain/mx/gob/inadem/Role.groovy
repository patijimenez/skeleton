package mx.gob.inadem

import grails.util.Environment

class Role implements Serializable {
    String name
		String description 

    static hasMany = [ users: User, permissions: String ]
    static belongsTo = User

		Date dateCreated
		Date lastUpdated

    static constraints = {
        name(nullable: false, blank: false, unique: true)
				description nullable: true
    }

		static mapping = {
				table 'ROL'
				name column: 'NOMBRE'
				description column: 'DESCRIPTION'

				permissions joinTable: [name: "ROL_PERMISO", column: "PERMISO"]
				if(!Environment.isDevelopmentMode()) {
						id (generator:'sequence', params:[sequence:'ROL_SEQ'])
				}
		}

    String toString() {
        name
    }
}
