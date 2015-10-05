package mx.gob.inadem

import grails.util.Environment

class Address implements Serializable {

		String postalCode
		String street
		String settlement
    	MailingSettlement mailingSettlement
		RoadsType streetRoadsType

		String externalNumber1
		String externalNumber2
		String internalNumber

		String roadsName1
		RoadsType roadsType1

		String roadsName2
		RoadsType roadsType2

		String backRoadsName
		RoadsType backRoadsType

    	String references

		State state
		Municipality municipality
		MailingSettlementType settlementType
		Locality locality

    BigDecimal latitude
    BigDecimal longitude

		Date dateCreated
		Date lastUpdated

    static constraints = {
        latitude nullable: true
        longitude nullable: true
        internalNumber nullable: true
        locality nullable: true
        references nullable: true, length: 2000
        mailingSettlement nullable: true
        externalNumber2 nullable: true
    }

		static mapping = {
				table 'DIRECCION'

				street column: 'CALLE'
				settlement column: 'ASENTAMIENTO'
        mailingSettlement column: 'ID_ASENTAMIENTO'
				streetRoadsType column: 'ID_TIPO_VIALIDAD'
				postalCode column: 'CODIGO_POSTAL'
        externalNumber1 column: 'NUMERO_EXTERIOR1'
        externalNumber2 column: 'NUMERO_EXTERIOR2'
        internalNumber column: 'NUMERO_INTERIOR'

        references column: 'REFERENCIAS', size: 1500

				roadsName1 column: 'NOMBRE_VIALIDAD1'
				roadsType1 column: 'ID_TIPO_VIALIDAD1'
				roadsName2 column: 'NOMBRE_VIALIDAD2'
				roadsType2 column: 'ID_TIPO_VIALIDAD2'
				backRoadsName column: 'NOMBRE_VIALIDAD_POSTERIOR'
				backRoadsType column: 'ID_TIPO_VIALIDAD_POSTERIOR'
				locality column: 'ID_LOCALIDAD'

				state column: 'ID_ESTADO'
				municipality column: 'ID_MUNICIPIO'
				settlementType column: 'ID_TIPO_ASENTAMIENTO'

				id (generator:'sequence', params:[sequence:'DIR_SEQ'])

		}
}
