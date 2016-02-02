package mx.com.mschool

class TempScript implements Serializable {

  String name
  String key
  String text
  User user

  Date dateCreated
  Date lastUpdated

  static constraints = {
    text widget: 'textarea'
    text nullable: true
    user nullable: true
    key nullable: true
  }

  static mapping = {
    table 'TEMPORAL_SCRIPT'

  	name column: "NOMBRE"
    key  column: "GIVE_NAME"
  	text column: "SCRIPT_BODY", sqlType : 'text'
  	user column: "USER_ID"

    id (generator:'sequence', params:[sequence:'TSCRIPT_SEQ'])
  }

  String toString() {
    name
  }

}