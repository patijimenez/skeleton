package mx.com.mschool

import grails.util.Environment

class MailTemplate implements Serializable {

		String key

		String title

		String body
		String originalBody
		
		String fromMail
		String fromAlias

		static hasMany = [bccs: String]

		Date dateCreated
		Date lastUpdated

    static constraints = {
        key nullable: false, blank: false, unique: true
        title nullable: false, blank: false

				fromMail nullable: false, blank: false
				fromAlias nullable: false, blank: false
    }

		static mapping = {
				table 'CAT_PLANTILLA_CORREO'
				key name: 'LLAVE'
				title name: 'TITULO'
				sort "key"

					
        body name: 'CUERPO', type: 'text', sqlType: 'text'
        originalBody name: 'CUERPO_ORIGINAL', type: 'text', sqlType: 'text'

				fromMail name: 'EMAIL_REMITENTE'
				fromAlias name: 'NOMBRE_REMITENTE'

				hasMany joinTable: [name: 'CORREO_BCC',
                           key: 'ID_CORREO',
                           column: 'BCC']

				id (generator:'sequence', params:[sequence:'TEM_CORR_SEQ'])
		}

  String toString(){
    key
  }


}

