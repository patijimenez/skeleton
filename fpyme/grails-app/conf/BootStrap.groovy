import mx.gob.inadem.*

import mx.gob.inadem.service.*
import java.util.zip.*
import groovy.sql.Sql
import java.security.Security
import grails.util.Environment

import java.net.InetAddress
import java.net.UnknownHostException

class BootStrap {

  def grailsApplication
  def dataSource
  def fixtureLoader
  def schedulerService

  def init = { servletContext ->
    environments {
      development {
        // fixtureLoader.load("states")
        // loadSqlData()
        // fixtureLoader.load("roadTypes")
        // fixtureLoader.load("roles")
        // fixtureLoader.load("individualProfileTypes")
        // fixtureLoader.load("companyProfileTypes")
        // fixtureLoader.load("otherProfileTypes")
        // fixtureLoader.load("governmentProfileTypes")
        // fixtureLoader.load("severities")
        // fixtureLoader.load("origins")
        // fixtureLoader.load("evaluatorTypes")
        // fixtureLoader.load("users")
        // fixtureLoader.load("stratifications")
        // fixtureLoader.load("mailTemplate")
        // fixtureLoader.load("applicantTypes")
        // fixtureLoader.load("modalities")
        // fixtureLoader.load("opsTypes")
        // fixtureLoader.load("proposers")
      }
    }
    schedulerService.triggerStoredJobs()
    schedulerService.triggerStoredNotifications()
    schedulerService.triggerStoredProcessJobs()

    //Register deployment log
    def serverIdentifier = UUID.randomUUID().toString()
    saveDeploymentLog(serverIdentifier)
    println "**** Server Identifier #${serverIdentifier}"
    grailsApplication.metadata.'serverIdentifier' = serverIdentifier
    grailsApplication.metadata.persist()

    //Add BC provider
    Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider())
    checkLeader()
  }

  def destroy = {
    println "shutting down"
    println "shutdown completed"
  }

  def loadSqlData() {
    loadZip("exports/sepomex.zip")
    loadZip("exports/inegi.zip")
  }

  def loadZip(path) {
    def file = new ZipFile(path)

    def entry = file.entries().nextElement()

    file.getInputStream(entry).withReader { r ->
      def br = new BufferedReader(r)
      br.eachLine {
        def sql = new Sql(dataSource)
        sql.execute it
      }
    }
  }

  def saveDeploymentLog(def serverIdentifier){
    DeploymentLog.withTransaction{
      def ipAddress, hostname
      try{
        def ip = InetAddress.getLocalHost()
        ipAddress = ip.getHostAddress()
        hostname = ip.getHostName()
      }catch(UnknownHostException ex){
        ex.printStackTrace()
      }
      def deploymentLog = new DeploymentLog()
      deploymentLog.serverIdentifier = serverIdentifier
      deploymentLog.buildNumber = grailsApplication.metadata['app.buildNumber']
      deploymentLog.serverIp = ipAddress
      deploymentLog.hostname = hostname
      //deploymentLog.serverStatus = ServerStatus.RUNNING
      deploymentLog.save(flush: true)
    }
  }

  def checkLeader(){
    def buildNumber = grailsApplication.metadata['app.buildNumber']
    def serverIdentifier = grailsApplication.metadata['serverIdentifier']
    if(!isProcessesServer()){
      DeploymentLog.withTransaction{
        def deploymentLogs = DeploymentLog.findAllByBuildNumber(buildNumber)
        if(!deploymentLogs.any{ it.isLeader } ){
          println "No leader with this build $buildNumber"
          //Find leader with another build number
          def exLeaders = DeploymentLog.findAllByIsLeader(true)
          exLeaders.each {
            it.isLeader = false
            it.save(flush: true)
          }
          //Mark the leader
          def thisServer = deploymentLogs.find{ it.serverIdentifier ==  serverIdentifier }
          thisServer.isLeader = true
          thisServer.save(flush: true)
        }else{
          println "Exists leader"
          def thisServer = deploymentLogs.find{ it.serverIdentifier ==  serverIdentifier }
          thisServer.isLeader = false
          thisServer.save(flush: true)
        }
      }
    }
  }

  def isProcessesServer(){
    def instanceRoot = System.getProperty("com.sun.aas.instanceRoot")
    def processesServerConfig = AppConfig.findByName('batchProcessServerInstanceName')
    if(!Environment.isDevelopmentMode() && !(processesServerConfig && instanceRoot && instanceRoot.contains(processesServerConfig.value))){
      return false
    }
    return true
  }
}

