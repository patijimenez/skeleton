import mx.gob.inadem.*

fixture {
	WEBAPP(ErrorOriginCatalog) {
		name = "WEBAPP"
		description = "El error se originó en la capa web de la aplicación"
	}
	DOCUMENT(ErrorOriginCatalog) {
		name = "DOCUMENT"
		description = "El error se originó en el repositorio de documentos de la aplicaión"
	}
	BPM(ErrorOriginCatalog) {
		name = "BPM"
		description = "El error se originó en el motor de procesos de la aplicación (Business Process Management)"
	}
	DATABASE(ErrorOriginCatalog) {
		name = "DATABASE"
		description = "El error se originó en la base de datos"
	}
}
