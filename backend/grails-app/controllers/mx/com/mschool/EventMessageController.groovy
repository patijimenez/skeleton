package mx.com.mschool

import org.springframework.dao.DataIntegrityViolationException

class EventMessageController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [eventMessageInstanceList: EventMessage.list(params), eventMessageInstanceTotal: EventMessage.count()]
    }

    def create() {
        [eventMessageInstance: new EventMessage(params)]
    }

    def save() {
        def eventMessageInstance = new EventMessage(params)
        if (!eventMessageInstance.save(flush: true)) {
            render(view: "create", model: [eventMessageInstance: eventMessageInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'eventMessage.label', default: 'EventMessage'), eventMessageInstance.id])
        redirect(action: "show", id: eventMessageInstance.id)
    }

    def show(Long id) {
        def eventMessageInstance = EventMessage.get(id)
        if (!eventMessageInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventMessage.label', default: 'EventMessage'), id])
            redirect(action: "list")
            return
        }

        [eventMessageInstance: eventMessageInstance]
    }

    def edit(Long id) {
        def eventMessageInstance = EventMessage.get(id)
        if (!eventMessageInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventMessage.label', default: 'EventMessage'), id])
            redirect(action: "list")
            return
        }

        [eventMessageInstance: eventMessageInstance]
    }

    def update(Long id, Long version) {
        def eventMessageInstance = EventMessage.get(id)
        if (!eventMessageInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventMessage.label', default: 'EventMessage'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (eventMessageInstance.version > version) {
                eventMessageInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'eventMessage.label', default: 'EventMessage')] as Object[],
                          "Another user has updated this EventMessage while you were editing")
                render(view: "edit", model: [eventMessageInstance: eventMessageInstance])
                return
            }
        }

        eventMessageInstance.properties = params

        if (!eventMessageInstance.save(flush: true)) {
            render(view: "edit", model: [eventMessageInstance: eventMessageInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'eventMessage.label', default: 'EventMessage'), eventMessageInstance.id])
        redirect(action: "show", id: eventMessageInstance.id)
    }

    def delete(Long id) {
        def eventMessageInstance = EventMessage.get(id)
        if (!eventMessageInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'eventMessage.label', default: 'EventMessage'), id])
            redirect(action: "list")
            return
        }

        try {
            eventMessageInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'eventMessage.label', default: 'EventMessage'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'eventMessage.label', default: 'EventMessage'), id])
            redirect(action: "show", id: id)
        }
    }
}
