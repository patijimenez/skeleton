package mx.gob.inadem

import org.springframework.dao.DataIntegrityViolationException

class MessageLegendController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [messageLegendInstanceList: MessageLegend.list(params), messageLegendInstanceTotal: MessageLegend.count()]
    }

    def create() {
        [messageLegendInstance: new MessageLegend(params)]
    }

    def save() {
        def messageLegendInstance = new MessageLegend(params)
        if (!messageLegendInstance.save(flush: true)) {
            render(view: "create", model: [messageLegendInstance: messageLegendInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'messageLegend.label', default: 'MessageLegend'), messageLegendInstance.id])
        redirect(action: "show", id: messageLegendInstance.id)
    }

    def show(Long id) {
        def messageLegendInstance = MessageLegend.get(id)
        if (!messageLegendInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'messageLegend.label', default: 'MessageLegend'), id])
            redirect(action: "list")
            return
        }

        [messageLegendInstance: messageLegendInstance]
    }

    def edit(Long id) {
        def messageLegendInstance = MessageLegend.get(id)
        if (!messageLegendInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'messageLegend.label', default: 'MessageLegend'), id])
            redirect(action: "list")
            return
        }

        [messageLegendInstance: messageLegendInstance]
    }

    def update(Long id, Long version) {
        def messageLegendInstance = MessageLegend.get(id)
        if (!messageLegendInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'messageLegend.label', default: 'MessageLegend'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (messageLegendInstance.version > version) {
                messageLegendInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'messageLegend.label', default: 'MessageLegend')] as Object[],
                          "Another user has updated this MessageLegend while you were editing")
                render(view: "edit", model: [messageLegendInstance: messageLegendInstance])
                return
            }
        }

        messageLegendInstance.properties = params

        if (!messageLegendInstance.save(flush: true)) {
            render(view: "edit", model: [messageLegendInstance: messageLegendInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'messageLegend.label', default: 'MessageLegend'), messageLegendInstance.id])
        redirect(action: "show", id: messageLegendInstance.id)
    }

    def delete(Long id) {
        def messageLegendInstance = MessageLegend.get(id)
        if (!messageLegendInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'messageLegend.label', default: 'MessageLegend'), id])
            redirect(action: "list")
            return
        }

        try {
            messageLegendInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'messageLegend.label', default: 'MessageLegend'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'messageLegend.label', default: 'MessageLegend'), id])
            redirect(action: "show", id: id)
        }
    }
}
