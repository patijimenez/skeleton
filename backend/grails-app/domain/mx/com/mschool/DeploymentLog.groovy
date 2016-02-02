package mx.com.mschool

enum ServerStatus {
  RUNNING,
  STOP
}

class DeploymentLog implements Serializable {

  String buildNumber
  String serverIdentifier
  ServerStatus serverStatus
  String serverIp
  String serverPort
  String hostname
  Boolean isLeader
  Date dateCreated
  Date lastUpdated

  static constraints = {

    dateCreated nullable: true
    lastUpdated nullable: true
    buildNumber nullable: true
    isLeader nullable: true
    serverIdentifier nullable: true
    serverIp nullable: true
    hostname nullable: true
    serverPort nullable: true
    serverStatus nullable: true
  }

  static mapping = {
    table 'DEPLOYMENT_LOG'

    id (generator:'sequence', params:[sequence:'DEPLOY_LOG_SEQ'])
  }
}
