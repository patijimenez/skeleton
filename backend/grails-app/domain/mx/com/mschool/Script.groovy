package mx.com.mschool

import grails.util.Environment

class Script implements Serializable {

  String name
  String text
  String language
  String trigger
  String mapVariables
  String description
  String file
  Boolean generateFile

  static hasMany = [variables: ScriptVariable,roles:Role]

  static constraints = {
    text widget: 'textarea'
    description widget: 'textarea'
    mapVariables nullable: true
    description nullable: true
    file nullable: true
    text nullable:true
    generateFile nullable:true
  }

  static mapping = {
    table 'SCRIPT'

    language column: 'LENGUAJE'
    name column:'NOMBRE'
    trigger column: 'SCR_TRIGGER'
    mapVariables column: 'MAPA_VARIABLES'
    description column: 'DESCRIPCION'
    file column: 'ARCHIVO'
    generateFile column: 'GENERAR_ARCHIVO'
    id (generator:'sequence', params:[sequence:'SCRIPT_SEQ'])
  }

  String toString() {
    name
  }

}
