
<%@ page import="mx.gob.inadem.Role" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'role.label', default: 'Role')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-role" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="list-role" class="container content scaffold-list" role="main">
            <div class="row">
                <div class="span12">
                    <h1>Listado de roles</h1>
                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>
                </div>
                <div class="span12">
                    <div class="navbar">
                        <div class="navbar-inner">
                            <a class="brand" href="#">Roles</a>
                            <ul class="nav">
                                <li class="active"><a href="#">Lista</a></li>
                                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                            </ul>
                            <g:form class="navbar-form pull-right" action="list">
                                <g:textField placeholder="Buscar por nombre o tipo" class="search-query" name="searchCriteria" value="${searchCriteria}" />
                                <button type="submit" class="btn">Buscar</button>
                            </g:form>
                        </div>
                    </div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                            
                                <g:sortableColumn property="name" title="${message(code: 'role.name.label', default: 'Nombre')}" />
                            
                                <g:sortableColumn property="dateCreated" title="${message(code: 'role.dateCreated.label', default: 'Fecha de creaci&oacute;n')}" />
                            
                                <g:sortableColumn property="lastUpdated" title="${message(code: 'role.lastUpdated.label', default: 'Ultima modificaci&oacute;n')}" />
                            
                            </tr>
                        </thead>
                        <tbody>
                        <g:each in="${roleInstanceList}" status="i" var="roleInstance">
                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            
                                <td><g:link action="show" id="${roleInstance.id}">${fieldValue(bean: roleInstance, field: "name")}</g:link></td>
                            
                                <td> <g:formatDate date="${roleInstance.dateCreated}" /></td>

                                <td><g:formatDate date="${roleInstance.lastUpdated}" /></td>
                            
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                    <div class="pagination">
                        <g:paginate total="${roleInstanceTotal}" />
                    </div>
                </div>
            </div>
		</div>
	</body>
</html>
