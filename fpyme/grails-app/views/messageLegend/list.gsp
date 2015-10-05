
<%@ page import="mx.gob.inadem.MessageLegend" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'messageLegend.label', default: 'MessageLegend')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-messageLegend" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="list-messageLegend" class="container content scaffold-list" role="main">
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
                            <a class="brand" href="#">messageLegend</a>
                            <ul class="nav">
                                <li class="active"><a href="#">Lista</a></li>
                                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                            </ul>
                        </div>
                    </div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                            
                                <g:sortableColumn property="key" title="${message(code: 'messageLegend.key.label', default: 'Key')}" />
                            
                                <g:sortableColumn property="message" title="${message(code: 'messageLegend.message.label', default: 'Message')}" />
                            
                                <g:sortableColumn property="dateCreated" title="${message(code: 'messageLegend.dateCreated.label', default: 'Date Created')}" />
                            
                                <g:sortableColumn property="defaultMessage" title="${message(code: 'messageLegend.defaultMessage.label', default: 'Default Message')}" />
                            
                                <g:sortableColumn property="lastUpdated" title="${message(code: 'messageLegend.lastUpdated.label', default: 'Last Updated')}" />
                            
                            </tr>
                        </thead>
                        <tbody>
                        <g:each in="${messageLegendInstanceList}" status="i" var="messageLegendInstance">
                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            
                                <td><g:link action="show" id="${messageLegendInstance.id}">${fieldValue(bean: messageLegendInstance, field: "key")}</g:link></td>
                            
                                <td>${fieldValue(bean: messageLegendInstance, field: "message")}</td>
                            
                                <td><g:formatDate date="${messageLegendInstance.dateCreated}" /></td>
                            
                                <td>${fieldValue(bean: messageLegendInstance, field: "defaultMessage")}</td>
                            
                                <td><g:formatDate date="${messageLegendInstance.lastUpdated}" /></td>
                            
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                    <div class="pagination">
                        <g:paginate total="${messageLegendInstanceTotal}" />
                    </div>
                </div>
            </div>
		</div>
	</body>
</html>
