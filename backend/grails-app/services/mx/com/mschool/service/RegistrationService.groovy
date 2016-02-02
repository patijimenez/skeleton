package mx.com.mschool.service

import mx.com.mschool.exception.*
import mx.com.mschool.*
import org.springframework.transaction.annotation.*
import org.apache.commons.lang.RandomStringUtils

import sun.swing.BakedArrayList;

class RegistrationService {

  def ldapService
  def logService
  def passwordService
  def jmsService

  @Transactional(propagation=Propagation.REQUIRES_NEW)
  def changePassword(def tokenString, def password) {
    def token = UserPasswordCode.findByKey(tokenString)

    if(token) {
      def lastToken = UserPasswordCode.findAllByUser(token.user, [sort: "id", order: 'desc', max: 1])
      if(lastToken.size() > 0) {
        lastToken = lastToken.head()
        if(lastToken.used || lastToken.key != token.key) {
          throw new AppException(ErrorInfo.UNKNOWN_TOKEN, "El sistema no reconoce al token especificado")
        }

        ldapService.changePassword(lastToken.user.ldapDn, password)

        lastToken.used = true
        lastToken.save()
      }
    }
  }

  @Transactional(propagation=Propagation.REQUIRES_NEW)
  def recoverPassword(def email) {
    def user = User.findByUsername(email)
    if(!user) {
      throw new AppException(ErrorInfo.UNKNOWN_USER, "El sistema no reconoce al usuario especificado")
    }
    def token = RandomStringUtils.randomAlphanumeric(20)
    def lastToken = UserPasswordCode.findAllByUserAndUsed(user, false, [sort: "id", order: 'desc', max: 1])

    if(lastToken.size() < 1) {
      if(UserPasswordCode.countByKey(token) > 0) {
        token = RandomStringUtils.randomAlphanumeric(20)
      }
      def code = new UserPasswordCode(key: token,
        user: user)
      if(!code.save()) {
        throw new AppException(ErrorInfo.TOKEN_ERROR, "No fue posible generar el token de recuperación de password para el usuario ${user.username}")
      }
    } else {
      token = lastToken.first().key
    }

    def toName = ""

    def mailMessage = [
      'username': user.username,
      'key': 'RECUPERA_CONTRASENA',
      'to': user.username,
      'toName': toName,
      'token': token
    ] as Map

    jmsService.send("jms/mailerQueue", mailMessage)
  }

  @Transactional(propagation=Propagation.MANDATORY)
  def buildRegistrationToken(def applicant) {
    def token = RandomStringUtils.randomAlphanumeric(20)
    if(UserActivationCode.countByKey(token) > 0) {
      token = RandomStringUtils.randomAlphanumeric(20)
    }
    def code = new UserActivationCode(key: token,
      user: applicant)
    if(!code.save()) {
      throw new AppException(ErrorInfo.TOKEN_ERROR, "No fue posible generar el token para el usuario ${applicant.username}")
    }

    token
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  def createLDAPEntryCurrentUser(def applicantId, def password){
    def applicant = User.get(applicantId)
    try{
      def profileData =  profileService.buildApplicantProfile applicant
      ldapService.createUser(profileData.name,
        profileData.rfc,
        applicant.ldapDn,
        applicant.username,
        password)
    }catch(Exception ex){
      if(ex.getCause() instanceof org.forgerock.opendj.ldap.ConstraintViolationException){
        return true
      }else{
        return false
      }
    }finally{
      applicant.createLdapEntry = false
      applicant.save()
    }
    return true
  }

}
