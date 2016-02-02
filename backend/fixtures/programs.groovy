import mx.gob.inadem.*

include "directions"

fixture {
	program1(Program) {
		name = "Programas de Sectores Estratégicos y Desarrollo Regional"
		direction = direction1
	}
	program2(Program) {
		name = "Programas de Desarrollo Empresarial"
		direction = direction2
	}
	program3(Program) {
		name = "Programas de Emprendedores y Financiamiento"
		direction = direction3
	}
	program4(Program) {
		name = "Programas para MIPYMES"
		direction = direction4
	}
}

