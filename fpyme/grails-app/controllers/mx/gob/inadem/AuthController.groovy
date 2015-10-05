package mx.gob.inadem

import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.web.util.SavedRequest
import org.apache.shiro.web.util.WebUtils
import org.apache.shiro.grails.ConfigUtils
import org.apache.shiro.crypto.SecureRandomNumberGenerator
import java.net.URLEncoder

class AuthController {
  def shiroSecurityManager
  def cookieService
  def grailsApplication
  def registrationService

  def userAgentIdentService

  def index = { redirect(action: "login", params: params) }

  def login = {
    if(userAgentIdentService.isMsie()) {
      def version = Float.parseFloat(userAgentIdentService.getBrowserVersion())
      if(controllerName && version < 9) {
        redirect(uri: '/modernBrowser')
        return false
      }
    }
    return [ username: params.username, rememberMe: (params.rememberMe != null), targetUri: params.targetUri ]
  }

  def signIn = {
    //println params
    def authToken = new UsernamePasswordToken(params.username, params.password as String)
    def randomGenerator = new SecureRandomNumberGenerator()

    // Support for "remember me"
    if (params.rememberMe) {
      authToken.rememberMe = true
    }

    // If a controller redirected to this page, redirect back
    // to it. Otherwise redirect to the root URI.
    def targetUri = params.targetUri ?: "/"

    // Handle requests saved by Shiro filters.
    def savedRequest = WebUtils.getSavedRequest(request)
    if (savedRequest) {
      targetUri = savedRequest.requestURI - request.contextPath
      if (savedRequest.queryString) targetUri = targetUri + '?' + savedRequest.queryString
    }

    try{

      def user = User.findByUsername(params.username)
      /*if(user && user.createLdapEntry){
        println "Creando registro en ldap"
        registrationService.createLDAPEntryCurrentUser user.id, params.password
      }*/

      // Perform the actual login. An AuthenticationException
      // will be thrown if the username is unrecognised or the
      // password is incorrect.
      SecurityUtils.subject.login(authToken)

      def subject = SecurityUtils.subject
      def xsrfToken = randomGenerator.nextBytes().toBase64()
      subject.session.setAttribute("XSRF_TOKEN", xsrfToken)


      cookieService.set('XSRF-TOKEN', URLEncoder.encode(xsrfToken, "UTF-8"), -1)


      log.info "Redirecting to '${targetUri}'."
      redirect(uri: targetUri)
    }
    catch (AuthenticationException ex){
      // Authentication failed, so display the appropriate message
      // on the login page.
      println "Authentication failure for user '${params.username}'."
      println ex
      log.info "Authentication failure for user '${params.username}'."
      flash.message = message(code: "login.failed")

      // Keep the username and "remember me" setting so that the
      // user doesn't have to enter them again.
      def m = [ username: params.username ]
      if (params.rememberMe) {
        m["rememberMe"] = true
      }

      // Remember the target URI too.
      if (params.targetUri) {
        m["targetUri"] = params.targetUri
      }

      // Now redirect back to the login page.
      redirect(action: "login", params: m)
    }
  }



  def signOut = {

    // Log the user out of the application.
    def principal = SecurityUtils.subject?.principal
    cookieService.delete('XSRF-TOKEN')

    // For now, redirect back to the home page.
    //SecurityUtils.subject?.logout()

    //Workaround logout unknown session error
    /*SecurityUtils.subject.session.getAttributeKeys().each { key ->
      SecurityUtils.subject.session.removeAttribute(key)
    }*/

    if (ConfigUtils.getCasEnable() && ConfigUtils.isFromCas(principal)) {
      redirect(uri:ConfigUtils.getLogoutUrl())
    }else {
      redirect(uri: "/")
    }
    ConfigUtils.removePrincipal(principal)

  }

  def unauthorized = {
    render "You do not have permission to access this page."
  }
}
