package mx.gob.inadem

import grails.converters.JSON
import groovy.json.JsonSlurper

import javax.activation.MimetypesFileTypeMap

class ReportController {

    def developerService

    def generateFile() {
        def scriptParams = params

        def script = Script.get(params.id)
        def params =  params.mapVariables
        def listParams = new JsonSlurper().parseText( params )
        def result = developerService.executeStoredScript(script.text,listParams)

        println result

        if(result.getAt("errorOutput") != null && result.getAt("errorOutput") != "" ){
            def s = result.getAt("errorOutput")
            response.contentType   = "text/plain; charset=UTF-8"
            render s
        }else if(result.getAt("exception") != null && result.getAt("exception") != ""){
            def s = result.getAt("exception")
            response.contentType   = "text/plain; charset=UTF-8"
            render s
        }else{

            try{
                def tmpFilename = UUID.randomUUID().toString() + "-reportFile.csv"
                def tmpPath = "$grailsApplication.config.inadem.path.tmp/$tmpFilename"
                def tmpFile = new File(tmpPath)
                tmpFile.createNewFile()
                tmpFile.append(result.getAt("output"))

                response.setHeader "Content-disposition", "attachment; filename=${tmpFile.name}"
                response.contentType = new MimetypesFileTypeMap().getContentType(tmpFile)
                response.outputStream << tmpFile.bytes
                response.outputStream.flush()
            }catch (e){
                println(e.message)
            }

        }

    }
}
