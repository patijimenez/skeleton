<%@ page import="mx.com.mschool.Script" %>



<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'text', 'error')} ">
	<label for="text">
		<g:message code="script.text.label" default="Text" />
		
	</label>
	<g:textArea name="text" cols="40" rows="5" value="${scriptInstance?.text}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="script.description.label" default="Description" />
		
	</label>
	<g:textArea name="description" cols="40" rows="5" value="${scriptInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'mapVariables', 'error')} ">
	<label for="mapVariables">
		<g:message code="script.mapVariables.label" default="Map Variables" />
		
	</label>
	<g:textField name="mapVariables" value="${scriptInstance?.mapVariables}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'file', 'error')} ">
	<label for="file">
		<g:message code="script.file.label" default="File" />
		
	</label>
	<g:textField name="file" value="${scriptInstance?.file}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'language', 'error')} ">
	<label for="language">
		<g:message code="script.language.label" default="Language" />
		
	</label>
	<g:textField name="language" value="${scriptInstance?.language}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="script.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${scriptInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'trigger', 'error')} ">
	<label for="trigger">
		<g:message code="script.trigger.label" default="Trigger" />
		
	</label>
	<g:textField name="trigger" value="${scriptInstance?.trigger}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'roles', 'error')} ">
    <label for="roles">
        <g:message code="scriptInstance.roles.label" default="Roles" />

    </label>
    <g:select name="roles" from="${mx.com.mschool.Role.list()}" multiple="multiple" optionKey="id" size="5" value="${scriptInstance?.roles*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'variables', 'error')} ">
	<label for="variables">
		<g:message code="script.variables.label" default="Variables" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${scriptInstance?.variables?}" var="v">
    <li><g:link controller="scriptVariable" action="show" id="${v.id}">${v?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="scriptVariable" action="create" params="['script.id': scriptInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'scriptVariable.label', default: 'ScriptVariable')])}</g:link>
</li>
</ul>

<div class="fieldcontain ${hasErrors(bean: scriptInstance, field: 'generateFile', 'error')} ">
        <label for="generateFile">
            <g:message code="script.generateFile.label" default="Generate File" />
        </label>
        <g:checkBox name="generateFile" value="${scriptInstance?.generateFile}" />
</div>

</div>

