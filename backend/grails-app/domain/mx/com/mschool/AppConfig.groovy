package mx.com.mschool

class AppConfig {

    String name
    String value

    static constraints = {
    }

    static mapping = {
      table "CONFIGURACION"

      name column: 'NOMBRE', length: 4000
      value column: 'VALOR', length: 4000

			id (generator:'sequence', params:[sequence:'CONF_SEQ'])
    }
}
