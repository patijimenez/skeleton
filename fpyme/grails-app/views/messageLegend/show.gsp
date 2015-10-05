
<%@ page import="mx.gob.inadem.MessageLegend" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'messageLegend.label', default: 'MessageLegend')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-messageLegend" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="show-messageLegend" class="content scaffold-show" role="main">
      <div class="navbar">
        <div class="navbar-inner">
          <a class="brand" href="#">messageLegend</a>
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
			<ol class="property-list messageLegend">
			
				<g:if test="${messageLegendInstance?.key}">
				<li class="fieldcontain">
					<span id="key-label" class="property-label"><g:message code="messageLegend.key.label" default="Key" /></span>
					
						<span class="property-value" aria-labelledby="key-label"><g:fieldValue bean="${messageLegendInstance}" field="key"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${messageLegendInstance?.message}">
				<li class="fieldcontain">
					<span id="message-label" class="property-label"><g:message code="messageLegend.message.label" default="Message" /></span>
					
						<span class="property-value" aria-labelledby="message-label"><g:fieldValue bean="${messageLegendInstance}" field="message"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${messageLegendInstance?.contextCall}">
				<li class="fieldcontain">
					<span id="contextCall-label" class="property-label"><g:message code="messageLegend.contextCall.label" default="Context Call" /></span>
					
						<span class="property-value" aria-labelledby="contextCall-label"><g:link controller="call" action="show" id="${messageLegendInstance?.contextCall?.id}">${messageLegendInstance?.contextCall?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${messageLegendInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="messageLegend.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${messageLegendInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${messageLegendInstance?.defaultMessage}">
				<li class="fieldcontain">
					<span id="defaultMessage-label" class="property-label"><g:message code="messageLegend.defaultMessage.label" default="Default Message" /></span>
					
						<span class="property-value" aria-labelledby="defaultMessage-label"><g:fieldValue bean="${messageLegendInstance}" field="defaultMessage"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${messageLegendInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="messageLegend.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${messageLegendInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
                <div class="form-actions">
					<g:hiddenField name="id" value="${messageLegendInstance?.id}" />
					<g:link class="edit btn" action="edit" id="${messageLegendInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </div>
			</g:form>
		</div>
	</body>
</html>
