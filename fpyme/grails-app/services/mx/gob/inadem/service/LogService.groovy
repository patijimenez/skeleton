package mx.gob.inadem.service

import org.springframework.transaction.annotation.*

import java.io.StringWriter
import java.io.PrintWriter
import java.util.concurrent.ConcurrentHashMap
import java.text.SimpleDateFormat
import mx.gob.inadem.exception.*
import mx.gob.inadem.*

import org.apache.shiro.SecurityUtils

class LogService {

  private Map<Thread, String> requestIds = new ConcurrentHashMap<Thread, String>()

  def setRequestIdForThread(String requestId) {
    requestIds.put(Thread.currentThread(), requestId)
  }

  def getRequestIdForThread() {
    requestIds.get(Thread.currentThread())
  }

  def cleanRequestId() {
    requestIds.remove(Thread.currentThread())
  }

  def attachSessionId(String operation) {
    def sessionId = buildSessionId(operation)
    setRequestIdForThread(operation)
  }

  def buildSessionId(String operation) {
    def sdf = new SimpleDateFormat("ddMMyyyy")

    def uuid = UUID.randomUUID()
    def date = new Date()
    def dateString = sdf.format(date)

    "${operation}-${dateString}-${uuid}"
  }

  def log(ErrorSeverity severity, String message) {
    def subject = SecurityUtils.subject
    def sessionId = getRequestIdForThread()
    def logMessage

    logMessage = "Execution Context => [user: ${subject.principal}, sessionId: ${sessionId}] => ${message}"

    if(severity == ErrorSeverity.FATAL) {
      log.fatal logMessage
    } else if(severity == ErrorSeverity.ERROR) {
      log.error logMessage
    } else if(severity == ErrorSeverity.WARNING) {
      log.warn logMessage
    } else if(severity == ErrorSeverity.INFO) {
      log.info logMessage
    } else if(severity == ErrorSeverity.DEBUG) {
      log.debug logMessage
    }

  }

  @Transactional(propagation=Propagation.REQUIRES_NEW)
  def logRootException(def e) {
    def key
    def errorId = "GENERAL_ERROR"
    def subject = SecurityUtils.subject
    def user = null
    def sw = new StringWriter()
    def pw = new PrintWriter(sw)

    e.printStackTrace(pw)
    pw.flush()
    pw.close()

    def stackMessage = sw.toString()

    if(subject.principal != null) {
      user = User.findByLdapDn(subject.principal)
    }
    if(e instanceof AppException) {
      def message = "${e.message} [code:${e.errorInfo.errorId},origin:${e.errorInfo.origin},user:${subject.principal}]"

      errorId = e.errorInfo.errorId

      switch(e.errorInfo.severity) {
        case ErrorSeverity.FATAL:
          log.fatal message
          break;
        case ErrorSeverity.ERROR:
          log.error message
          break;
        case ErrorSeverity.INFO:
          log.info message
          break;
        case ErrorSeverity.WARNING:
          log.warn message
          break;
        case ErrorSeverity.DEBUG:
          log.debug message
          break;
      }
      def origin = ErrorOriginCatalog.findByName(e.errorInfo.origin.toString())
      def severity = ErrorSeverityCatalog.findByName(e.errorInfo.severity.toString())
      def errorLog = new ErrorLog(key: buildSessionId(errorId),
        businessId: null,
        errorCode: e.errorInfo.errorId,
        message: stackMessage,
        user: user,
        origin: origin,
        severity: severity)
      key = errorLog.key
      try {
        errorLog.save()
      } catch(Exception ex) {
        throw new AppException(ErrorInfo.DATABASE_ERROR, "Cannot log errors to database", ex);
      }
    } else {
      log.error "Error no manejado: ${e.message} [user:${subject.principal}]", e
      def severity = ErrorSeverityCatalog.findByName("FATAL")
      def errorLog = new ErrorLog(key: buildSessionId("UNHANDLED_ERROR"),
        businessId: null,
        errorCode: "UNKNOWN",
        message: stackMessage,
        user: user,
        origin: null,
        severity: severity)
      key = errorLog.key
      errorLog.save()
    }
    key
  }

  @Transactional(propagation=Propagation.REQUIRES_NEW)
  def logUserRootException(def e, def user) {
    def key
    def errorId = "GENERAL_ERROR"
    def sw = new StringWriter()
    def pw = new PrintWriter(sw)

    e.printStackTrace(pw)
    pw.flush()
    pw.close()

    def stackMessage = sw.toString()

    if(e instanceof AppException) {
      def message = "${e.message} [code:${e.errorInfo.errorId},origin:${e.errorInfo.origin},user:${user.username}]"

      errorId = e.errorInfo.errorId

      switch(e.errorInfo.severity) {
        case ErrorSeverity.FATAL:
          log.fatal message
          break;
        case ErrorSeverity.ERROR:
          log.error message
          break;
        case ErrorSeverity.INFO:
          log.info message
          break;
        case ErrorSeverity.WARNING:
          log.warn message
          break;
        case ErrorSeverity.DEBUG:
          log.debug message
          break;
      }
      def origin = ErrorOriginCatalog.findByName(e.errorInfo.origin.toString())
      def severity = ErrorSeverityCatalog.findByName(e.errorInfo.severity.toString())
      def errorLog = new ErrorLog(key: buildSessionId(errorId),
        businessId: null,
        errorCode: e.errorInfo.errorId,
        message: stackMessage,
        user: user,
        origin: origin,
        severity: severity)
      key = errorLog.key
      try {
        errorLog.save()
      } catch(Exception ex) {
        throw new AppException(ErrorInfo.DATABASE_ERROR, "Cannot log errors to database", ex);
      }
    } else {
      log.error "Error no manejado: ${e.message} [user:${user.username}]", e
      def severity = ErrorSeverityCatalog.findByName("FATAL")
      def errorLog = new ErrorLog(key: buildSessionId("UNHANDLED_ERROR"),
        businessId: null,
        errorCode: "UNKNOWN",
        message: stackMessage,
        user: user,
        origin: null,
        severity: severity)
      key = errorLog.key
      errorLog.save()
    }
    println key
    key
  }
}
