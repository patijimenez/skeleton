package mx.gob.inadem.api

import groovy.json.JsonSlurper
import mx.gob.inadem.*
import grails.converters.JSON
import org.apache.shiro.SecurityUtils

class ApiDeveloperController {

  def developerService
  def userService

  def executeQuery() {
    def query = request.JSON.query

    render developerService.executeQuery(query) as JSON
  }

  def editDocument() {
    def document = request.JSON.document

    def savedDocument = ApplicationDocument.load(document.id)
    savedDocument.path = document.path
    savedDocument.name = document.name
    savedDocument.save(failOnError: true, flush: true)

    def result = [saved: true]

    render result as JSON
  }

  def deleteDocument() {
    def documentId = request.JSON.documentId
    def document = ApplicationDocument.load(documentId)

    document.delete(failOnError: true)

    def result = [deleted: true]

    render result as JSON
  }

  def executeScript() {
    def script = request.JSON.script

    render developerService.executeScript(script) as JSON
  }

  def saveTempScript(){
    def script = request.JSON.script
    def key = request.JSON.key

    render developerService.saveTempScript(script, key) as JSON
  }

  def executeStoredScript() {
    def script = Script.get(request.JSON.script.id)
    def params =  request.JSON.script.mapVariables
    render developerService.executeStoredScript(script.text,params) as JSON
  }

  def getAdminScritps(){
    def user = userService.loggedUser
    def roles = user.roles
    def scriptsList = []

    def subject = SecurityUtils.getSubject()
    def scripts = Script.findAllByTrigger('ADMIN', [sort: "name"])

    if(!subject.isPermitted("*:*")){
      scripts.each {
        def scriptRoles =  it.roles
        def scriptRole =  it

        roles.each{
          if(scriptRoles.contains(it)){
            scriptsList.add(scriptRole)
          }
        }

      }
    }else{
      scriptsList = scripts
    }

    def data = scriptsList.collect{
      def row = [:]
      row.id = it.id
      row.name = it.name
      row.description = it.description
      row.generateFile = it.generateFile
      row.text = it.text
      row.mapVariables = !it.mapVariables ? null : it.mapVariables.split(",").collect{
        def r = [:]
        r.name = it
        r.value = ""
        r
      }
      row
    }

    render data as JSON
  }


    def getRunScritps(){

        def searchCriteria = request.JSON.searchCriteria ? request.JSON.searchCriteria.trim() : null
        def rows = request.JSON.maxSize
        def offset = rows * (request.JSON.currentPage - 1)

        def user = userService.loggedUser
        def String[] rolesUser =  user.roles
        def scriptsList = []

        def subject = SecurityUtils.getSubject()
        def scripts = Script.createCriteria()
        def results

        if(!subject.isPermitted("*:*")){
            println "No esta permitido"
            results = scripts {
                eq("trigger", "ADMIN")
                or{
                if(searchCriteria){
                    ilike("name", "%" + searchCriteria +"%")
                    ilike("description", "%" + searchCriteria +"%")
                }
                }

                roles{
                    and {
                        inList("name", rolesUser)
                    }
                }

                if(rows){
                    maxResults(rows)
                }
                if(offset) {
                    firstResult(offset)
                }

                order("name", "asc")
            }

        }else{

            results = scripts {
                eq("trigger", "ADMIN")
                or{
                if(searchCriteria){
                    ilike("name", "%" + searchCriteria +"%")
                    ilike("description", "%" + searchCriteria +"%")
                }
                }

                if(rows){
                    maxResults(rows)
                }
                if(offset) {
                    firstResult(offset)
                }

                order("name", "asc")
            }

        }


        def total = Script.withCriteria{
           if(!subject.isPermitted("*:*")){
                println "No esta permitido"
                    eq("trigger", "ADMIN")
                    or{
                    if(searchCriteria){
                        ilike("name", "%" + searchCriteria +"%")
                        ilike("description", "%" + searchCriteria +"%")
                     }
                    }

                roles{
                        and {
                            inList("name", rolesUser)
                        }
                    }

            }else{
               eq("trigger", "ADMIN")
               or{
               if(searchCriteria){
                   ilike("name", "%" + searchCriteria +"%")
                   ilike("description", "%" + searchCriteria +"%")
               }
               }

            }

            projections {
                count("id")
            }
        }.first()


        scriptsList = results
        println "scripts size " + results.size()

        def runscripts = scriptsList.collect{
            def row = [:]
            row.id = it.id
            row.name = it.name
            row.description = it.description
            row.generateFile = it.generateFile
            row.mapVariables = !it.mapVariables ? null : it.mapVariables.split(",").collect{
                def r = [:]
                r.name = it
                r.value = ""
                r
            }
            row.variables = !it.mapVariables ? null : it.mapVariables.split(",").collect{
                def r = it
                r
            }

            row
        }


        def data = [
                'runscripts': runscripts,
                'total': total
        ]

        render data as JSON

    }
}















