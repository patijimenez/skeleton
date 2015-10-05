package mx.gob.inadem.service

import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.annotation.Propagation
import mx.gob.inadem.*
import mx.gob.inadem.exception.*

class NotificationService {
  def userService
  def logService
  def jmsService

  def notify(def notification){
    def mailMessage
    def mailArray = []
    def script = notification.script
    def loggedUser = userService.getLoggedUser()
    
    mailArray = developerService.executeOutputParamScript(script.text, mailArray)
    mailArray.each { mailData ->
      def user =  User.findByUsername(mailData.email)
			def application = Application.get(mailData.applicationId)
          
			if(user){
        def sendFlag
        if(mailData.ignoreLog && mailData.ignoreLog){
          sendFlag = true
        }else{
          sendFlag = notificationSent(user, notification, application)
        }

        if(sendFlag){
          logService.attachSessionId("NOTIFICACION")
          try {
            def userData = findApplicantData(application?.applicantProfile)

            if(userData){
              mailMessage = [
                key: notification.mailTemplate.key,
                to: mailData.email,
                toName: userData.toName,
                name: userData.name,
                title: key.getName()
              ] as Map

              mailData.variables.each{ name, value ->
                mailMessage."$name" = value
              }
              def notificationLog = new NotificationLog()

              notificationLog.user = user
              notificationLog.notification =  notification
              notificationLog.application = application
              notificationLog.message = mailData.message
              notificationLog.trigger = mailData.trigger
              notificationLog.status = NotificationStatus.SENT

              notificationLog.save(failOnError : true)
              jmsService.send("jms/mailerQueue", mailMessage)
            }
          } catch(Exception ex){
            def errorKey = logService.logUserRootException(ex, loggedUser)
            def errorLog = new NotificationLog()
            errorLog.notification = notification
            errorLog.application = application
            errorLog.errorKey = errorKey
            errorLog.trigger = mailData.trigger
            errorLog.status = NotificationStatus.ERROR
            errorLog.message = "Error al notificar al usuario: ${user.username}."

            errorLog.save(failOnError : true)
          } finally {
            logService.cleanRequestId()  
          }
        }       
      } else {
        def errorKey = logService.logUserRootException(new RuntimeException("El usuario ${mailData.email} no existe"), loggedUser)
        def errorLog = new NotificationLog()
        errorLog.notification = notification
        errorLog.application = application
        errorLog.errorKey = errorKey
        errorLog.trigger = mailData.trigger
        errorLog.status = NotificationStatus.ERROR
        errorLog.message = "Error al notificar al usuario: ${user.username}. No existe "

        errorLog.save(failOnError : true) 
      }
    }
  }      
}
