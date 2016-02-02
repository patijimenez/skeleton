package mx.com.mschool

import grails.util.Environment

class SettlementType implements Serializable {

		String name

		Date dateCreated
		Date lastUpdated

    static constraints = {
    }

		static mapping = {
				table 'CAT_TIPO_ASENTAMIENTO'
				name column: 'NOMBRE'
				sort "name"
				if(!Environment.isDevelopmentMode()) {
						id (generator:'sequence', params:[sequence:'TIP_AS_SEQ'])
				}
		}
}
