package mx.com.mschool

import org.springframework.dao.DataIntegrityViolationException

class RoleController {

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

        def list = Role.withCriteria {
            if(params.sort){
                order params.sort, params.order
            }

            if(searchCriteria) {
                or{
                    ilike('name', '%' + searchCriteria + '%')
                }
            }

            if(params.max) {
                maxResults(params.max)
            }
            if(params.offset) {
                firstResult(params.offset.toInteger())
            }
        }

        def total = Role.withCriteria {
            if(searchCriteria) {
                or{
                    ilike('name', '%' + searchCriteria + '%')
                }
            }
            projections {
                count('id')
            }
        }.first()

    //    [scriptInstanceList: list, roleInstanceTotal: total, searchCriteria: searchCriteria]
        [roleInstanceList: list, roleInstanceTotal: total,searchCriteria: searchCriteria]


    }

    def create() {
        [roleInstance: new Role(params)]
    }

    def save() {

        def roleInstance = new Role()
        def permissionsList = Eval.me(params.permissionslist)

        if(permissionsList!=null ){
            permissionsList.each() {
                roleInstance.addToPermissions(it)
            };
        }

        roleInstance.name = params.name

        if (!roleInstance.save(flush: true)) {
            render(view: "create", model: [roleInstance: roleInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'role.label', default: 'Role'), roleInstance.id])
        redirect(action: "show", id: roleInstance.id)
    }

    def show(Long id) {
        def roleInstance = Role.get(id)
        if (!roleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'role.label', default: 'Role'), id])
            redirect(action: "list")
            return
        }

        [roleInstance: roleInstance]
    }

    def edit(Long id) {

        def roleInstance = Role.get(id)

        if (!roleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'role.label', default: 'Role'), id])
            redirect(action: "list")
            return
        }

        [roleInstance: roleInstance]
    }

    def update(Long id, Long version) {
        def roleInstance = Role.get(id)

        if (!roleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'role.label', default: 'Role'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (roleInstance.version > version) {
                roleInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'role.label', default: 'Role')] as Object[],
                          "Another user has updated this Role while you were editing")
                render(view: "edit", model: [roleInstance: roleInstance])
                return
            }
        }

        roleInstance.properties = params

        def permissionsOld = roleInstance.permissions
        def permissionsList = Eval.me(params.permissionslist)

        if(permissionsOld!=null && permissionsList!=null ){
            permissionsOld.each() {
            roleInstance.removeFromPermissions(it)
        };

        }

        roleInstance.save(flush: true)

        if(permissionsList!=null ){
            permissionsList.each() {
                roleInstance.addToPermissions(it)
            };
        }

        if (!roleInstance.save(flush: true)) {
            render(view: "edit", model: [roleInstance: roleInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'role.label', default: 'Role'), roleInstance.id])
        redirect(action: "show", id: roleInstance.id)
    }

    def delete(Long id) {
        def roleInstance = Role.get(id)
        if (!roleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'role.label', default: 'Role'), id])
            redirect(action: "list")
            return
        }

        try {
            roleInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'role.label', default: 'Role'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'role.label', default: 'Role'), id])
            redirect(action: "show", id: id)
        }
    }
}
