<%@ page import="mx.com.mschool.MessageLegend" %>



<div class="fieldcontain ${hasErrors(bean: messageLegendInstance, field: 'key', 'error')} required">
	<label for="key">
		<g:message code="messageLegend.key.label" default="Key" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="key" required="" value="${messageLegendInstance?.key}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: messageLegendInstance, field: 'message', 'error')} required">
	<label for="message">
		<g:message code="messageLegend.message.label" default="Message" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="message" required="" value="${messageLegendInstance?.message}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: messageLegendInstance, field: 'contextCall', 'error')} ">
	<label for="contextCall">
		<g:message code="messageLegend.contextCall.label" default="Context Call" />
		
	</label>
	<g:select id="contextCall" name="contextCall.id" from="${mx.com.mschool.Call.list()}" optionKey="id" value="${messageLegendInstance?.contextCall?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: messageLegendInstance, field: 'defaultMessage', 'error')} ">
	<label for="defaultMessage">
		<g:message code="messageLegend.defaultMessage.label" default="Default Message" />
		
	</label>
	<g:textField name="defaultMessage" value="${messageLegendInstance?.defaultMessage}"/>
</div>

