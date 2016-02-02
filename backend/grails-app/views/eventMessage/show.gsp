
<%@ page import="mx.com.mschool.EventMessage" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'eventMessage.label', default: 'EventMessage')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-eventMessage" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="show-eventMessage" class="content scaffold-show" role="main">
      <div class="navbar">
        <div class="navbar-inner">
          <a class="brand" href="#">eventMessage</a>
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
			<ol class="property-list eventMessage">
			
				<g:if test="${eventMessageInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="eventMessage.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${eventMessageInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventMessageInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="eventMessage.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${eventMessageInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventMessageInstance?.message}">
				<li class="fieldcontain">
					<span id="message-label" class="property-label"><g:message code="eventMessage.message.label" default="Message" /></span>
					
						<span class="property-value" aria-labelledby="message-label"><g:fieldValue bean="${eventMessageInstance}" field="message"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventMessageInstance?.severity}">
				<li class="fieldcontain">
					<span id="severity-label" class="property-label"><g:message code="eventMessage.severity.label" default="Severity" /></span>
					
						<span class="property-value" aria-labelledby="severity-label"><g:fieldValue bean="${eventMessageInstance}" field="severity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventMessageInstance?.validFrom}">
				<li class="fieldcontain">
					<span id="validFrom-label" class="property-label"><g:message code="eventMessage.validFrom.label" default="Valid From" /></span>
					
						<span class="property-value" aria-labelledby="validFrom-label"><g:formatDate date="${eventMessageInstance?.validFrom}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${eventMessageInstance?.validTo}">
				<li class="fieldcontain">
					<span id="validTo-label" class="property-label"><g:message code="eventMessage.validTo.label" default="Valid To" /></span>
					
						<span class="property-value" aria-labelledby="validTo-label"><g:formatDate date="${eventMessageInstance?.validTo}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
                <div class="form-actions">
					<g:hiddenField name="id" value="${eventMessageInstance?.id}" />
					<g:link class="edit btn" action="edit" id="${eventMessageInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </div>
			</g:form>
		</div>
	</body>
</html>
