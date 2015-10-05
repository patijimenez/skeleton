<%@ page import="mx.gob.inadem.MessageLegend" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'messageLegend.label', default: 'MessageLegend')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-messageLegend" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="edit-messageLegend" class="content scaffold-edit" role="main">
			<h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <div class="navbar">
              <div class="navbar-inner">
                <a class="brand" href="#">messageLegend</a>
                <ul class="nav">
                  <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                </ul>
              </div>
            </div>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${messageLegendInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${messageLegendInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form method="post" >
				<g:hiddenField name="id" value="${messageLegendInstance?.id}" />
				<g:hiddenField name="version" value="${messageLegendInstance?.version}" />
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
                <div class="form-actions">
					<g:actionSubmit class="save btn" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
					<g:actionSubmit class="delete btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate="" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </div>
			</g:form>
		</div>
	</body>
</html>
