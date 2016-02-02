package mx.com.mschool.exception

class AppException extends RuntimeException {
		ErrorInfo errorInfo

		public AppException(ErrorInfo errorInfo) {
				this.errorInfo = errorInfo
		}

		public AppException(ErrorInfo errorInfo, String message) {
				super(message)
				this.errorInfo = errorInfo
		}

		public AppException(ErrorInfo errorInfo, String message, Throwable cause) {
				super(message, cause)
				this.errorInfo = errorInfo
		}

		public AppException(ErrorInfo errorInfo, Throwable cause) {
				super(cause)
				this.errorInfo = errorInfo
		}

}
