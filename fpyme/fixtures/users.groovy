import mx.gob.inadem.*

include "externalTypes"

fixture {
	Admin(ExternalUser) {
		username = "admin@inadem.gob.mx"
    name = "Admin"
    lastName = "Admin"
    secondLastName = ""
		active = true
    finishedProfile = false
		emailConfirmed = true
		permissions = ["*:*"]
    position = "Coordinador"
    rfc = "LEZJ810703CY9"
    curp = "LEZJ810703HDFNRL07"
    ldapDn = "admin"
    type = otro
	}
	Edu(ExternalUser) {
		username = "iamedu@gmail.com"
    name = "Eduardo"
    lastName = "Díaz"
    secondLastName = "Real"
		active = true
    finishedProfile = false
		emailConfirmed = true
		permissions = ["*:*"]
    position = "Developer"
    rfc = "DIRE880105GA4"
    curp = "DIRE880105HDFZLD00"
    ldapDn = "iamedu"
    type = otro
	}
}

