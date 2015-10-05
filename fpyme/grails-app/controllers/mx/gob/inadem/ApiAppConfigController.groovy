package mx.gob.inadem

import grails.converters.JSON

class ApiAppConfigController {


  def getConfig() {
    def params = request.JSON.params

    def result = params.collectEntries {
      def appConfig = AppConfig.findByName(it)
      [it, appConfig?.value]
    }

    render result as JSON
  }
}
