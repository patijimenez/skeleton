package mx.com.mschool.exception

enum ErrorSeverity {
		UNKNOWN,
		FATAL,
		ERROR,
		WARNING,
		INFO,
		DEBUG
}

enum ErrorOrigin {
		UNKNOWN,
		WEBAPP,
		DOCUMENT,
		BPM,
		DATABASE,
    LDAP
}

class ErrorInfo {

		static final List<ErrorInfo> errorInfoList = new ArrayList<ErrorInfo>();

  //Application Errors
    public static final ErrorInfo APPLICATION_VALDIATION_ERROR =
      new ErrorInfo("APPLICATION_VALDIATION_ERROR","""\
  Ocurrió un error en la validación de reglas de negocio""",
      ErrorSeverity.ERROR,
      ErrorOrigin.WEBAPP)

  public static final ErrorInfo APPLICATION_UNKNOWN_ERROR =
    new ErrorInfo("APPLICATION_UNKNOWN_ERROR","""\
  Ocurrió un error desconocido en el proceso""",
      ErrorSeverity.ERROR,
      ErrorOrigin.WEBAPP)


  public static final ErrorInfo XSRF_ERROR =
			new ErrorInfo("XSRF_ERROR", """\
  Ocurrió un error al validar el token de xsrf""",
				ErrorSeverity.DEBUG,
        ErrorOrigin.WEBAPP)
    public static final ErrorInfo XAUTH_ERROR =
      new ErrorInfo("XAUTH_ERROR", """\
  Ocurrió un error al validar el token de X-Auth""",
        ErrorSeverity.DEBUG,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo SESSION_ERROR = 
			new ErrorInfo("SESSION_ERROR", """\
El usuario no tiene sesion en el sistema""",
				ErrorSeverity.DEBUG,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo UNKNOWN_USER = 
			new ErrorInfo("UNKNOWN_USER", """\
El usuario especificado no existe en el sistema""",
				ErrorSeverity.DEBUG,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo UNKNOWN_TOKEN = 
			new ErrorInfo("UNKNOWN_TOKEN", """\
El token especificado no existe en el sistema""",
				ErrorSeverity.WARNING,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo UNKNOWN_APPLICANT_TYPE = 
			new ErrorInfo("UNKNOWN_APPLICANT_TYPE", """\
El token especificado no existe en el sistema""",
				ErrorSeverity.ERROR,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo XSRF_ATTACK_ERROR = 
			new ErrorInfo("XSRF_ATTACK_ERROR", """\
Hay posibilidades de un ataque de XSRF ocurriendo al servidor""",
				ErrorSeverity.WARNING,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo AUTHORIZATION_ERROR = 
			new ErrorInfo("AUTHORIZATION_ERROR", """\
El usuario no tiene permiso de ejecutar la acción requerida""",
				ErrorSeverity.INFO,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo DATABASE_ERROR = 
			new ErrorInfo("DATABASE_ERROR", """\
Ha ocurrido un error de acceso a datos, es posible que el servicio en general se vea afectado.""",
				ErrorSeverity.FATAL,
        ErrorOrigin.DATABASE)
		public static final ErrorInfo MALFORMED_REQUEST_ERROR = 
			new ErrorInfo("MALFORMED_REQUEST_ERROR", """\
La petición enviada por el usuario es diferente a lo que requiere la aplicación""",
				ErrorSeverity.DEBUG,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo FIEL_MOVED_ERROR = 
			new ErrorInfo("FIEL_MOVED_ERROR", """\
La fiel no se encuentra en el lugar donde se subió, posiblemente ocurrió algun error o se elminó manualmente, intente cargarla de nuevo.""",
				ErrorSeverity.INFO,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo FIEL_ERROR = 
			new ErrorInfo("FIEL_ERROR", """\
Hay un problema con la FIEL del usuario, es posible que el archivo esté corrupto o no sea una FIEL válida""",
				ErrorSeverity.INFO,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo NOT_FIEL_ERROR = 
			new ErrorInfo("NOT_FIEL_ERROR", """\
Hay un problema con la FIEL del usuario, a pesar de ser un certificado X.509 válido no es confiable ya que no fue emitida por el SAT.""",
				ErrorSeverity.INFO,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo INCORRECT_PROFILE_ERROR = 
			new ErrorInfo("INCORRECT_PROFILE_ERROR", """\
El perfil que tiene el usuario no corresponde al especificado""",
				ErrorSeverity.ERROR,
        ErrorOrigin.DATABASE)
		public static final ErrorInfo TOKEN_ERROR = 
			new ErrorInfo("TOKEN_ERROR", """\
No fue posible generar un token para el usuario""",
				ErrorSeverity.INFO,
        ErrorOrigin.DATABASE)
		public static final ErrorInfo PARAM_ERROR = 
			new ErrorInfo("PARAM_ERROR", """\
Alguno de los parametros de la URL es incorrecto""",
				ErrorSeverity.INFO,
        ErrorOrigin.WEBAPP)
		public static final ErrorInfo UNKNOWN_ERROR = 
			new ErrorInfo("UNKNOWN_ERROR", """\
Ha ocurrido un error que no fue detectado en tiempo de desarrollo, y por lo tanto no está manejado""",
				ErrorSeverity.FATAL,
        ErrorOrigin.UNKNOWN)
		public static final ErrorInfo BACKOFFICE_ERROR =
			new ErrorInfo("BACKOFFICE_ERROR", """\
Ha ocurrido un error con el usuario backoffice.""",
				ErrorSeverity.DEBUG,
		ErrorOrigin.WEBAPP)
		public static final ErrorInfo REGISTRATION_ERROR =
			new ErrorInfo("REGISTRATION_ERROR", """\
Ha ocurrido un error con el usuario.""",
				ErrorSeverity.WARNING,
		ErrorOrigin.WEBAPP)
		public static final ErrorInfo PROFILE_DATA_ERROR =
			new ErrorInfo("PROFILE_DATA_ERROR", """\
Ha ocurrido un error al obtener la información del usuario.""",
				ErrorSeverity.FATAL,
		ErrorOrigin.UNKNOWN)


    //Document exceptions
		public static final ErrorInfo DOCUMENT_LOGIN = 
			new ErrorInfo("DOCUMENT_LOGIN", """\
No fue posible acceder al repositorio de documentos con el usuario especificado""",
				ErrorSeverity.WARNING,
        ErrorOrigin.DOCUMENT)
		public static final ErrorInfo DOCUMENT_LOGOUT = 
			new ErrorInfo("DOCUMENT_LOGOUT", """\
No fue posible hacer logout del repositorio de documentos""",
				ErrorSeverity.WARNING,
        ErrorOrigin.DOCUMENT)
		public static final ErrorInfo DOCUMENT_INVALID_TYPE = 
			new ErrorInfo("DOCUMENT_INVALID_TYPE", """\
El tipo de documento no es el adecuado""",
				ErrorSeverity.WARNING,
        ErrorOrigin.DOCUMENT)
		public static final ErrorInfo DOCUMENT_INVALID_SESSION = 
			new ErrorInfo("DOCUMENT_INVALID_SESSION", """\
El token de sesión es inválido""",
				ErrorSeverity.WARNING,
        ErrorOrigin.DOCUMENT)
		public static final ErrorInfo DOCUMENT_ADMIN_LOGIN = 
			new ErrorInfo("DOCUMENT_ADMIN_LOGIN", """\
No fue posible iniciar sesión de administrador""",
				ErrorSeverity.WARNING,
        ErrorOrigin.DOCUMENT)
		public static final ErrorInfo DOCUMENT_INVALID_CONFIG = 
			new ErrorInfo("DOCUMENT_INVALID_CONFIG", """\
No existe el arhivo alfresco/webservices.properties""",
				ErrorSeverity.FATAL,
        ErrorOrigin.DOCUMENT)
		public static final ErrorInfo DOCUMENT_CREATE_USER = 
			new ErrorInfo("DOCUMENT_CREATE_USER", """\
No fue posible crear al usuario en el repositorio de documentos""",
				ErrorSeverity.FATAL,
        ErrorOrigin.DOCUMENT)
		public static final ErrorInfo DOCUMENT_DELETE_USER = 
			new ErrorInfo("DOCUMENT_DELETE_USER", """\
No fue posible eliminar al usuario en el repositorio de documentos""",
				ErrorSeverity.FATAL,
        ErrorOrigin.DOCUMENT)
		public static final ErrorInfo DOCUMENT_CREATE_GROUP = 
			new ErrorInfo("DOCUMENT_GROUP_USER", """\
No fue posible crear al grupo en el repositorio de documentos""",
				ErrorSeverity.FATAL,
        ErrorOrigin.DOCUMENT)
		public static final ErrorInfo DOCUMENT_DELETE_GROUP = 
			new ErrorInfo("DOCUMENT_DELETE_GROUP", """\
No fue posible eliminar al grupo en el repositorio de documentos""",
				ErrorSeverity.FATAL,
        ErrorOrigin.DOCUMENT)
		public static final ErrorInfo DOCUMENT_GROUPS = 
			new ErrorInfo("DOCUMENT_GROUPS", """\
No fue posible hacer la operacion con los grupos del repositorio documental""",
				ErrorSeverity.WARNING,
        ErrorOrigin.DOCUMENT)
		public static final ErrorInfo LDAP_ERROR = 
			new ErrorInfo("LDAP_ERROR", """\
Ha ocurrido un error grave alconectarse con LDAP""",
				ErrorSeverity.FATAL,
        ErrorOrigin.LDAP)
		public static final ErrorInfo LDAP_NOT_FOUND = 
			new ErrorInfo("LDAP_NOT_FOUND", """\
El usuario especificado no existe en LDAP""",
				ErrorSeverity.WARNING,
        ErrorOrigin.LDAP)
		public static final ErrorInfo PROPOSER_NOT_FOUND = 
			new ErrorInfo("PROPOSER_NOT_FOUND", """\
El proponente requerido no existe""",
				ErrorSeverity.FATAL,
        ErrorOrigin.DATABASE)
		public static final ErrorInfo UNASSIGNED_USER = 
			new ErrorInfo("UNASSIGNED_USER", """\
El usuario no puede ejecutar la tarea elegida.""",
				ErrorSeverity.WARNING,
        ErrorOrigin.WEBAPP)
    public static final ErrorInfo APPLICATION_AUTHORIZATION_ERROR =
        new ErrorInfo("APPLICATION_AUTHORIZATION_ERROR", """\
El usuario no tiene permiso de abrir la solicitud requerida""",
                ErrorSeverity.INFO,
                ErrorOrigin.WEBAPP)

		String errorId
		String description
		ErrorSeverity severity
		ErrorOrigin origin

		public ErrorInfo(String errorId,
										 String description,
										 ErrorSeverity severity,
										 ErrorOrigin origin) {
				this.errorId = errorId
				this.description = description
				this.severity = severity
				this.origin = origin

        errorInfoList.add(this)
		}
}

