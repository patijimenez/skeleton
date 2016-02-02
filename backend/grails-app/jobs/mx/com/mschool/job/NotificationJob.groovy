package mx.com.mschool.job

import mx.com.mschool.*
import mx.com.mschool.exception.*
import mx.com.mschool.service.*
import org.quartz.Job;
import org.quartz.JobKey;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


class NotificationJob implements org.quartz.Job {
	def logService
	public static final String NOTIFICATION = "NOTIFICACION"

  public void execute(JobExecutionContext context) throws JobExecutionException {
    def grailsApplication = org.codehaus.groovy.grails.commons.ApplicationHolder.getApplication()
    def developerService = grailsApplication.mainContext.getBean("developerService")
    def jmsService = grailsApplication.mainContext.getBean("jmsService")
    logService = grailsApplication.mainContext.getBean("logService")

    JobKey key = context.getJobDetail().getKey()
    JobDataMap dataMap = context.getJobDetail().getJobDataMap()

    logService.attachSessionId("NOTIFICACION")
    try{
      Notification.withTransaction {
        def notificationId = dataMap.getLongValue("notificationId")
        def notification = Notification.get(notificationId)

        def mailMessage
        def mailArray = []
        def script = notification.script
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
                  notificationLog.status = NotificationStatus.SENT

                  notificationLog.save(failOnError : true)
                  jmsService.send("jms/mailerQueue", mailMessage)
                }
              } catch(Exception ex){
                def errorKey = logService.logUserRootException(ex, user)
                def errorLog = new NotificationLog()
                errorLog.notification = notification
                errorLog.application = application
								errorLog.errorKey = errorKey
                errorLog.status = NotificationStatus.ERROR

                errorLog.save(failOnError : true)
              }
            }
          } else {
            def errorLog = new NotificationLog()
            errorLog.user = user
            errorLog.notification = notification
            errorLog.application = application
            errorLog.status = NotificationStatus.ERROR
            errorLog.message = "El usuario es nulo para el folio no se puede realizar la notificación."

            errorLog.save(failOnError : true)
					}
        }
      }
    }catch(Exception ex){
      logService.logUserRootException(ex, User.findByUsername("admin@inadem.gob.mx"))
    } finally {
      logService.cleanRequestId()
    }
  }

  def notificationSent(def user, def notification, def application){
    def notificationLog
    if(application) notificationLog = NotificationLog.findByUserAndNotificationAndApplication(user, notification, application)
    else notificationLog = NotificationLog.findByUserAndNotification(user, notification)
    notificationLog ? false : true
  }

}
