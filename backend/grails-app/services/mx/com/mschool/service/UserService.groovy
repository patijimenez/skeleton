package mx.com.mschool.service

import mx.com.mschool.*
import org.apache.shiro.SecurityUtils

class UserService {

  def getLoggedUser() {
    def user  = null
    try{
      def ldapDn = SecurityUtils.subject.principal
      user = User.findByLdapDn(ldapDn)
    }catch (org.apache.shiro.UnavailableSecurityManagerException ex){
      user = getAdminUser()
    }
    return user
  }

  def getAdminUser(){
    return User.findByUsername('admin@inadem.gob.mx')
  }

  def isProvider(def user){
    def isProvider = ShowcaseProvider.findByRegisteredUser(user)

    isProvider
  }

  def loggedUserIsApplicant(){
    def ldapDn = SecurityUtils.subject.principal
    def user = User.findByLdapDn(ldapDn)
    
    Applicant.exists(user.id)
  }

  def getLoggedUserType(){
    def ldapDn = SecurityUtils.subject.principal
    def user = User.findByLdapDn(ldapDn)
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
    }

    data
  }
}
