package mx.gob.inadem

import grails.util.Environment

class Locality {

		String name
		State state
		Municipality municipality
    BigDecimal latitude
    BigDecimal longitude
    BigDecimal altitude


		Date dateCreated
		Date lastUpdated

    static constraints = {
				name nullable: false, blank: false
				state nullable: false
				municipality nullable: false
    }

		static mapping = {
				table 'CAT_INEGI_LOCALIDAD'
        cache 'read-only'

        latitude column: 'LATITUD'
        longitude column: 'LONGITUD'
        altitude column: 'ALTITUD'

				name column: 'NOMBRE'
				state column: 'ID_ENTIDAD_FEDERATIVA'
				municipality column: 'ID_MUNICIPIO'
				sort "name"
				
				if(!Environment.isDevelopmentMode()) {
						id (generator:'sequence', params:[sequence:'LO_INE_SEQ'])
				}
		}

}
