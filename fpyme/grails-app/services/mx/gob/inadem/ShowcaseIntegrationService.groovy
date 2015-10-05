package mx.gob.inadem

import grails.converters.JSON

import groovyx.net.http.HTTPBuilder

import static groovyx.net.http.Method.GET
import static groovyx.net.http.Method.POST
import static groovyx.net.http.ContentType.ANY
import static groovyx.net.http.ContentType.JSON
import grails.converters.JSON
import groovy.json.JsonOutput
import java.text.SimpleDateFormat
import groovyx.net.http.ContentType
import mx.gob.inadem.exception.*
import org.apache.shiro.codec.Hex

import groovyx.net.http.HttpResponseException

class ShowcaseIntegrationService {

  private static final String SHOWCASE_SERVICE = "servicioVitrina"
  private static final String START_ACCREDITATION = "servicioIniciaAcreditacion"
  private static final String FINISH_ACCREDITATION = "servicioConcluyeAcreditacion"

  def logService

  def lookupProduct(def productId, def callStrId) {
    def serviceUrl = ServiceUrl.findByServiceName(SHOWCASE_SERVICE)

    def http = new HTTPBuilder(serviceUrl.host)
    def data

    try {
      data = http.request(GET, ANY) { req -> 
        uri.path = "${serviceUrl.path}/$callStrId/$productId"
      }
    } catch(groovyx.net.http.ResponseParseException ex) {
      //ex.printStackTrace()
      data = null
    }

    data
  }

  /**
   * Invocar el servicio de inicio de acreditacion de infotec
   * @param accreditationId
   * @param params
   * @return
   */
  def invokeStartAccreditationInfotec(def accreditationId, def params){
    def accreditation = AccreditationApplication.get(accreditationId)
    def serviceUrl =  ServiceUrl.findByServiceName(START_ACCREDITATION)
    def sdf = new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "MX"))

    def http = new HTTPBuilder(serviceUrl.host)

    def data
    def rfc

    if(accreditation){
      rfc = accreditation.denominationRfc ? accreditation.denominationRfc : accreditation.rfc
    }else{
      rfc = params.RFC
    }

    def bodyRequest = [
      RFC: rfc,
      Fecha_Inicio_Acreditacion: accreditation ? sdf.format(accreditation.lastUpdated) : sdf.format(new Date()),
      Estatus_Acreditacion: accreditation ? accreditation.status.toString() : null,
      Folio_Solicitud: accreditation ? accreditation.folio_infotec.toString() : params.Folio_Solicitud.toString(),
      Estatus: params.estatus,
      Iteracion: params.Iteracion.toString(),
      Documentos_Acreditacion: params.files//params.filesNotDownloaded
    ]

    def json = JsonOutput.toJson(bodyRequest)
    println json

    try{
      data = http.request( POST ) { req ->
        headers.'X-AUTH-TOKEN' = serviceUrl.authToken
        uri.path = serviceUrl.path
        requestContentType = ContentType.JSON
        body = json
      }
    }catch(Exception ex) {
      ex.printStackTrace()
      data = null
    }
    if(data){
      println data
    }
    true
  }

  /**
   *
   * @param accreditationId
   * @return
   */
  def closeAccreditation(def accreditationId){
    def acc = AccreditationApplication.get(accreditationId)
    def serviceUrl =  ServiceUrl.findByServiceName(FINISH_ACCREDITATION)
    def sdf = new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "MX"))

    def http = new HTTPBuilder(serviceUrl.host)

    def rfc  = acc.denominationRfc ? acc.denominationRfc : acc.rfc

    def  files = [:]

    acc.legalDocuments.each{
      if(it.legalDocument.idInfotec){
        files.put((it.legalDocument.idInfotec), Hex.encodeToString(it.path.getBytes("UTF-8")))
      }
    }

    def accreditationStatus
    if(acc.status == AccreditationStatus.REJECTED || acc.status == AccreditationStatus.APPLICANT_REJECTED){
      accreditationStatus = 'ACCREDITATION_REJECTED'
    }else{
      accreditationStatus = acc.status
    }

    def data
    def bodyRequest = [
      RFC: rfc,
      Fecha_Conclusion_Acreditacion: sdf.format(acc.lastUpdated),
      Estatus_Acreditacion: accreditationStatus,
      Folio_Solicitud: acc.folio_infotec.toString(),
      Documentos_Acreditacion_Actualizados: files
    ]

    def json = JsonOutput.toJson(bodyRequest)
    println json

    try{
      data = http.request( POST ) { req ->
        headers.'X-AUTH-TOKEN' = serviceUrl.authToken
        uri.path = serviceUrl.path
        requestContentType = ContentType.JSON
        body = json
      }
    }catch(Exception ex) {
      ex.printStackTrace()
      data = null
    }
    if(data){
      println data

    }
    true
  }



}

