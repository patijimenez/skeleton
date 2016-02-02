package mx.com.mschool

import mx.com.mschool.service.*
import mx.com.mschool.exception.*
import org.apache.shiro.authz.AuthorizationException
import grails.converters.JSON

class ApiFilters {

		def logService

    def filters = {
        exceptions(uri: "/api/**") {
            afterView = { Exception e ->
								if(e != null) {
										def exceptionData
										def status

										def rootException = findRootCause(e)
										def errorKey = null
										def requestId = logService.getRequestIdForThread()
										logService.cleanRequestId()
										
										//We don't care about grails exceptions,
										//We need our own if possible
										if(rootException != null && rootException instanceof AppException) {
											e = rootException;
										}

										try {
											errorKey = logService.logRootException(e)
										} catch(Exception ex) {
											//Original exception has been logged
											//what matters is that we have 
											//big time problems if we cannot
											//write to the database
											//so we have to notify about
											//this exception
											e = ex
											// e.printStackTrace()
										}

										

										if(e instanceof AppException) {
											def info = e.errorInfo
											if(info == ErrorInfo.AUTHORIZATION_ERROR) {
													status = 401
											} else if(info == ErrorInfo.MALFORMED_REQUEST_ERROR) {
													status = 400
											} else {
													status = 500
											}
											exceptionData = [
												errorId: info.errorId,
												description: info.description,
												severity: info.severity,
												origin: info.origin,
												message: e.message,
												errorKey: errorKey,
												businessId: requestId
											]
										} else if (rootException instanceof AuthorizationException) {
											def info = ErrorInfo.AUTHORIZATION_ERROR
											status = 401
											exceptionData = [
												errorId: info.errorId,
												description: info.description,
												severity: info.severity,
												origin: info.origin,
												message: rootException.message,
												errorKey: errorKey,
												businessId: requestId
											]
										} else {
											status = 500
											exceptionData = [
												errorId: "UNKNOWN",
												description: "Ocurrió un error inesperado",
												severity: ErrorSeverity.FATAL,
												origin: ErrorOrigin.UNKNOWN,
												message: e.message,
												cause: e,
												errorKey: errorKey,
												businessId: requestId
											]
										}
										response.status = status
										response.contentType = "application/json"
										render exceptionData as JSON
										return false
								}
            }
        }
    }

		def findRootCause(Exception e) {
			def root = e
			while(root.cause != null) {
				if(root instanceof AppException) {
						break
				}
				root = root.cause
			}
			root
		}

}
