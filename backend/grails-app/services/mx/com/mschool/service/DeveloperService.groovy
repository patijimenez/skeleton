package mx.com.mschool.service

import javax.script.ScriptException
import java.math.BigDecimal
import java.io.PrintStream
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import mx.com.mschool.*
import mx.com.mschool.exception.*
import org.apache.shiro.authz.annotation.RequiresPermissions
import org.apache.shiro.SecurityUtils
import org.apache.shiro.subject.*
import org.fluttercode.datafactory.impl.*
import org.springframework.transaction.annotation.*
import groovy.sql.Sql

import groovy.io.FileType

class DeveloperService {

  def applicationService
  def dataSource
  def documentService
  def profileService

  @RequiresPermissions("developer:reports")
  def listErrorTypes() {
    def errors = new ArrayList()
    errors.addAll(ErrorInfo.errorInfoList)
    errors
  }

  @RequiresPermissions("developer:script")
  def executeScript(script) {
    rawExecuteScript(script)
  }
  
  @RequiresPermissions("developer:script")
  def saveTempScript (script, name) {
    def tempScript
    if(name){
      tempScript = TempScript.findByKey(name)

      if(!tempScript){
        tempScript = new TempScript()
      }
    } else {
      tempScript = new TempScript()
    }

    tempScript.name = "TempScript-${new Date()}".toString()
    tempScript.text = script
    tempScript.key = name

    if(!tempScript.save(failOnError: true, flush: true)){
      throw new RuntimeException("Error al guardar el script temporal")
    }

    [status: true, tempScript: tempScript]
  }

  def jobExecuteScript(script){
    rawExecuteScript(script)
  }

  def rawExecuteScript(script){
    def factory = new ScriptEngineManager()
    def engine = factory.getEngineByName("groovy")
    def sw = new StringWriter()
    def pw = new PrintWriter(sw)
    def swError = new StringWriter()
    def pwError = new PrintWriter(swError)
    def baos = new ByteArrayOutputStream()
    def ps = new PrintStream(baos)
    def exceptionString
    engine.getContext().setWriter(pw)
    engine.getContext().setErrorWriter(pwError)
    try {
      engine.eval(script)
    } catch(Exception ex) {
      ex.printStackTrace(ps)
      exceptionString = baos.toString()
    }
    def result = [
        output: sw.toString(),
        errorOutput: swError.toString(),
        exception: exceptionString
    ]
    result
  }

  @RequiresPermissions("developer:script")
  def executeStoredScript(script, params) {
    def factory = new ScriptEngineManager()
    def engine = factory.getEngineByName("groovy")
    def sw = new StringWriter()
    def pw = new PrintWriter(sw)
    def swError = new StringWriter()
    def pwError = new PrintWriter(swError)
    def baos = new ByteArrayOutputStream()
    def ps = new PrintStream(baos)
    def exceptionString
    engine.getContext().setWriter(pw)
    engine.getContext().setErrorWriter(pwError)
    try {
      params.each{ variable ->
        engine.put(variable.name, variable.value)
      }
      engine.eval(script)
    } catch(Exception ex) {
      ex.printStackTrace(ps)
      exceptionString = baos.toString()
    }
    def result = [
        output: sw.toString(),
        errorOutput: swError.toString(),
        exception: exceptionString
    ]
    result
  }

  def executeOutputParamScript(script, map) {
    def factory = new ScriptEngineManager()
    def engine = factory.getEngineByName("groovy")
    engine.put('map', map)
    engine.eval(script)
    map
  }

  def executeOutputParamScript(script, object, name){
    def factory = new ScriptEngineManager()
    def engine = factory.getEngineByName("groovy")
    def sw = new StringWriter()
    def pw = new PrintWriter(sw)
    engine.getContext().setWriter(pw)
    engine.put(name, object)
    engine.eval(script)
    //println sw.toString()
    [ object, sw.toString() ]
  }

  def executeOutputAndParamScript(script, parameters, output) {
    def factory = new ScriptEngineManager()
    def engine = factory.getEngineByName("groovy")
    def sw = new StringWriter()
    def pw = new PrintWriter(sw)
    def result = null
    try{
      engine.getContext().setWriter(pw)
      engine.put('parameters', parameters)
      engine.put('output', output)
      engine.eval(script)
      //println sw.toString()
      //println ">>>>>>>>>>>>>>>>>>>"
    }catch (ScriptException ex){
      def rootException = ex
      while(rootException.getCause() != null){
        rootException =  rootException.getCause()
      }
      throw rootException
    }finally{
      result = [ output, sw.toString() ]
    }
    result
  }

  @RequiresPermissions("developer:db")
  def executeQuery(query) {
    def conn = dataSource.connection
    rawExecueteQuery(query, conn)
  }

  def jobExecuteQuery(query){
    def grailsApplication = org.codehaus.groovy.grails.commons.ApplicationHolder.getApplication()
    def dataSource = grailsApplication.mainContext.getBean("dataSource")
    def conn = dataSource.connection
    rawExecueteQuery(query, conn)
  }

  def rawExecueteQuery(query, conn){

    def pstmt
    def result
    try {
      pstmt = conn.prepareStatement(query)
      if(pstmt.execute()) {
        def (columns, resultData) = transformResult(pstmt.resultSet)
        result = ['operation':'query', 'result':resultData, 'columns': columns]
      } else {
        result = ['operation':'update', 'updateCount':pstmt.updateCount]
      }
    } finally {
      if(pstmt != null) {
        pstmt.close()
      }
      if(conn != null) {
        conn.close()
      }
    }
  }

  
  private def transformResult(def resultSet) {
    def columnCount = resultSet.metaData.columnCount
    def columns = (1..columnCount).collect {
      resultSet.metaData.getColumnName(it)
    }
    def result = []
    while(resultSet.next()) {
      result << columns.collectEntries {
        [it, resultSet.getObject(it).toString()]
      }
    }
    [columns, result]
  }
}
