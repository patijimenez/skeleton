package mx.gob.inadem.api

import org.apache.shiro.SecurityUtils

import grails.converters.JSON

import mx.gob.inadem.*

class ApiMessageController {

    def listCurrentMessages() {
      def when = new Date()
      def messages = EventMessage.withCriteria {
        ge("validTo", when)
        lt("validFrom", when)
      }
      render messages as JSON
    }

    def listCallMessages() {
      def ldapDn = SecurityUtils.subject?.principal
      //def messages = EventMessage.findAll("from EventMessage as e where e.specificCall in (select a.mainCall from Application a where a.applicantProfile in (from ApplicantProfile p where p.applicant.ldapDn = :dn))", [dn: ldapDn])
      render messages as JSON

    }

    def listLastMessages() {
      def maxElements = request.JSON.maxElements
      def messages = EventMessage.list(max: maxElements, sort: "validFrom", order: "desc")
      render messages as JSON
    }
}
