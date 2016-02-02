package mx.com.mschool

import grails.util.Environment

class User implements Serializable {
  String ldapDn
  String username
  Boolean emailConfirmed = false
  Boolean active         = true  //Para usuarios internos
  Boolean finishedProfile = false
  Boolean emprendeTIC
  Boolean createLdapEntry = false

  Date birthday

  Date dateCreated
  Date lastUpdated

  static hasMany = [ roles: Role, permissions: String ]

  static constraints = {
    username nullable: false, blank: false, unique: true, email: true
    ldapDn nullable: true
    birthday nullable: true
    emprendeTIC nullable: true
    createLdapEntry nullable: true
  }

  static mapping = {
    table "USUARIO"
    discriminator value: 'GENERICO'
    tablePerHierarchy false

    username column: "USUARIO"

    emailConfirmed column: "CORREO_CONFIRMADO"
    active column: "ACTIVO"
    finishedProfile column: "REGISTRO_TERMINADO"
    birthday column: 'CUMPLE'


    roles joinTable: [name: "USUARIO_ROL", key: "ID_USUARIO", column: "ID_ROL"]
    permissions joinTable: [name: "USUARIO_PERMISO", column: "PERMISO"]


    id (generator:'sequence', params:[sequence:'US_SEQ'])
  }

  String toString() {
    username
  }

}
