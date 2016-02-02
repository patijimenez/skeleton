package mx.com.mschool

import mx.com.mschool.*
import mx.com.mschool.exception.*
import grails.converters.JSON

class ApiUserController {
    def userService
    def hazelcastInstance

    def getUserType(){
      def user = userService.getLoggedUser()
      def data = [:]

      if(LegalDeptUser.exists(user.id)){
        data.type = 'JURIDICO'
        data.subType =  user.type.name
      } else if(Evaluator.exists(user.id)){
        data.type = 'EVALUADOR'
        data.subType =  user.evaluatorType.name
      } else if(OpsUser.exists(user.id)) {
        data.type = 'INTERNO'
        data.subType =  user.userType.name
      } else if(Applicant.exists(user.id)){
        data.type = 'SOLICITANTE'
        data.subType =  ''
      } else if(TrackingUser.exists(user.id)){
        data.type = 'SEGUIMIENTO'
        data.subType =  user.type.name
      }

      render data as JSON
    }

    def getSessionsData() {
      def sessionMap = hazelcastInstance.getDistributedObjects().first()

      def dnKey = "org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY"

      def totalSessions = sessionMap.size()

      def anonymousSessions = sessionMap.values().grep {
        !it.getAttribute(dnKey)
      }.size()

      def result = [
        totalSessions: totalSessions,
        anonymousSessions: anonymousSessions,
        loggedInSessions: totalSessions - anonymousSessions
      ]

      render result as JSON
    }

    def endSession() {
      def key = request.JSON.key
      def sessionMap = hazelcastInstance.getDistributedObjects().first()

      sessionMap.delete(key)

      def result = [deleted: true]

      render result as JSON
    }

    def getSessions() {
      def sessions = [:]
      def sessionMap = hazelcastInstance.getDistributedObjects().first()

      def dnKey = "org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY"
      def agentKey = "org.geeks.browserdetection.UserAgentIdentService_agentInfo"
      sessionMap.keySet().collect {
        it
      }.grep {
        sessionMap[it].getAttribute(dnKey)
      }.each {
        def agent = sessionMap[it].getAttribute(agentKey)

        sessions[it] = [
          key: it,
          startTime: sessionMap[it].getStartTimestamp(),
          lastAccess: sessionMap[it].getLastAccessTime(),
          agent: [
            browser: agent.browser?.name(),
            version: agent.browserVersion?.version,
            operatingSystem: agent.operatingSystem?.name()
          ],
          user: sessionMap[it].getAttribute(dnKey)?.primaryPrincipal
        ]
      }

      render sessions as JSON
    }

    def getDispatchInformationByUser(){
      def loggedUser = userService.loggedUser

      def dispatch = [
        id: loggedUser.dispatch.id, 
        validationType: loggedUser.dispatch.validationType, 
        name: loggedUser.dispatch.name
      ]

      render dispatch as JSON
    }
}
