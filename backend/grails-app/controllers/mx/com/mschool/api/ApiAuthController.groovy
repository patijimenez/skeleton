package mx.com.mschool.api

import mx.com.mschool.exception.*

import mx.com.mschool.*
import grails.converters.JSON
import org.apache.shiro.SecurityUtils
import org.apache.shiro.crypto.SecureRandomNumberGenerator
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.subject.SimplePrincipalCollection

class ApiAuthController {

  def profileService
  def registrationService
  def cookieService
  def accreditationApplicationService

  def su = {
    def username = request.JSON.username

    def user = User.findByUsername(username)
    def outcome = true
    def error = null

    SecurityUtils.subject.session.removeAttribute("currentProfileId")

    if(user != null) {
      if(profileService.canSu(user)) {
        def collection = new SimplePrincipalCollection(user.ldapDn, "DbRealm")

        SecurityUtils.subject.runAs(collection)
        SecurityUtils.subject.session.setAttribute("previousUser", SecurityUtils.subject.previousPrincipals)
      } else {
        outcome = false
        error = "userNotAllowed"
      }
    } else {
      outcome = false
      error = "userNotExists"
    }

    def data = [
      'outcome': outcome,
      'error': error
    ]

    render data as JSON
  }

  def releaseRunAs = {
    def previousDn = SecurityUtils.subject.session.getAttribute("previousUser")

    SecurityUtils.subject.runAs(previousDn)

    SecurityUtils.subject.session.removeAttribute("previousUser")

    def data = [
      'outcome': true
    ]

    render data as JSON
  }

  def isRunAs = {
    def isRunAs = SecurityUtils.subject.session.getAttribute("previousUser") != null

    def data = [
      'outcome': isRunAs
    ]

    render data as JSON
  }

  def register = {
    def jsonRequest = request.JSON

    def data = [
      'outcome': 'registered___'
    ]

    registrationService.registerProposer(jsonRequest)


    def authToken = new UsernamePasswordToken(jsonRequest.applicant.email, jsonRequest.applicant.password as String)
    SecurityUtils.subject.login(authToken)

    def randomGenerator = new SecureRandomNumberGenerator()
    def subject = SecurityUtils.subject
    def user = User.findByUsername(jsonRequest.email)

    def xsrfToken = randomGenerator.nextBytes().toBase64()
    subject.session.setAttribute("XSRF_TOKEN", xsrfToken)

    cookieService.set('XSRF-TOKEN', URLEncoder.encode(xsrfToken, "UTF-8"), -1)


    render data as JSON
  }



  def recoverPassword = {
    def jsonRequest = request.JSON

    registrationService.recoverPassword(jsonRequest.email)

    def result = ['status':'sent']

    render result as JSON
  }

  def validatePasswordToken = {
    def jsonRequest = request.JSON
    def data = ['tokenFound':false]

    def token = UserPasswordCode.findByKey(jsonRequest.token)

    if(token) {
      def lastToken = UserPasswordCode.findAllByUser(token.user, [sort: "dateCreated", order: 'desc', max: 1])
      if(lastToken.size() > 0) {
        lastToken = lastToken.head()
        if(!lastToken.used && lastToken.key == token.key) {
          data = ['tokenFound': true]
        }
      }
    }

    render data as JSON
  }

  def validateActivationToken = {
    def jsonRequest = request.JSON
    def data = ['tokenFound':false]

    def token = UserActivationCode.findByKey(jsonRequest.token)

    if(token) {
      def lastToken = UserActivationCode.findAllByUser(token.user, [sort: "id", order: 'desc', max: 1])
      if(lastToken.size() > 0) {
        lastToken = lastToken.head()
        if(!lastToken.used && lastToken.key == token.key) {
          data = ['tokenFound': true]
        }
        lastToken.user.emailConfirmed = true
        lastToken.user.save()
        lastToken.used = true
        lastToken.save()
      }
    }

    render data as JSON
  }

  def changePassword = {
    def jsonRequest = request.JSON
    registrationService.changePassword(jsonRequest.token, jsonRequest.password)
    def data = ['changed': true]
    render data as JSON
  }

  def loggedIn = {
    def subject = SecurityUtils.getSubject()
    def data = [
      'authenticated': subject.isAuthenticated(),
      'principal': subject.getPrincipal()
    ]
    render data as JSON
  }

  def rfcExists = {
    def rfc = request.JSON.rfc
    def accId = request.JSON.accId

    def data = [
      exists: accreditationApplicationService.rfcExists(rfc, accId)
    ]

    render data as JSON
  }

  def usernameExists = {
    def jsonRequest = request.JSON
    def data = [
      'exists': User.countByUsername(jsonRequest.username) > 0
    ]
    render data as JSON
  }

  def hasPermission = {
    // broadcaster['/atmosphere/notificationBroadcast'].broadcast([message: 'Hello world!', title: 'Adios adios'])
    def jsonRequest = request.JSON
    def subject = SecurityUtils.getSubject()
		
    def data = [
      'allowed': subject.isPermitted(jsonRequest.permission)
    ]

    render data as JSON
  }

  def hasRole = {
    // broadcaster['/atmosphere/notificationBroadcast'].broadcast([message: 'Hello world!', title: 'Adios adios'])
    def jsonRequest = request.JSON
    def subject = SecurityUtils.getSubject()

    def data = [
      'allowed': subject.hasRole(jsonRequest.role)
    ]

    render data as JSON
  }

  def validateRifRFC(){
    def rfc = request.JSON.rfc
    def profileType = IndividualProfileType.findByName('Régimen de Incorporación Fiscal')
    def profiles = IndividualProfile.executeQuery('select p from IndividualProfile p where p.rfc = :rfc and p.rifSAT = true ' +
      ' and p.profileType = :profileType', [ rfc: rfc, profileType: profileType])
    def data = [ result: true ]
    if(profiles && profiles.size() > 0){
      data.result = false;
    }
    render data as JSON
  }

}
