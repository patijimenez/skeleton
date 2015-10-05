
<%@ page import="mx.gob.inadem.Task" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'task.label', default: 'Task')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-task" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="list-task" class="container content scaffold-list" role="main">
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
                            <a class="brand" href="#">task</a>
                            <ul class="nav">
                                <li class="active"><a href="#">Lista</a></li>
                                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                            </ul>
                        </div>
                    </div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                            
                                <g:sortableColumn property="dateCreated" title="${message(code: 'task.dateCreated.label', default: 'Date Created')}" />
                            
                                <g:sortableColumn property="description" title="${message(code: 'task.description.label', default: 'Description')}" />
                            
                                <g:sortableColumn property="lastUpdated" title="${message(code: 'task.lastUpdated.label', default: 'Last Updated')}" />
                            
                                <g:sortableColumn property="name" title="${message(code: 'task.name.label', default: 'Name')}" />
                            
                            </tr>
                        </thead>
                        <tbody>
                        <g:each in="${taskInstanceList}" status="i" var="taskInstance">
                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            
                                <td><g:link action="show" id="${taskInstance.id}">${fieldValue(bean: taskInstance, field: "dateCreated")}</g:link></td>
                            
                                <td>${fieldValue(bean: taskInstance, field: "description")}</td>
                            
                                <td><g:formatDate date="${taskInstance.lastUpdated}" /></td>
                            
                                <td>${fieldValue(bean: taskInstance, field: "name")}</td>
                            
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                    <div class="pagination">
                        <g:paginate total="${taskInstanceTotal}" />
                    </div>
                </div>
            </div>
		</div>
	</body>
</html>
