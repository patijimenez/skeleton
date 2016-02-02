package mx.com.mschool

import grails.util.Environment

class MailingSettlement implements Serializable {

		String name
		MailingSettlementType settlementType
		State state
		Municipality municipality
		MailingCity city

		Date dateCreated
		Date lastUpdated

    static constraints = {
        name nullable: false, blank: false, unique: true
				city nullable: true
    }

		static mapping = {
				table 'CAT_SEPOMEX_ASENTAMIENTO'
        cache 'read-only'
				sort "name"

				name column: 'NOMBRE'
				settlementType column: 'ID_TIPO_ASENTAMIENTO'
				state column: 'ID_ENTIDAD_FEDERATIVA'
				municipality column: 'ID_MUNICIPIO'
				city column: 'ID_CIUDAD'
				if(!Environment.isDevelopmentMode()) {
						id (generator:'sequence', params:[sequence:'ASE_SEP_SEQ'])
				}
		}

    String toString() {
        name
    }

}
