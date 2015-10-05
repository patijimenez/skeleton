<%=packageName%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="\${message(code: '${domainClass.propertyName}.label', default: '${className}')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-${domainClass.propertyName}" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="create-${domainClass.propertyName}" class="containercontent scaffold-create" role="main">
      <div class="row">
        <div class="span12">
          <div class="navbar">
            <div class="navbar-inner">
              <a class="brand" href="#">${domainClass.propertyName}</a>
              <ul class="nav">
                <li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
              </ul>
            </div>
          </div>
          <h1><g:message code="default.create.label" args="[entityName]" /></h1>
          <g:if test="\${flash.message}">
            <div class="message" role="status">\${flash.message}</div>
          </g:if>
          <g:hasErrors bean="\${${propertyName}}">
          <ul class="errors" role="alert">
            <g:eachError bean="\${${propertyName}}" var="error">
            <li <g:if test="\${error in org.springframework.validation.FieldError}">data-field-id="\${error.field}"</g:if>><g:message error="\${error}"/></li>
            </g:eachError>
          </ul>
          </g:hasErrors>
          <g:form action="save" <%= multiPart ? ' enctype="multipart/form-data"' : '' %>>
            <fieldset class="form">
              <g:render template="form"/>
            </fieldset>
            <div class="form-actions">
              <g:submitButton name="create" class="save btn btn-primary" value="\${message(code: 'default.button.create.label', default: 'Create')}" />
            </div>
          </div>
        </g:form>
      </div>
		</div>
	</body>
</html>
