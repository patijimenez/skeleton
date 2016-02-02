import mx.gob.inadem.*

load 'strategicSectors'

fixture {
	df(State) {
    id = 1
		name = "Distrito Federal"
    abbreviation = "DF"
    strategicSectors = []
	}
	ags(State) {
    id = 2
		name = "Aguascalientes"
    abbreviation = "Ags."
    strategicSectors = [automotriz, maquinaria, agroindustrial, construccion]
	}
	bc(State) {
    id = 3
		name = "Baja California"
    abbreviation = "BC"
    strategicSectors = [automotriz,electronicos,electrodomesticos,construccion,maquinaria,agroindustrial,mineria]
	}
	bcs(State) {
    id = 4
		name = "Baja California Sur"
    abbreviation = "BCS"
    strategicSectors = [apoyoNegocios,serviciosLogisticos,agroindustrial,turismo]
	}
	camp(State) {
    id = 5
		name = "Campeche"
    abbreviation = "Camp."
    strategicSectors = [apoyoNegocios,serviciosLogisticos,agroindustrial,turismo]
	}
	coah(State) {
    id = 6
		name = "Coahuila de Zaragoza"
    abbreviation = "Coah."
    strategicSectors = [mineria,automotriz,maquinaria,agroindustrial]
	}
	col(State) {
    id = 7
		name = "Colima"
    abbreviation = "Col."
    strategicSectors = [serviciosLogisticos, agroindustrial]
	}
	chis(State) {
    id = 8
		name = "Chiapas"
    abbreviation = "Chis."
    strategicSectors = [agroindustrial,turismo]
	}
	chih(State) {
    id = 9
		name = "Chihuahua"
    abbreviation = "Chih."
    strategicSectors = [electronicos,construccion,automotriz,mineria,maquinaria,agroindustrial]
	}
	dgo(State) {
    id = 10
		name = "Durango"
    abbreviation = "Dgo."
    strategicSectors = [mineria,productosMadera,agroindustrial]
	}
	gto(State) {
    id = 11
		name = "Guanajuato"
    abbreviation = "Gto."
    strategicSectors = [productosQuimicos,automotriz,agroindustrial,productosCuero]
	}
	gro(State) {
    id = 12
		name = "Guerrero"
    abbreviation = "Gro."
    strategicSectors = [turismo,agroindustrial]
	}
	hgo(State) {
    id = 13
		name = "Hidalgo"
    abbreviation = "Hgo."
    strategicSectors = [construccion, mineria, agroindustrial, turismo]
	}
	jal(State) {
    id = 14
		name = "Jalisco"
    abbreviation = "Jal."
    strategicSectors = [automotriz,gourmet,moda,medicos]
	}
	mex(State) {
    id = 15
		name = "México"
    abbreviation = "Mex."
    strategicSectors = [automotriz,gourmet,moda,medicos]
	}
	mich(State) {
    id = 16
		name = "Michoacán de Ocampo"
    abbreviation = "Mich."
    strategicSectors = [serviciosLogisticos,
                        agroindustrial, turismo, informacion]
	}
	Morelos(State) {
    id = 17
		name = "Morelos"
    abbreviation = "Mor."
    strategicSectors = [automotriz, investigacion, agroindustrial, turismo]
	}
	nayarit(State) {
    id = 18
		name = "Nayarit"
    abbreviation = "Nay."
    strategicSectors = [agroindustrial, turismo]
	}
	nl(State) {
    id = 19
		name = "Nuevo León"
    abbreviation = "NL"
    strategicSectors = [maquinaria, automotriz, construccion,  electronicos]
	}
	oax(State) {
    id = 20
		name = "Oaxaca"
    abbreviation = "Oax."
    strategicSectors = [agroindustrial, turismo]
	}
	Puebla(State) {
    id = 21
		name = "Puebla"
    abbreviation = "Pue."
    strategicSectors = [automotriz,maquinaria,moda]
	}
	qro(State) {
    id = 22
		name = "Querétaro"
    abbreviation = "Qro."
    strategicSectors = [biotecnologia, automotriz, electrodomesticos, apoyoNegocios]
	}
	qroo(State) {
    id = 23
		name = "Quintana Roo"
    abbreviation = "Q. Roo."
    strategicSectors = [apoyoNegocios, turismo]
	}
	slp(State) {
    id = 24
		name = "San Luis Potosí"
    abbreviation = "SLP"
    strategicSectors = [mineria,serviciosLogisticos,agroindustrial,construccion,maquinaria,turismoMedico]
	}
	sin(State) {
    id = 25
		name = "Sinaloa"
    abbreviation = "Sin."
    strategicSectors = [agroindustrial,serviciosLogisticos]
	}
	son(State) {
    id = 26
		name = "Sonora"
    abbreviation = "Son."
    strategicSectors = [electronicos,automotriz,mineria,agroindustrial]
	}
	tab(State) {
    id = 27
		name = "Tabasco"
    abbreviation = "Tab."
    strategicSectors = [apoyoNegocios,agroindustrial]
	}
	tam(State) {
    id = 28
		name = "Tamaulipas"
    abbreviation = "Tamps."
    strategicSectors = [electronicos, automotriz, maquinaria, productosQuimicos]
	}
	tlax(State) {
    id = 29
		name = "Tlaxcala"
    abbreviation = "Tlax."
    strategicSectors = [automotriz,moda, agroindustrial,turismo]
	}
	ver(State) {
    id = 30
		name = "Veracruz de Ignacio de la Llave"
    abbreviation = "Ver."
    strategicSectors = [productosQuimicos,agroindustrial, mineria]
	}
	yuc(State) {
    id = 31
		name = "Yucatán"
    abbreviation = "Yuc."
    strategicSectors = [serviciosLogisticos,turismo]
	}
	zac(State) {
    id = 32
		name = "Zacatecas"
    abbreviation = "Zac."
    strategicSectors = [mineria,agroindustrial, turismo]
	}
}
