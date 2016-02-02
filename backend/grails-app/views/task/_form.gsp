<%@ page import="mx.com.mschool.Task" %>



<div class="fieldcontain ${hasErrors(bean: taskInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="task.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${taskInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: taskInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="task.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${taskInstance?.name}"/>
</div>

