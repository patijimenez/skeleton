<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="layout" content="main"/>
  <title>Login</title>
</head>
<body>
<g:if test="${flash.message}">
  <div class="message">${flash.message}</div>
</g:if>
<div class="row">
  <div class="span12">
    <h2>Nueva Aplicación</h2>
  </div>
  <div class="span6">
    <a style="text-decoration:none; color:gray;" href="#/register">
        <span style="display: block;">
           <h3 class="text-success">Regístrate</h3>
          <label style="text-decoration:none">
            Inicia tu registro
          </label>
        </span>
    </a>
  </div>
  <div class="span6">
    <div class="row">
      <div class="span6">
        <center>
          <legend>Acceso al sistema</legend>
        </center>
      </div>
    </div>
    <div class="row-fluid">
      <div class="span6">
        <p class="muted" style="text-align: justify">
          Este sitio está optimizado para su uso en computadoras utilizando los navegadores:<br/> Internet Explorer 9
          y 10, así como las versiones más recientes de Mozilla Firefox, Google Chrome y Safari.
        </p>
        <p class="muted" style="text-align: justify">
          Si estás usando Internet Explorer 8 o una versión anterior,
          <a href="http://browsehappy.com/" style="color: #d31245;">por favor actualiza tu navegador</a> ya que pueden
          ocurrir inconsistencias.
        </p>
      </div>
      <div class="span6">
        <g:form action="signIn">
          <input type="hidden" name="targetUri" value="${targetUri}"/>
          <fieldset>
            <div class="control-group">
              <div class="controls"><input id="email" name="username" placeholder="Correo electrónico" type="text"/>
              </div>
            </div>
            <div class="control-group">
              <div class="controls">
                <input id="password" name="password" placeholder="Contraseña" type="password"/>
                <br/>
                <a class="text-info" href="#/recover">Recuperar contraseña</a>
              </div>
            </div>
            <div class="conrol-group">
              <div class="controls">
                <button type="submit" class="btn">Acceder</button>
              </div>
            </div>
          </fieldset>
        </g:form>
      </div>
    </div>
  </div>
</div>
<div class="row">
  <div class="span12">
    <legend> &nbsp;</legend>
    Acerca del sitio.  
  </div>
</div>
</body>
</html>
