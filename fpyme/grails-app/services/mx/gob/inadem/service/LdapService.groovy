package mx.gob.inadem.service

import mx.gob.inadem.util.*
import mx.gob.inadem.exception.*
import org.forgerock.opendj.ldap.*

class LdapService {

    def ldapConnectionPool
    def grailsApplication

    def findNextAvailable(String email) {
      def original = email.takeWhile { it != '@' }
      def username = original
      def nextNumber = 1

      def users = findUsers(username)

      while(users.contains(username)) {
        username = original + nextNumber
        nextNumber += 1
      }

      username
    }

    def checkUser(def userDn, def password) {
        def connection
        try {
          connection = ldapConnectionPool.connection
          def result = connection.bind(userDn, password)
          if(result.resultCode.isExceptional()) {
              throw new AppException(ErrorInfo.LDAP_ERROR, result.diagnosticMessage, result.cause)
          }
          result.isSuccess()
        } catch(Exception ex) {
          ex.printStackTrace()
        } finally {
          if(connection != null) {
            connection.close()
          }
        }
    }

    def findUsers(def uid) {
        def list = []
        def connection = ldapConnectionPool.connection
        def adminDN = grailsApplication.config.inadem.ldap.admindn
        def adminPassword = grailsApplication.config.inadem.ldap.adminpassword.toCharArray()
        try {
          def bindResult = connection.bind(adminDN, adminPassword)

          if(!bindResult.isSuccess()) {
              throw new AppException(ErrorInfo.LDAP_ERROR, "No fue posible listar las posibilidades para " + uid, result.cause)
          }

          def result = connection.search(grailsApplication.config.inadem.ldap.base, SearchScope.WHOLE_SUBTREE, "(uid=$uid*)")
          
          while(result.hasNext()) {
              if(result.isEntry()) {
                  def entry = result.readEntry()
                  list << entry.name.rdn().firstAVA.attributeValue.toString()
              }
          }

        } finally {
          connection.close()
        }
        list
    }

    def changePassword(def uid, def password) {
        def connection = ldapConnectionPool.connection
        def adminDN = grailsApplication.config.inadem.ldap.admindn
        def adminPassword = grailsApplication.config.inadem.ldap.adminpassword.toCharArray()
        def cryptPassword = CryptoUtil.getSaltedPassword(password.getBytes("UTF-8"))
        try {
          def bindResult = connection.bind(adminDN, adminPassword)
          if(!bindResult.isSuccess()) {
              throw new AppException(ErrorInfo.LDAP_ERROR, "No fue posible modificar el password de " + uid, result.cause)
          }

          def result = connection.search(grailsApplication.config.inadem.ldap.base, SearchScope.WHOLE_SUBTREE, "(uid=$uid)")
          
          if(!result.hasNext()) {
              throw new AppException(ErrorInfo.LDAP_NOT_FOUND, "No fue posible modificar el password de " + uid)
          }

          def entry = result.readEntry()
          def old = TreeMapEntry.deepCopyOfEntry(entry)
          def request

          entry.removeAttribute("userPassword")
          request = Entries.diffEntries(old, entry)
          connection.modify(request)

          old = TreeMapEntry.deepCopyOfEntry(entry)
          entry = entry.addAttribute("userPassword", cryptPassword)
          request = Entries.diffEntries(old, entry)
          connection.modify(request)

        } finally {
          connection.close()
        }
    }

    def createUser(def name, def lastNames, def username, def email, def password) {
        def adminDN = grailsApplication.config.inadem.ldap.admindn
        def adminPassword = grailsApplication.config.inadem.ldap.adminpassword.toCharArray()
        def cryptPassword = CryptoUtil.getSaltedPassword(password.getBytes("UTF-8"))
        def entry = new LinkedHashMapEntry("uid=$username,$grailsApplication.config.inadem.ldap.base").
                      addAttribute("cn", "$name $lastNames").
                      addAttribute("objectclass", "inetOrgPerson").
                      addAttribute("sn", lastNames).
                      addAttribute("mail", email).
                      addAttribute("userPassword", cryptPassword)
        def connection = ldapConnectionPool.connection
        try {
          def result = connection.bind(adminDN, adminPassword)
          if(result.resultCode.isExceptional()) {
              throw new AppException(ErrorInfo.LDAP_ERROR, result.diagnosticMessage, result.cause)
          }

          connection.add(entry)

        } finally {
          connection.close()
        }

    }

}
