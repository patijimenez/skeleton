package mx.gob.inadem

import grails.util.Environment

class MailingPostalCode implements Serializable {
		String postalCode

		MailingSettlementType settlementType
		MailingSettlement settlement
		Municipality municipality
		State state
		MailingCity city

		Date dateCreated
		Date lastUpdated

    static constraints = {
				city nullable: true
    }

		static mapping = {
				table 'CAT_SEPOMEX_CP'
        cache 'read-only'
				sort "postalCode"

				settlement column: 'ID_ASENTAMIENTO'
				settlementType column: 'ID_TIPO_ASENTAMIENTO'
				municipality column: 'ID_MUNICIPIO'
				state column: 'ID_ENTIDAD_FEDERATIVA'
				city column: 'ID_CIUDAD'
				postalCode column: 'CODIGO_POSTAL'
				if(!Environment.isDevelopmentMode()) {
						id (generator:'sequence', params:[sequence:'CP_SEP_SEQ'])
				}
		}
}
