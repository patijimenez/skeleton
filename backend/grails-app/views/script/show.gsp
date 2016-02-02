
<%@ page import="mx.com.mschool.Script" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'script.label', default: 'Script')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-script" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="show-script" class="content scaffold-show" role="main">
      <div class="navbar">
        <div class="navbar-inner">
          <a class="brand" href="#">script</a>
          <ul class="nav">
            <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
          </ul>
        </div>
      </div>
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list script">
			
				<g:if test="${scriptInstance?.text}">
				<li class="fieldcontain">
					<span id="text-label" class="property-label"><g:message code="script.text.label" default="Text" /></span>
					
						<span class="property-value" aria-labelledby="text-label"><g:fieldValue bean="${scriptInstance}" field="text"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="script.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${scriptInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.mapVariables}">
				<li class="fieldcontain">
					<span id="mapVariables-label" class="property-label"><g:message code="script.mapVariables.label" default="Map Variables" /></span>
					
						<span class="property-value" aria-labelledby="mapVariables-label"><g:fieldValue bean="${scriptInstance}" field="mapVariables"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.file}">
				<li class="fieldcontain">
					<span id="file-label" class="property-label"><g:message code="script.file.label" default="File" /></span>
					
						<span class="property-value" aria-labelledby="file-label"><g:fieldValue bean="${scriptInstance}" field="file"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.language}">
				<li class="fieldcontain">
					<span id="language-label" class="property-label"><g:message code="script.language.label" default="Language" /></span>
					
						<span class="property-value" aria-labelledby="language-label"><g:fieldValue bean="${scriptInstance}" field="language"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="script.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${scriptInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scriptInstance?.trigger}">
				<li class="fieldcontain">
					<span id="trigger-label" class="property-label"><g:message code="script.trigger.label" default="Trigger" /></span>
					
						<span class="property-value" aria-labelledby="trigger-label"><g:fieldValue bean="${scriptInstance}" field="trigger"/></span>
					
				</li>
				</g:if>

                <g:if test="${scriptInstance?.roles}">
                    <li class="fieldcontain">
                        <span id="roles-label" class="property-label"><g:message code="script.roles.label" default="Roles" /></span>

                        <g:each in="${scriptInstance.roles}" var="p">
                            <span class="property-value" aria-labelledby="roles-label"><g:link controller="role" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
                        </g:each>

                    </li>
                </g:if>

			
				<g:if test="${scriptInstance?.variables}">
				<li class="fieldcontain">
					<span id="variables-label" class="property-label"><g:message code="script.variables.label" default="Variables" /></span>
					
						<g:each in="${scriptInstance.variables}" var="v">
						<span class="property-value" aria-labelledby="variables-label"><g:link controller="scriptVariable" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>

                <g:if test="${scriptInstance?.generateFile}">
                    <li class="fieldcontain">
                        <span id="generateFile-label" class="property-label"><g:message code="script.generateFile.label" default="Generate File" /></span>

                        <span class="property-value" aria-labelledby="generateFile-label"><g:fieldValue bean="${scriptInstance}" field="generateFile"/></span>

                    </li>
                </g:if>
			
			</ol>
			<g:form>
                <div class="form-actions">
					<g:hiddenField name="id" value="${scriptInstance?.id}" />
					<g:link class="edit btn" action="edit" id="${scriptInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </div>
			</g:form>
		</div>
	</body>
</html>
