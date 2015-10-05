<%@ page import="mx.gob.inadem.Role" %>



<div class=" ${hasErrors(bean: roleInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="role.name.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${roleInstance?.name}"/>
</div>

<div >
    <h3>Permisos</h3>

    <div ng-app="fpymeFrontApp">
    <div class="container" ng-controller="AdminRolesCtrl">
    <div class="input-append">
        <input name="permission" type="text" ng-model="permission" required="required" placeholder="permiso">
        <button class="btn" type="button" ng-click="addPermission(permission)" >Agregar</button>
    </div>

        <div>
            {{role.listaPermisos}}

        </div>

    </div>
    </div>



    <table class="table table-bordered">
        <thead>
            <td>
                Permisos
            </td>
            <th></th>
        </thead>
          <g:each var="permiso" in="${roleInstance?.permissions}">
            <tr>
                <td>${permiso}</td>
                <td>
                <button ng-click="deleteDestinatario(permiso)" class="btn btn-danger">Eliminar</button>
                </td>
           </tr>
          </g:each>
    </table>
</div>




