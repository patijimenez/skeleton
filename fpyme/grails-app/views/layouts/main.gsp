<!doctype html>
<html class="no-js">
  <head>
    
    <title>Nueva aplicación</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <base href="http://localhost:9000/" />
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="stylesheet" href="styles/main.css">
    <!--link type="text/css" rel="stylesheet" href="http://www.encuentra.gob.mx/css/apf.css"/-->
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css" />
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css" />
    <g:layoutHead/>
    <r:layoutResources />
  </head>
  <body ng-app="fpymeFrontApp">
    <!--[if lt IE 7]>
      <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
    <![endif]-->

    <!--[if lt IE 9]>
      <script src="components/es5-shim/es5-shim.js"></script>
      <script src="components/json3/lib/json3.min.js"></script>
    <![endif]-->

    <!-- Header -->
    <div class="header container">
      <div class="row logos-bar">
        <div class="span9">
        </div>
        <div class="span3">
          <form id="search" method="get" action="#" class="searchField">
	    <span class="search-container">
              <div id="gobmx-searchbox-container-se"></div>
            </span>
            <!--input(type="text",name="search", value="Buscar")-->
            <input type="submit" value="buscar"/>
          </form>
        </div>
      </div>
    </div>
    %{--
    <div class="container">
      <div class="row">
        <div class="span12">
          <ul class="menu-apf container">
            <li>
              <a href="/" target="" class="active"><span></span>Inicio</a>
            </li>
            <li>
	      <a href="/" target=""><span></span>Objeto</a>
	    </li>
            <li>
              <a href="/" target=""><span></span>Objetivos</a>
            </li>
            <li>
	      <a href="/" target=""><span></span>Población Objetivo</a>
            </li>
            <li>
              <a href="/" target=""><span></span>Consejo Directivo</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    --}%
    <ng-include src="'views/mensaje.html'"></ng-include>
    <!-- Add your site or application content here -->
    <div class="container">
        <g:if test="${request.userPrincipal}">
        <div class="row">
            <div class="span12">
                <ul class="nav nav-pills pull-right">
                    <li>
                        <a href="/">Principal</a>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Mi perfil <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Datos generales</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Modificar password</a></li>
                            <li><a href="#">Modificar email</a></li>
                            <li class="divider"></li>
                            <li><a href="/app/auth/signOut">Salir</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        </g:if>
        <g:layoutBody/>
    </div>

    <div class="container footer" id="footer">
     
    </div>

    <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Cargando &hellip;"/></div>
    <script src="scripts/providers/jquery-1.8.3.min.js"></script>
    <script src="scripts/providers/guiders/guiders-1.3.0.js"></script>
    <script src="components/lodash/lodash.js"></script>
    <script src="components/angular/angular.js"></script>
    <script src="components/angular-resource/angular-resource.js"></script>
    <script src="components/angular-cookies/angular-cookies.js"></script>
    <script src="components/angular-sanitize/angular-sanitize.js"></script>
    <script src="components/angular-bootstrap/ui-bootstrap-tpls.js"></script>
    <script src="components/ngUpload/ng-upload.min.js"></script>
    <script src="components/angular-i18n/angular-locale_es-mx.js"></script>
    <script src="components/jquery-ui/ui/jquery-ui.js"></script>
    <script src="components/angular-ui-date/src/date.js"></script>
    <script src="components/select2/select2.min.js"></script>
    <script src="components/select2/select2_locale_es.js"></script>
    <script src="components/angular-ui-select2/src/select2.js"></script>
    <script src="components/codemirror/lib/codemirror.js"></script>
    <script src="components/codemirror/mode/sql/sql.js"></script>
    <script src="components/codemirror/mode/groovy/groovy.js"></script>
    <script src="components/codemirror/addon/edit/matchbrackets.js"></script>
    <script src="components/angular-ui-codemirror/ui-codemirror.js"></script>
    <script src="components/spin.js/dist/spin.min.js"></script>
    <script src="components/angular-ui-utils/ui-utils.min.js"></script>
    <script src="components/tinymce/tinymce.min.js"></script>
    <script src="components/angular-ui-tinymce/src/tinymce.js"></script>
    <script src="components/checklist-model/checklist-model.js"></script>
    <script src="components/bootstrap-duallistbox/src/jquery.bootstrap-duallistbox.js"></script>

    <script src="scripts/providers/guiders/guiders-1.3.0.js"></script>
    
    <script src="scripts/grailsApp.js"></script>
    <script src="scripts/services/urlService.js"></script>
    <script src="scripts/services/installationService.js"></script>
    <script src="scripts/services/callService.js"></script>
    <script src="scripts/controllers/message.js"></script>
    <script src="scripts/services/messageService.js"></script>
    <script src="scripts/controllers/councilSession.js"></script>
    <script src="scripts/controllers/adminRoles.js"></script>
    <script src="scripts/controllers/councilSessionDialog.js"></script>
    <script src="scripts/controllers/asignacionDespacho.js"></script>
    <g:javascript library="application"/>
    <r:layoutResources />

    <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
    <script>
      var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
      (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
      g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
      s.parentNode.insertBefore(g,s)}(document,'script'));
    </script>

    <!--script type="text/javascript" src="http://www.encuentra.gob.mx/api/gobmxWidgetAPI-min.js"></script>
    <script type="text/javascript" src="http://www.encuentra.gob.mx/properties/gobmxWidgetAPI-conf.js"></script-->
    <!--script>
      _gmx.loadGobMXsearchAPI({container:'gobmx-searchbox-container-se',client:'se',newWindow:true});

    </script-->
    <script type="text/javascript">

      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-41849378-1']);
      _gaq.push(['_trackPageview']);

      (function() {
        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
      })();
      //Validacion del dominio
      var host = location.hostname;
      var tipoHost = host.indexOf("prologyca") > -1;
      if(tipoHost){
        document.getElementById('footerINADEM').style.display = 'none';
      }
    </script>
  </body>
</html>
