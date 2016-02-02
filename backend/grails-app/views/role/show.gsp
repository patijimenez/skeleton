
<%@ page import="mx.com.mschool.Role" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'role.label', default: 'Role')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-role" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="show-role" class="content scaffold-show" role="main">
      <div class="navbar">
        <div class="navbar-inner">
          <a class="brand" href="#">Roles</a>
          <ul class="nav">
              <li><g:link class="list" action="list">Regresar a lista de roles</g:link></li>
              <li><g:link class="create" action="create">Nuevo role</g:link></li>
          </ul>
        </div>
      </div>
            <h1>Mostrar role</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list role">
			
				<g:if test="${roleInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="role.name.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${roleInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${roleInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="role.dateCreated.label" default="Fecha de creaci&oacute;n" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${roleInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${roleInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="role.lastUpdated.label" default="Ultima modificaci&oacute;n" /></span>
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${roleInstance?.lastUpdated}" /></span>
				</li>
				</g:if>
                <g:if test="${roleInstance?.permissions}">
                <div>
                <h3>Permisos</h3>
                <table class="table table-bordered">
                <thead>
                <th>
                    Permisos
                </th>
                </thead>
                <g:each var="permiso" in="${roleInstance?.permissions}">
                <tr>
                    <td>${permiso}</td>
                </tr>
                </g:each>
                </table>
                </div>
				</g:if>
			</ol>
			<g:form>
                <div class="form-actions">
					<g:hiddenField name="id" value="${roleInstance?.id}" />
					<g:link class="edit btn" action="edit" id="${roleInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </div>
			</g:form>
		</div>
	</body>
</html>
