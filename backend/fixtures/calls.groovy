import mx.gob.inadem.*

include "programs"

fixture {
	call1(Call) {
		name = "1.1 Desarrollo de Proveedores"
    callPath = "/INADEM/2013/Convocatorias/11.pdf"
		program = program1
		needsElectronicSignature = true
		maxBudget = 300000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call2(Call) {
		name = "1.2 Competitividad Regional"
		callPath = "/INADEM/2013/Convocatorias/12.pdf"
		program = program1
		needsElectronicSignature = true
		maxBudget = 675000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call3(Call) {
		name = "1.3 Reactivación Económica"
		callPath = "/INADEM/2013/Convocatorias/13.pdf"
		program = program1
		needsElectronicSignature = true
		maxBudget = 150000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call4(Call) {
		name = "1.4 Reactivación Económica para el Programa Nacional para la Prevención Social de la Violencia y la Delincuencia y la Cruzada Nacional contra el Hambre"
		callPath = "/INADEM/2013/Convocatorias/14.pdf"
		program = program1
		needsElectronicSignature = true
		maxBudget = 250000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call5(Call) {
		name = "2.1 Creación y Fortalecimiento de Redes Estatales de Puntos para Mover a México"
		callPath = "/INADEM/2013/Convocatorias/21.pdf"
		program = program2
		needsElectronicSignature = true
		maxBudget = 300000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call6(Call) {
		name = "2.2 Creación, Fortalecimiento de incubadoras de Empresas y Esquemas No Tradicionales de Incubación"
		callPath = "/INADEM/2013/Convocatorias/22.pdf"
		program = program2
		needsElectronicSignature = true
		maxBudget = 675000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call7(Call) {
		name = "2.3 Creación y fortalecimiento de aceleradoras de empresas"
		callPath = "/INADEM/2013/Convocatorias/23.pdf"
		program = program2
		needsElectronicSignature = true
		maxBudget = 150000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call8(Call) {
		name = "2.4 Realización de eventos que promuevan los sectores estratégicos, los encadenamientos productivos y el espíritu emprendedor"
		callPath = "/INADEM/2013/Convocatorias/24.pdf"
		program = program2
		needsElectronicSignature = true
		maxBudget = 250000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call9(Call) {
		name = "Realización de Campañas y Talleres de Sensibilización para la Cultura Emprendedora y Desarrollo de Habilidades Empresariales"
		callPath = "/INADEM/2013/Convocatorias/24-2.pdf"
		program = program2
		needsElectronicSignature = true
		maxBudget = 250000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call10(Call) {
		name = "2.4 Fomento a las Iniciativas de Innovación"
		callPath = "/INADEM/2013/Convocatorias/24-3.pdf"
		program = program2
		needsElectronicSignature = true
		maxBudget = 250000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call11(Call) {
		name = "2.4 Bonos al Ingenio, Innovación e Inventiva para Emprendedores y Microempresas"
		callPath = "/INADEM/2013/Convocatorias/24-4.pdf"
		program = program2
		needsElectronicSignature = true
		maxBudget = 250000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call12(Call) {
		name = "Asesoría para el Acceso al Financiamiento"
		callPath = "/INADEM/2013/Convocatorias/24-5.pdf"
		program = program3
		needsElectronicSignature = true
		maxBudget = 250000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call13(Call) {
		name = "Programa de Desarrollo del Ecosistema de Capital Emprendedor"
		callPath = "/INADEM/2013/Convocatorias/24-6.pdf"
		program = program3
		needsElectronicSignature = true
		maxBudget = 250000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call14(Call) {
		name = "Impulso a emprendedores y empresas a través del Programa de Emprendimiento de Alto Impacto"
		callPath = "/INADEM/2013/Convocatorias/24-7.pdf"
		program = program3
		needsElectronicSignature = true
		maxBudget = 250000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call15(Call) {
		name = "Formación de Capacidades"
		callPath = "/INADEM/2013/Convocatorias/24-8.pdf"
		program = program4
		needsElectronicSignature = true
		maxBudget = 250000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call16(Call) {
		name = "Otorgamiento de Apoyos para la generación de empleos en nuevos puntos de venta de Franquicias"
		callPath = "/INADEM/2013/Convocatorias/24-9.pdf"
		program = program4
		needsElectronicSignature = true
		maxBudget = 250000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call17(Call) {
		name = "Integración de MIPYMES a las cadenas productivas globales"
		callPath = "/INADEM/2013/Convocatorias/24-10.pdf"
		program = program4
		needsElectronicSignature = true
		maxBudget = 250000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
	call18(Call) {
		name = "Desarrollo de la Oferta Exportable"
		callPath = "/INADEM/2013/Convocatorias/24-11.pdf"
		program = program4
		needsElectronicSignature = true
		maxBudget = 250000000
		startingDate = new Date()
		closingDate = new Date() + 1
    exclusionaryModality = true
	}
}

