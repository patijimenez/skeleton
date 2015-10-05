<%@ page import="mx.gob.inadem.Role" %>
<!DOCTYPE html>

<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'role.label', default: 'Role')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-role" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="edit-role" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <div class="navbar">
              <div class="navbar-inner">
                <a class="brand" href="#">Roles</a>
                <ul class="nav">
                  <li><g:link class="list" action="list">Regresar a lista de roles</g:link></li>
                </ul>
              </div>
            </div>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${roleInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${roleInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>

            <div ng-app="fpymeFrontApp">
            <div class="container" ng-controller="AdminRolesCtrl">

			<g:form method="post">
				<g:hiddenField name="id" value="${roleInstance?.id}" />
				<g:hiddenField name="version" value="${roleInstance?.version}" />

                        <div class=" ${hasErrors(bean: roleInstance, field: 'name', 'error')} required">
                            <label for="name">
                                <g:message code="role.name.label" default="Nombre" />
                                <span class="required-indicator">*</span>
                            </label>
                            <g:textField name="name" required="" value="${roleInstance?.name}"/>
                        </div>

                <div>
                    <h3>Permisos</h3>
                    <div class="input-append">
                        <input name="permission" type="text" ng-model="permission" placeholder="permiso">
                        <button class="btn" type="button" ng-click="addPermission(permission)" >Agregar</button>
                    </div>
                    <div class="alert alert-error" ng-show="error">
                        {{message}}
                    </div>
                <div>

                    <table class="table table-bordered">
                        <thead>
                        <th>
                            Permisos
                        </th>
                        <th></th>
                        </thead>
                        <tr ng-repeat="item in role.permissionsList" ng-show="item!=''" >
                            <td>{{item}}</td>
                            <td>
                                <button ng-click="deletePermission(item)" class="btn btn-danger">Eliminar</button>
                            </td>
                        </tr>

                    </table>
                </div>
</div>
                        <g:hiddenField name="permissions" value="${roleInstance?.permissions}" />
                        <g:hiddenField name="permissionslist"/>
                        <div class="form-actions">
                            <g:actionSubmit class="save btn" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                            <g:actionSubmit class="delete btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </div>
                    </div>
			</g:form>
        </div></div>
		</div>
	</body>
</html>

