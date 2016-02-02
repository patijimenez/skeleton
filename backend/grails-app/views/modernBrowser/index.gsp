<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName" value="${message(code: 'call.label', default: 'Call')}" />
<title><g:message code="default.show.label" args="[entityName]" /></title>
<link rel="stylesheet" href="${resource(dir: 'css', file: 'style.css')}" type="text/css" />
</head>
<body>
<h2>Actualiza tu navegador</h2>
<p>
<div class="alert alert-danger">
    Parece que estás usando una versión insegura de Internet Explorer. Utilizar una versión desactualizada de tu navegador hace inseguro tu ordenador. En Windows XP no es posible actualizar a la última versión. Para una mejor experiencia con la web, te sugerimos que pruebes otro navegador.
</div>
</p>
<ul id="browserlist" class="wrap">
    <li id="chrome">
    <a href="http://www.google.com/chrome" title="Google Chrome">
        <div class="icon"></div>
        <h2>Google Chrome</h2>
        <p class="info">&#8220;Un nuevo y rápido navegador de Google ¡Pruébalo ahora!&#8221;</p>
        <p class="version">Última versión: <strong>31</strong></p>
        <p class="website">Visita la web para más información</p>
    </a>
    </li><!-- #chrome -->
    <li id="firefox">
    <a href="http://www.firefox.com/" title="Mozilla Firefox">
        <div class="icon"></div>
        <h2>Mozilla Firefox</h2>
        <p class="info">&#8220;Tu seguridad online es la la principal prioridad de Firefox. Firefox es gratuito y hecho para sacar el mayor partido posible a la web.&#8221;</p>
        <p class="version">Última versión: <strong>26</strong></p>
        <p class="website">Visita la web para más información</p>
    </a>
    </li><!-- #firefox -->
    <li id="safari">
    <a href="http://www.apple.com/safari/" title="Apple Safari">
        <div class="icon"></div>
        <h2>Safari</h2>
        <p class="info">&#8220; Safari, de Apple; para Mac y Windows. El navegador más innovador del mundo.&#8221;</p>
        <p class="version">Última versión: <strong>7</strong></p>
        <p class="website">Visita la web para más información</p>
    </a>
    </li><!-- #safari -->
    <li id="opera">
    <a href="http://www.opera.com/" title="Opera">
        <div class="icon"></div>
        <h2>Opera</h2>
        <p class="info">&#8220;El navegador más rápido de la Tierra- seguro, potente y fácil de usar- con una excelente protección de la privacidad. Y gratis.&#8221;</p>
        <p class="version">Última versión: <strong>18</strong></p>
        <p class="website">Visita la web para más información</p>
    </a>
    </li><!-- #opera -->
    <li id="ie">
    <a href="http://windows.microsoft.com/ie" title="Microsoft Internet Explorer">
        <div class="icon"></div>
        <h2>Internet Explorer</h2>
        <p class="info">&#8220;Diseñado para ayudarte a tomar el control de tu privacidad y navegar con seguridad . Gratis, de &nbsp;Microsoft.&#8221;</p>
        <p class="version">Última versión: <strong>11</strong></p>
        <p class="website">Visita la web para más información</p>
    </a>
    </li><!-- #ie -->
</ul><!-- #browserlist -->
</body>
</html>
