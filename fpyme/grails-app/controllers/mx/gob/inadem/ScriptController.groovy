package mx.gob.inadem

import org.springframework.dao.DataIntegrityViolationException

class ScriptController {

  static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

  def index() {
    redirect(action: "list", params: params)
  }

  def list(Integer max) {
    params.max = Math.min(max ?: 10, 100)

    def searchCriteria = null

    if(params.searchCriteria) {
      searchCriteria = params.searchCriteria.trim()
    }

    def list = Script.withCriteria {
      if(params.sort){
       order params.sort, params.order
      }

      if(searchCriteria) {
        or{
          ilike('name', '%' + searchCriteria + '%')
          ilike('trigger', '%' + searchCriteria + '%')
        }
      }

      if(params.max) {
        maxResults(params.max)
      }
      if(params.offset) {
        firstResult(params.offset.toInteger())
      }
    }

    def total = Script.withCriteria {
      if(searchCriteria) {
        or{
          ilike('name', '%' + searchCriteria + '%')
          ilike('trigger', '%' + searchCriteria + '%')
        }
      }
      projections {
        count('id')
      }
    }.first()

    [scriptInstanceList: list, scriptInstanceTotal: total, searchCriteria: searchCriteria]
  }

  def create() {
    [scriptInstance: new Script(params)]
  }

  def save() {
    def scriptInstance = new Script(params)
    if (!scriptInstance.save(flush: true)) {
      render(view: "create", model: [scriptInstance: scriptInstance])
      return
    }

    flash.message = message(code: 'default.created.message', args: [message(code: 'script.label', default: 'Script'), scriptInstance.id])
    redirect(action: "show", id: scriptInstance.id)
  }

  def show(Long id) {
    def scriptInstance = Script.get(id)
    if (!scriptInstance) {
      flash.message = message(code: 'default.not.found.message', args: [message(code: 'script.label', default: 'Script'), id])
      redirect(action: "list")
      return
    }

    [scriptInstance: scriptInstance]
  }

  def edit(Long id) {
    def scriptInstance = Script.get(id)
    if (!scriptInstance) {
      flash.message = message(code: 'default.not.found.message', args: [message(code: 'script.label', default: 'Script'), id])
      redirect(action: "list")
      return
    }

    [scriptInstance: scriptInstance]
  }

  def update(Long id, Long version) {
    def scriptInstance = Script.get(id)
    if (!scriptInstance) {
      flash.message = message(code: 'default.not.found.message', args: [message(code: 'script.label', default: 'Script'), id])
      redirect(action: "list")
      return
    }

    if (version != null) {
      if (scriptInstance.version > version) {
        scriptInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
            [message(code: 'script.label', default: 'Script')] as Object[],
            "Another user has updated this Script while you were editing")
        render(view: "edit", model: [scriptInstance: scriptInstance])
        return
      }
    }

    scriptInstance.properties = params

    if (!scriptInstance.save(flush: true)) {
      render(view: "edit", model: [scriptInstance: scriptInstance])
      return
    }

    flash.message = message(code: 'default.updated.message', args: [message(code: 'script.label', default: 'Script'), scriptInstance.id])
    redirect(action: "show", id: scriptInstance.id)
  }


  def delete(Long id) {
    def scriptInstance = Script.get(id)
    if (!scriptInstance) {
      flash.message = message(code: 'default.not.found.message', args: [message(code: 'script.label', default: 'Script'), id])
      redirect(action: "list")
      return
    }

    try {
      scriptInstance.delete(flush: true)
      flash.message = message(code: 'default.deleted.message', args: [message(code: 'script.label', default: 'Script'), id])
      redirect(action: "list")
    }
    catch (DataIntegrityViolationException e) {
      flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'script.label', default: 'Script'), id])
      redirect(action: "show", id: id)
    }
  }
}
