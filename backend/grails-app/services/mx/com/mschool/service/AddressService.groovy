package mx.com.mschool.service

import mx.com.mschool.*

class AddressService {

  def addressToString(def addr){
    def detailed = getDetailedAddress(addr)
    def addString = ""

    addString += "${detailed.street}, número ${detailed.externalNumber1}" + (detailed.internalNumber? " interior ${detailed.internalNumber}":"")
    addString += (detailed.mailingSettlement)? ", Colonia ${detailed.mailingSettlement.name}":""
    addString += (detailed.postalCode)? ", Código Postal ${detailed.postalCode}":""
    addString += (detailed.municipality)? ", Municipio de ${detailed.municipality}":""
    addString += (detailed.state)? " en el Estado de ${detailed.state}.":""

    addString.toString()
  }

  def getDetailedAddress(def addr){
  	def detailed = null

    if(addr){  
      detailed = [
        postalCode:         addr.postalCode,
        state:              addr.state?.name,
        municipality:       addr.municipality?.name,
        settlement:         addr.settlement,
        street:             addr.street,
        roadsName1:         addr.roadsName1,
        roadsName2:         addr.roadsName2,
        backRoadsName:      addr.backRoadsName,
        streetRoadsType:    addr.streetRoadsType?.name,
        roadsType1:         addr.roadsType1?.name,
        roadsType2:         addr.roadsType2?.name,
        backRoadsType:      addr.backRoadsType?.name,
        locality:           addr.locality?.name,
        latitude:           addr.latitude,
        longitude:          addr.longitude,
        externalNumber1:    addr.externalNumber1 == "null"? null:addr.externalNumber1,
        externalNumber2:    addr.externalNumber2 == "null"? null:addr.externalNumber2,
        internalNumber:     addr.internalNumber == "null"? null:addr.internalNumber,
        references:         addr.references,
        mailingSettlement:  addr.mailingSettlement? [
          id: addr.mailingSettlement.id, 
          name: addr.mailingSettlement?.name,
          type: [
            id: addr.mailingSettlement.settlementType?.id,
            name: addr.mailingSettlement.settlementType?.name
          ]
        ]:null
      ]
    } else { }
    
    detailed
  }

  def listPostalSettlements(def postalCode) {
	 def postalCodes = MailingPostalCode.findAllByPostalCode(postalCode)
   def result = []
				def settlements = postalCodes.each {
					def settlement = it.settlement
					result << ['id': settlement.id, 'name': settlement.name]
				}
				result
    }

		def listMunicipalityLocalities(def municipalityId) {
				def municipality= Municipality.load(municipalityId)
				def localities = Locality.findAllByMunicipality(municipality)

				def result = []

				localities.each {
						def data = ['id': it.id, 'name': it.name, 'latitude': it.latitude, 'longitude': it.longitude]
						result << data
				}

				result
		}

    def getSettlementData(def settlementId) {
				def settlement = MailingSettlement.load(settlementId)
				def localities = Locality.findAllByMunicipality(settlement.municipality)

				def result = [:]

				result.name = settlement.name
				result.settlementType = prepareEntity(settlement.settlementType)
				result.state = prepareEntity(settlement.state)
				result.municipality = prepareEntity(settlement.municipality)
				result.city = prepareEntity(settlement.city)
				result.localities = []

				localities.each {
						def data = ['id': it.id, 'name': it.name, 'latitude': it.latitude, 'longitude': it.longitude]
						result.localities << data
				}
				
        result
		}

		private def prepareEntity(def entity) {
        def result = null
        if(entity) {
          result = ['id': entity.id, 'name': entity.name]
        }
        result
		}

}
