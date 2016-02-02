
<%@ page import="mx.com.mschool.Script" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'script.label', default: 'Script')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-script" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="list-script" class="container content scaffold-list" role="main">
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
                        <a class="brand" href="#">Script</a>
                        <ul class="nav">
                          <li class="active"><a href="#">Lista</a></li>
                          <li><g:link class="create" action="create">Nuevo Script</g:link></li>
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
                                <th><g:message code="script.id.label" default="Id" /></th>

                                <g:sortableColumn property="name" title="${message(code: 'script.name.label', default: 'Name')}" />

                                <th><g:message code="script.text.label" default="Text" /></th>

                                <th><g:message code="script.description.label" default="Description" /></th>
                            
                                <g:sortableColumn property="mapVariables" title="${message(code: 'script.mapVariables.label', default: 'Map Variables')}" />
                            
                                <g:sortableColumn property="language" title="${message(code: 'script.language.label', default: 'Language')}" />
                            
                                <g:sortableColumn property="trigger" title="${message(code: 'script.trigger.label', default: 'Trigger')}" />
                            
                            </tr>
                        </thead>
                        <tbody>
                        <g:each in="${scriptInstanceList}" status="i" var="scriptInstance">
                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                                <td><g:link action="show" id="${scriptInstance.id}">${fieldValue(bean: scriptInstance, field: "id")}</g:link></td>

                                <td>${fieldValue(bean: scriptInstance, field: "name")}</td>

                                <td>${fieldValue(bean: scriptInstance, field: "text")}</td>
                            
                                <td>${fieldValue(bean: scriptInstance, field: "description")}</td>
                            
                                <td>${fieldValue(bean: scriptInstance, field: "mapVariables")}</td>
                            
                                <td>${fieldValue(bean: scriptInstance, field: "language")}</td>
                            
                                <td>${fieldValue(bean: scriptInstance, field: "trigger")}</td>
                            
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                    <div class="pagination">
                        <g:paginate total="${scriptInstanceTotal}" />
                    </div>
                </div>
            </div>
		</div>
	</body>
</html>
