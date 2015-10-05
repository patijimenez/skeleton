package mx.gob.inadem.service
import java.math.MathContext

import grails.util.GrailsUtil
import org.springframework.transaction.annotation.Transactional
import mx.gob.inadem.*
import mx.gob.inadem.exception.*
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import org.springframework.core.io.ClassPathResource
import grails.util.Environment


class ScriptService {

  def factory = new ScriptEngineManager()

  @Transactional(readOnly = true)
  def executeExceptionScriptsForCall(def callId, def trigger, Map params) {
    def exceptions = []
    def call = Call.load(callId)

    def scripts = call.scripts.findAll {
      it.trigger == trigger
    }

    scripts.each {
      try {
        def engine = factory.getEngineByName(it.language)
        params.each { k,v ->
          engine.put(k.toString(), v)
        }
        call.variables.each {
          engine.put(it.name, it.value)
        }
        engine.eval(it.text)
      } catch(Exception ex) {
        def e = GrailsUtil.extractRootCause(ex)
        if(e instanceof ScriptException) {
          exceptions << e
        } else {
          throw new RuntimeException("Exception in script " + it.name, ex)
        }
      }
    }

    exceptions
  }

  @Transactional(readOnly = true)
  def executeScriptsForCall(def callId, def trigger, Map params) {
    def call = Call.load(callId)
    def executed = false

    def scripts = call.scripts.grep {
      it.trigger == trigger
    }
    
    scripts.each {
      def engine = factory.getEngineByName(it.language)
      params.each { k,v ->
        engine.put(k.toString(), v)
      }
      call.variables.each {
        engine.put(it.name, it.value)
      }
      executed = true
      engine.eval(it.text)
    }

    executed
  }

  def executeClasspathScript(def path, def method, def params){
    def engine = factory.getEngineByName("groovy")
    def file  = null

    if(!Environment.isDevelopmentMode()) {
      def resource = new ClassPathResource(path)
      try{
        file = resource.getFile()
      }catch(Exception){
        throw new RuntimeException("El archivo $path no existe")
      }
    }else{
      def scriptPath = System.getProperty('user.dir') + '/grails-app/conf'
      file = new File(scriptPath + path)
    }

    if(!file){
      throw new RuntimeException("El archivo $path no existe")
    }

    def scanner = new Scanner(file)
    def classText = scanner.useDelimiter("\\Z").next()

    def scriptClass = engine.eval(classText)
    def classInstance = scriptClass.newInstance()
    def result  = classInstance."$method"(params)
    result
  }

  def executeScriptsForTrackingReport(Map trackingReportParams, def trigger){
    def executed = false

    def scripts = Script.findAllByTrigger(trigger)
    scripts.each {
      def engine = factory.getEngineByName(it.language)
      trackingReportParams.each { k,v ->
        engine.put(k.toString(), v)
      }
      executed = true
      engine.eval(it.text)
    }

    executed
  }
}
