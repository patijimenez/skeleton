import mx.gob.inadem.*

fixture {
	FATAL(ErrorSeverityCatalog) {
			name = "FATAL"
			description = "Ha ocurrido un error fatal y la aplicación no puede seguir operando."
	}
	ERROR(ErrorSeverityCatalog) {
			name = "ERROR"
			description = "Ha ocurrido un error, es muy probable que sea una situación que no se vislumbró durante el análisis y la construcción del producto."
	}
	WARNING(ErrorSeverityCatalog) {
			name = "WARNING"
			description = "Se ha encontrado un problema con la ejecución de la transacción, no parece ser un problema generalizado, al ser ejecutada de nuevo puede funcionar adecuadamente."
	}
	INFO(ErrorSeverityCatalog) {
			name = "INFO"
			description = "El nivel de INFO se utiliza para recopilar información que puede ser relevant en caso de error, no implica un error directamente."
	}
	DEBUG(ErrorSeverityCatalog) {
			name = "DEBUG"
			description = "Esta información no es relevante para la operación, se utiliza para facilitar el desarrollo al mostrar con granularidad fina lo que está ocurriendo."
	}
}
