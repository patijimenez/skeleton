<%@ page import="mx.com.mschool.EventMessage" %>


<div class="fieldcontain ${hasErrors(bean: eventMessageInstance, field: 'message', 'error')} ">
	<label for="message">
		<g:message code="eventMessage.message.label" default="Message" />
		
	</label>
	<g:textArea name="message" value="${eventMessageInstance?.message}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventMessageInstance, field: 'severity', 'error')} required">
	<label for="severity">
		<g:message code="eventMessage.severity.label" default="Severity" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="severity" from="${mx.com.mschool.Severity?.values()}" keys="${mx.com.mschool.Severity.values()*.name()}" required="" value="${eventMessageInstance?.severity?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: eventMessageInstance, field: 'validFrom', 'error')} required">
	<label for="validFrom">
		<g:message code="eventMessage.validFrom.label" default="Valid From" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="validFrom" precision="day"  value="${eventMessageInstance?.validFrom}" precision="minute" />
</div>

<div class="fieldcontain ${hasErrors(bean: eventMessageInstance, field: 'validTo', 'error')} required">
	<label for="validTo">
		<g:message code="eventMessage.validTo.label" default="Valid To" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="validTo" precision="day"  value="${eventMessageInstance?.validTo}" precision="minute" />
</div>

