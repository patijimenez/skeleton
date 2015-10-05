
<%@ page import="mx.gob.inadem.EventMessage" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'eventMessage.label', default: 'EventMessage')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-eventMessage" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="list-eventMessage" class="container content scaffold-list" role="main">
            <div class="row">
                <div class="span12">
                    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>
                </div>
                <div class="span12">
                    <div class="navbar">
                        <div class="navbar-inner">
                            <a class="brand" href="#">eventMessage</a>
                            <ul class="nav">
                                <li class="active"><a href="#">Lista</a></li>
                                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                            </ul>
                        </div>
                    </div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                            
                                <g:sortableColumn property="dateCreated" title="${message(code: 'eventMessage.dateCreated.label', default: 'Date Created')}" />
                            
                                <g:sortableColumn property="lastUpdated" title="${message(code: 'eventMessage.lastUpdated.label', default: 'Last Updated')}" />
                            
                                <g:sortableColumn property="message" title="${message(code: 'eventMessage.message.label', default: 'Message')}" />
                            
                                <g:sortableColumn property="severity" title="${message(code: 'eventMessage.severity.label', default: 'Severity')}" />
                            
                                <g:sortableColumn property="validFrom" title="${message(code: 'eventMessage.validFrom.label', default: 'Valid From')}" />
                            
                                <g:sortableColumn property="validTo" title="${message(code: 'eventMessage.validTo.label', default: 'Valid To')}" />
                            
                            </tr>
                        </thead>
                        <tbody>
                        <g:each in="${eventMessageInstanceList}" status="i" var="eventMessageInstance">
                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            
                                <td><g:link action="show" id="${eventMessageInstance.id}">${fieldValue(bean: eventMessageInstance, field: "dateCreated")}</g:link></td>
                            
                                <td><g:formatDate date="${eventMessageInstance.lastUpdated}" /></td>
                            
                                <td>${fieldValue(bean: eventMessageInstance, field: "message")}</td>
                            
                                <td>${fieldValue(bean: eventMessageInstance, field: "severity")}</td>
                            
                                <td><g:formatDate date="${eventMessageInstance.validFrom}" /></td>
                            
                                <td><g:formatDate date="${eventMessageInstance.validTo}" /></td>
                            
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                    <div class="pagination">
                        <g:paginate total="${eventMessageInstanceTotal}" />
                    </div>
                </div>
            </div>
		</div>
	</body>
</html>
