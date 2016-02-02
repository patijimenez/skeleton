package mx.com.mschool

import grails.util.Environment

class MailingSettlementType implements Serializable {

		String name

		Date dateCreated
		Date lastUpdated

    static constraints = {
        name nullable: false, blank: false, unique: true, email: true
    }

		static mapping = {
				table 'CAT_SEPOMEX_TIPO_ASENTAMIENTO'
        cache 'read-only'
				name column: 'NOMBRE'
				sort "name"
				if(!Environment.isDevelopmentMode()) {
						id (generator:'sequence', params:[sequence:'TASE_SEP_SEQ'])
				}
		}

    String toString() {
        name
    }

}
