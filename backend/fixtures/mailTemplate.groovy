import mx.gob.inadem.*

fixture {
	REGISTRO_OTRO(MailTemplate) {
		key = "REGISTRO_OTRO"
		title = "Bienvenido al INADEM"
		body = """\
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        
        <!-- Facebook sharing information tags -->
        <meta property="og:title" content="Bienvenido al Sistema Emprendedor">
        
        <title>Bienvenido al Sistema Emprendedor</title>
		
	</head>
    <body leftmargin="0" marginwidth="0" topmargin="0" marginheight="0" offset="0" style="-webkit-text-size-adjust: none;margin: 0;padding: 0;background-color: #FAFAFA;width: 100%;">
    	<center>
        	<table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%" id="backgroundTable" style="margin: 0;padding: 0;background-color: #FAFAFA;height: 100%;width: 100%;">
            	<tr>
                	<td align="center" valign="top" style="padding-top: 20px;border-collapse: collapse;">
                    	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateContainer" style="border: 1px solid #DDDDDD;background-color: #FFFFFF;">
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Header  -->
                                	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateHeader" style="background-color: #FFFFFF;border-bottom: 0;">
                                        <tr>
                                            <td class="headerContent" style="border-collapse: collapse;color: #202020;font-family: Arial;font-size: 34px;font-weight: bold;line-height: 100%;padding: 0;text-align: center;vertical-align: middle;">
                                            
                                            	<!-- // Begin Module: Standard Header Image  -->
                                            	<img src="cid:wideHeader" style="max-width: 600px;border: 0;height: auto;line-height: 100%;outline: none;text-decoration: none;" id="headerImage campaign-icon" mc:label="header_image" mc:edit="header_image" mc:allowdesigner mc:allowtext>
                                            	<!-- // End Module: Standard Header Image  -->
                                            
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Header  -->
                                </td>
                            </tr>
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Body  -->
                                	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateBody">
                                    	<tr>
                                            <td valign="top" style="border-collapse: collapse;">
                                
                                                <!-- // Begin Module: Standard Content  -->
                                                <table border="0" cellpadding="20" cellspacing="0" width="100%">
                                                    <tr>
                                                        <td valign="top" class="bodyContent" style="border-collapse: collapse;background-color: #FFFFFF;">
                                                            <div mc:edit="std_content00" style="color: #505050;font-family: Arial;font-size: 14px;line-height: 150%;text-align: left;">
                                                                <p>
                                                                  Estimado(a) \${toName}, te hemos creado una cuenta para el Sistema Emprendedor.
                                                                </p>
                                                                <h2 class="h2" style="color: #202020;display: block;font-family: Arial;font-size: 30px;font-weight: bold;line-height: 100%;margin-top: 0;margin-right: 0;margin-bottom: 10px;margin-left: 0;text-align: left;">¡Gracias por registrarte en el Sistema Emprendedor!</h2>
                                                                <p>
                                                                El Sistema Emprendedor del INADEM es la herramienta que apoya las buenas ideas de los emprendedores mexicanos.
                                                                </p>
                                                                <p>
                                                                Ahora te invitamos a que conozcas las diferentes convocatorias que el INADEM tiene para ti. Tus datos de acceso son con los que te diste de alta.
                                                                </p>
                                                                <p>
                                                                A partir de este momento recibirás periódicamente en tu correo información relevante sobre convocatorias próximas a publicarse, fechas límite para recepción de solicitudes, fechas en que sesionará el Consejo Directivo, así como cualquier noticia que fomente la consolidación de una economía nacional innovadora, dinámica y competitiva.
                                                                </p>
                                                            </div>
														</td>
                                                    </tr>
                                                    <tr>
                                                    	<td align="center" valign="top" style="padding-top: 0;border-collapse: collapse;">
                                                        	<table border="0" cellpadding="15" cellspacing="0" class="templateButton" style="-moz-border-radius: 3px;-webkit-border-radius: 3px;background-color: #336699;border: 0;border-radius: 3px;color: #FFFFFF;font-family: Arial;font-size: 15px;font-weight: bold;letter-spacing: -.5px;line-height: 100%;text-align: center;text-decoration: none;border-collapse: separate;">
                                                            	<tr>
                                                                	<td valign="middle" class="templateButtonContent" style="border-collapse: collapse;">
                                                                    	<div mc:edit="std_content02">
                                                                        	<a href="http://localhost:9000" target="_blank" style="color: #FFFFFF;font-family: Arial;font-size: 15px;font-weight: bold;letter-spacing: -.5px;line-height: 100%;text-align: center;text-decoration: none;">Ir al sistema emprendedor</a>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <!-- // End Module: Standard Content  -->
                                                
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Body  -->
                                </td>
                            </tr>
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Footer  -->
                                	<table border="0" cellpadding="10" cellspacing="0" width="600" id="templateFooter" style="background-color: #FFFFFF;border-top: 0;">
                                    	<tr>
                                        	<td valign="top" class="footerContent" style="border-collapse: collapse;">
                                            
                                                <!-- // Begin Module: Transactional Footer  -->
                                                <table border="0" cellpadding="10" cellspacing="0" width="100%">
                                                    <tr>
                                                        <td valign="top" style="border-collapse: collapse;">
                                                            <div mc:edit="std_footer" style="color: #707070;font-family: Arial;font-size: 12px;line-height: 125%;text-align: center;">
                                                                Insurgentes Sur 1940, Colonia Florida, Delegación Álvaro Obregón, México DF 01030
                                                                <br>
                                                                México, Distrito Federal, Tel.(55) 5729-9100 | 01(800) 08 ECONOMIA [32-666]
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <!-- // End Module: Transactional Footer  -->
                                            
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Footer  -->
                                </td>
                            </tr>
                        </table>
                        <br>
                    </td>
                </tr>
            </table>
        </center>
    </body>
</html>
"""
		originalBody = """\
		Bienvenido al INADEM \${toName}, para confirmar
		su password por favor dé click en la siguiente liga:
		<a href="http://localhost:9000/#/tokenConfirm/\${token}">http://localhost:9000/#/tokenConfirm/\${token}</a>
"""
		fromMail = "developers@ediaz.me"
		fromAlias = "Lucasian DEV"
		bccs = ['iamedu@gmail.com', 'fcastrillo@gmail.com', 'gerardo.dr@gmail.com']
	}
	RECUPERA_PASSWORD(MailTemplate) {
		key = "RECUPERA_CONTRASENA"
		title = "Recuperación de contraseña INADEM"
		body = """\
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        
        <!-- Facebook sharing information tags -->
        <meta property="og:title" content="Bienvenido al Sistema Emprendedor">
        
        <title>Bienvenido al Sistema Emprendedor</title>
		
	</head>
    <body leftmargin="0" marginwidth="0" topmargin="0" marginheight="0" offset="0" style="-webkit-text-size-adjust: none;margin: 0;padding: 0;background-color: #FAFAFA;width: 100%;">
    	<center>
        	<table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%" id="backgroundTable" style="margin: 0;padding: 0;background-color: #FAFAFA;height: 100%;width: 100%;">
            	<tr>
                	<td align="center" valign="top" style="padding-top: 20px;border-collapse: collapse;">
                    	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateContainer" style="border: 1px solid #DDDDDD;background-color: #FFFFFF;">
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Header  -->
                                	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateHeader" style="background-color: #FFFFFF;border-bottom: 0;">
                                        <tr>
                                            <td class="headerContent" style="border-collapse: collapse;color: #202020;font-family: Arial;font-size: 34px;font-weight: bold;line-height: 100%;padding: 0;text-align: center;vertical-align: middle;">
                                            
                                            	<!-- // Begin Module: Standard Header Image  -->
                                            	<img src="cid:wideHeader" style="max-width: 600px;border: 0;height: auto;line-height: 100%;outline: none;text-decoration: none;" id="headerImage campaign-icon" mc:label="header_image" mc:edit="header_image" mc:allowdesigner mc:allowtext>
                                            	<!-- // End Module: Standard Header Image  -->
                                            
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Header  -->
                                </td>
                            </tr>
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Body  -->
                                	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateBody">
                                    	<tr>
                                            <td valign="top" style="border-collapse: collapse;">
                                
                                                <!-- // Begin Module: Standard Content  -->
                                                <table border="0" cellpadding="20" cellspacing="0" width="100%">
                                                    <tr>
                                                        <td valign="top" class="bodyContent" style="border-collapse: collapse;background-color: #FFFFFF;">
                                                            <div mc:edit="std_content00" style="color: #505050;font-family: Arial;font-size: 14px;line-height: 150%;text-align: left;">
                                                                <p>
                                                                    Saludos, a continuación encontrará la ligua a la que tiene que acceder para recuperar su contraseña.
                                                                </p>
                                                            </div>
														</td>
                                                    </tr>
                                                    <tr>
                                                    	<td align="center" valign="top" style="padding-top: 0;border-collapse: collapse;">
                                                        	<table border="0" cellpadding="15" cellspacing="0" class="templateButton" style="-moz-border-radius: 3px;-webkit-border-radius: 3px;background-color: #336699;border: 0;border-radius: 3px;color: #FFFFFF;font-family: Arial;font-size: 15px;font-weight: bold;letter-spacing: -.5px;line-height: 100%;text-align: center;text-decoration: none;border-collapse: separate;">
                                                            	<tr>
                                                                	<td valign="middle" class="templateButtonContent" style="border-collapse: collapse;">
                                                                    	<div mc:edit="std_content02">
                                                                        	<a href="http://localhost:9000/#/recoverPassword/\${token}" target="_blank" style="color: #FFFFFF;font-family: Arial;font-size: 15px;font-weight: bold;letter-spacing: -.5px;line-height: 100%;text-align: center;text-decoration: none;">Recuperar contraseña</a>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <!-- // End Module: Standard Content  -->
                                                
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Body  -->
                                </td>
                            </tr>
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Footer  -->
                                	<table border="0" cellpadding="10" cellspacing="0" width="600" id="templateFooter" style="background-color: #FFFFFF;border-top: 0;">
                                    	<tr>
                                        	<td valign="top" class="footerContent" style="border-collapse: collapse;">
                                            
                                                <!-- // Begin Module: Transactional Footer  -->
                                                <table border="0" cellpadding="10" cellspacing="0" width="100%">
                                                    <tr>
                                                        <td valign="top" style="border-collapse: collapse;">
                                                            <div mc:edit="std_footer" style="color: #707070;font-family: Arial;font-size: 12px;line-height: 125%;text-align: center;">
                                                                Insurgentes Sur 1940, Colonia Florida, Delegación Álvaro Obregón, México DF 01030
                                                                <br>
                                                                México, Distrito Federal, Tel.(55) 5729-9100 | 01(800) 08 ECONOMIA [32-666]
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <!-- // End Module: Transactional Footer  -->
                                            
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Footer  -->
                                </td>
                            </tr>
                        </table>
                        <br>
                    </td>
                </tr>
            </table>
        </center>
    </body>
</html>
"""
		originalBody = """\
		Para recuperar su contraseña haga click en la siguiente liga:
		<a href="http://localhost:9000/#/recoverPassword/\${token}">http://localhost:9000/#/recoverPassword/\${token}</a>
"""
		fromMail = "developers@ediaz.me"
		fromAlias = "Lucasian DEV"
		bccs = ['iamedu@gmail.com', 'fcastrillo@gmail.com', 'gerardo.dr@gmail.com']
	}
	REGISTRO_FISICA(MailTemplate) {
		key = "REGISTRO_FISICA"
		title = "Bienvenido al INADEM"
		body = """\
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        
        <!-- Facebook sharing information tags -->
        <meta property="og:title" content="Bienvenido al Sistema Emprendedor">
        
        <title>Bienvenido al Sistema Emprendedor</title>
		
	</head>
    <body leftmargin="0" marginwidth="0" topmargin="0" marginheight="0" offset="0" style="-webkit-text-size-adjust: none;margin: 0;padding: 0;background-color: #FAFAFA;width: 100%;">
    	<center>
        	<table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%" id="backgroundTable" style="margin: 0;padding: 0;background-color: #FAFAFA;height: 100%;width: 100%;">
            	<tr>
                	<td align="center" valign="top" style="padding-top: 20px;border-collapse: collapse;">
                    	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateContainer" style="border: 1px solid #DDDDDD;background-color: #FFFFFF;">
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Header  -->
                                	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateHeader" style="background-color: #FFFFFF;border-bottom: 0;">
                                        <tr>
                                            <td class="headerContent" style="border-collapse: collapse;color: #202020;font-family: Arial;font-size: 34px;font-weight: bold;line-height: 100%;padding: 0;text-align: center;vertical-align: middle;">
                                            
                                            	<!-- // Begin Module: Standard Header Image  -->
                                            	<img src="cid:wideHeader" style="max-width: 600px;border: 0;height: auto;line-height: 100%;outline: none;text-decoration: none;" id="headerImage campaign-icon" mc:label="header_image" mc:edit="header_image" mc:allowdesigner mc:allowtext>
                                            	<!-- // End Module: Standard Header Image  -->
                                            
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Header  -->
                                </td>
                            </tr>
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Body  -->
                                	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateBody">
                                    	<tr>
                                            <td valign="top" style="border-collapse: collapse;">
                                
                                                <!-- // Begin Module: Standard Content  -->
                                                <table border="0" cellpadding="20" cellspacing="0" width="100%">
                                                    <tr>
                                                        <td valign="top" class="bodyContent" style="border-collapse: collapse;background-color: #FFFFFF;">
                                                            <div mc:edit="std_content00" style="color: #505050;font-family: Arial;font-size: 14px;line-height: 150%;text-align: left;">
                                                                <p>
                                                                  Estimado(a) \${toName}, te hemos creado una cuenta para el Sistema Emprendedor.
                                                                </p>
                                                                <h2 class="h2" style="color: #202020;display: block;font-family: Arial;font-size: 30px;font-weight: bold;line-height: 100%;margin-top: 0;margin-right: 0;margin-bottom: 10px;margin-left: 0;text-align: left;">¡Gracias por registrarte en el Sistema Emprendedor!</h2>
                                                                <p>
                                                                El Sistema Emprendedor del INADEM es la herramienta que apoya las buenas ideas de los emprendedores mexicanos.
                                                                </p>
                                                                <p>
                                                                Ahora te invitamos a que conozcas las diferentes convocatorias que el INADEM tiene para ti. Tus datos de acceso son con los que te diste de alta.
                                                                </p>
                                                                <p>
                                                                A partir de este momento recibirás periódicamente en tu correo información relevante sobre convocatorias próximas a publicarse, fechas límite para recepción de solicitudes, fechas en que sesionará el Consejo Directivo, así como cualquier noticia que fomente la consolidación de una economía nacional innovadora, dinámica y competitiva.
                                                                </p>
                                                            </div>
														</td>
                                                    </tr>
                                                    <tr>
                                                    	<td align="center" valign="top" style="padding-top: 0;border-collapse: collapse;">
                                                        	<table border="0" cellpadding="15" cellspacing="0" class="templateButton" style="-moz-border-radius: 3px;-webkit-border-radius: 3px;background-color: #336699;border: 0;border-radius: 3px;color: #FFFFFF;font-family: Arial;font-size: 15px;font-weight: bold;letter-spacing: -.5px;line-height: 100%;text-align: center;text-decoration: none;border-collapse: separate;">
                                                            	<tr>
                                                                	<td valign="middle" class="templateButtonContent" style="border-collapse: collapse;">
                                                                    	<div mc:edit="std_content02">
                                                                        	<a href="http://localhost:9000" target="_blank" style="color: #FFFFFF;font-family: Arial;font-size: 15px;font-weight: bold;letter-spacing: -.5px;line-height: 100%;text-align: center;text-decoration: none;">Ir al sistema emprendedor</a>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <!-- // End Module: Standard Content  -->
                                                
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Body  -->
                                </td>
                            </tr>
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Footer  -->
                                	<table border="0" cellpadding="10" cellspacing="0" width="600" id="templateFooter" style="background-color: #FFFFFF;border-top: 0;">
                                    	<tr>
                                        	<td valign="top" class="footerContent" style="border-collapse: collapse;">
                                            
                                                <!-- // Begin Module: Transactional Footer  -->
                                                <table border="0" cellpadding="10" cellspacing="0" width="100%">
                                                    <tr>
                                                        <td valign="top" style="border-collapse: collapse;">
                                                            <div mc:edit="std_footer" style="color: #707070;font-family: Arial;font-size: 12px;line-height: 125%;text-align: center;">
                                                                Insurgentes Sur 1940, Colonia Florida, Delegación Álvaro Obregón, México DF 01030
                                                                <br>
                                                                México, Distrito Federal, Tel.(55) 5729-9100 | 01(800) 08 ECONOMIA [32-666]
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <!-- // End Module: Transactional Footer  -->
                                            
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Footer  -->
                                </td>
                            </tr>
                        </table>
                        <br>
                    </td>
                </tr>
            </table>
        </center>
    </body>
</html>
"""
		originalBody = """\
		Bienvenido al INADEM \${applicantMail}, para confirmar
		su password por favor dé click en la siguiente liga:
		<a href="http://localhost:9000/#/tokenConfirm/\${token}">http://localhost:9000/#/tokenConfirm/\${token}</a>
"""
		fromMail = "developers@ediaz.me"
		fromAlias = "Lucasian DEV"
		bccs = ['iamedu@gmail.com', 'fcastrillo@gmail.com', 'gerardo.dr@gmail.com']
	}
	REGISTRO_ESTUDIANTE(MailTemplate) {
		key = "REGISTRO_ESTUDIANTE"
		title = "Bienvenido al INADEM"
		body = """\
<!DOCTYPE html>
<html lang="es">
    <head>

        <title>Plantilla Correo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        

    </head>

    <body>
        <div id="contenedor" class="contenedor " style="width: 800px;">
            <div id="head" class="head" style="width: 700px;height: 80px;padding: 25px;background-image: url(cid:header);background-repeat: no-repeat;background-size: 100% auto;">

            </div>
            <div id="titleMail" class="titleMail" style="font-family: TrajanProRegular,&quot;Times New Roman&quot;,serif;font-size: 20px;text-align: left;padding-left: 50px;background-color: #CE1A52;color: white;padding: 20px;">
                Registro en el INADEM 
            </div>
            <div id="bodyMail" class="bodyMail" style="width: 700px;font-family: arial;font-size: 13px;text-align: justify;padding-left: 25px;color: #727376;">
                <p>Estimado \${toName}: </p>
                <p>
			Gracias por registrarse en el INADEM
		</p>
		<p>
			Para confirmar su correo haga click sobre la siguiente liga
			<a href="http://localhost:9000/#/tokenConfirm/\${token}">http://localhost:9000/#/tokenConfirm/\${token}</a>
		</p>
            </div>
            <div id="footer" class="footer" style="color: white;text-align: center;font-family: arial;font-size: 13px;background-color: #727376;padding: 2px;">
                <p>Insurgentes Sur 1940, Colonia Florida, Delegación Álvaro Obregón, México DF 01030 México, Distrito Federal, <br> Tel.(55) 5729-9100 | 01(800) 08 ECONOMIA [32-666]</p>
            </div>
        </div>
    </body>
</html>
"""
		originalBody = """\
		Bienvenido al INADEM \${applicantMail}, para confirmar
		su password por favor dé click en la siguiente liga:
		<a href="http://localhost:9000/#/tokenConfirm/\${token}">http://localhost:9000/#/tokenConfirm/\${token}</a>
"""
		fromMail = "developers@ediaz.me"
		fromAlias = "Lucasian DEV"
		bccs = ['iamedu@gmail.com', 'fcastrillo@gmail.com', 'gerardo.dr@gmail.com']
	}
	REGISTRO_EMPRESA(MailTemplate) {
		key = "REGISTRO_EMPRESA"
		title = "Bienvenido al INADEM"
		body = """\
<!DOCTYPE html>
<html lang="es">
    <head>

        <title>Plantilla Correo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        

    </head>

    <body>
        <div id="contenedor" class="contenedor " style="width: 800px;">
            <div id="head" class="head" style="width: 700px;height: 80px;padding: 25px;background-image: url(cid:header);background-repeat: no-repeat;background-size: 100% auto;">

            </div>
            <div id="titleMail" class="titleMail" style="font-family: TrajanProRegular,&quot;Times New Roman&quot;,serif;font-size: 20px;text-align: left;padding-left: 50px;background-color: #CE1A52;color: white;padding: 20px;">
                Registro en el INADEM 
            </div>
            <div id="bodyMail" class="bodyMail" style="width: 700px;font-family: arial;font-size: 13px;text-align: justify;padding-left: 25px;color: #727376;">
                <p>Estimado \${toName}: </p>
                <p>
			Gracias por registrarse en el INADEM
		</p>
		<p>
			Para confirmar su correo haga click sobre la siguiente liga
			<a href="http://localhost:9000/#/tokenConfirm/\${token}">http://localhost:9000/#/tokenConfirm/\${token}</a>
		</p>
            </div>
            <div id="footer" class="footer" style="color: white;text-align: center;font-family: arial;font-size: 13px;background-color: #727376;padding: 2px;">
                <p>Insurgentes Sur 1940, Colonia Florida, Delegación Álvaro Obregón, México DF 01030 México, Distrito Federal, <br> Tel.(55) 5729-9100 | 01(800) 08 ECONOMIA [32-666]</p>
            </div>
        </div>
    </body>
</html>
"""
		originalBody = """\
		Bienvenido al INADEM \${applicantMail}, para confirmar
		su password por favor dé click en la siguiente liga:
		<a href="http://localhost:9000/#/tokenConfirm/\${token}">http://localhost:9000/#/tokenConfirm/\${token}</a>
"""
		fromMail = "developers@ediaz.me"
		fromAlias = "Lucasian DEV"
		bccs = ['iamedu@gmail.com', 'fcastrillo@gmail.com', 'gerardo.dr@gmail.com']
	}
	REGISTRO_GOBIERNO(MailTemplate) {
		key = "REGISTRO_GOBIERNO"
		title = "Bienvenido al INADEM"
		body = """\
<!DOCTYPE html>
<html lang="es">
    <head>

        <title>Plantilla Correo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        

    </head>

    <body>
        <div id="contenedor" class="contenedor " style="width: 800px;">
            <div id="head" class="head" style="width: 700px;height: 80px;padding: 25px;background-image: url(cid:header);background-repeat: no-repeat;background-size: 100% auto;">

            </div>
            <div id="titleMail" class="titleMail" style="font-family: TrajanProRegular,&quot;Times New Roman&quot;,serif;font-size: 20px;text-align: left;padding-left: 50px;background-color: #CE1A52;color: white;padding: 20px;">
                Registro en el INADEM 
            </div>
            <div id="bodyMail" class="bodyMail" style="width: 700px;font-family: arial;font-size: 13px;text-align: justify;padding-left: 25px;color: #727376;">
                <p>Estimado \${toName}: </p>
                <p>
			Gracias por registrarse en el INADEM
		</p>
		<p>
			Para confirmar su correo haga click sobre la siguiente liga
			<a href="http://localhost:9000/#/tokenConfirm/\${token}">http://localhost:9000/#/tokenConfirm/\${token}</a>
		</p>
            </div>
            <div id="footer" class="footer" style="color: white;text-align: center;font-family: arial;font-size: 13px;background-color: #727376;padding: 2px;">
                <p>Insurgentes Sur 1940, Colonia Florida, Delegación Álvaro Obregón, México DF 01030 México, Distrito Federal, <br> Tel.(55) 5729-9100 | 01(800) 08 ECONOMIA [32-666]</p>
            </div>
        </div>
    </body>
</html>
"""
		originalBody = """\
		Bienvenido al INADEM \${applicantMail}, para confirmar
		su password por favor dé click en la siguiente liga:
		<a href="http://localhost:9000/#/tokenConfirm/\${token}">http://localhost:9000/#/tokenConfirm/\${token}</a>
"""
		fromMail = "developers@ediaz.me"
		fromAlias = "Lucasian DEV"
		bccs = ['iamedu@gmail.com', 'fcastrillo@gmail.com', 'gerardo.dr@gmail.com']
	}
	REGISTRO_INADEM(MailTemplate) {
		key = "REGISTRO_INADEM"
		title = "Bienvenido al Sistema Emprendedor"
		body = """\

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        
        <!-- Facebook sharing information tags -->
        <meta property="og:title" content="Bienvenido al Sistema Emprendedor">
        
        <title>Bienvenido al Sistema Emprendedor</title>
		
	</head>
    <body leftmargin="0" marginwidth="0" topmargin="0" marginheight="0" offset="0" style="-webkit-text-size-adjust: none;margin: 0;padding: 0;background-color: #FAFAFA;width: 100%;">
    	<center>
        	<table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%" id="backgroundTable" style="margin: 0;padding: 0;background-color: #FAFAFA;height: 100%;width: 100%;">
            	<tr>
                	<td align="center" valign="top" style="padding-top: 20px;border-collapse: collapse;">
                    	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateContainer" style="border: 1px solid #DDDDDD;background-color: #FFFFFF;">
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Header  -->
                                	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateHeader" style="background-color: #FFFFFF;border-bottom: 0;">
                                        <tr>
                                            <td class="headerContent" style="border-collapse: collapse;color: #202020;font-family: Arial;font-size: 34px;font-weight: bold;line-height: 100%;padding: 0;text-align: center;vertical-align: middle;">
                                            
                                            	<!-- // Begin Module: Standard Header Image  -->
                                            	<img src="cid:wideHeader" style="max-width: 600px;border: 0;height: auto;line-height: 100%;outline: none;text-decoration: none;" id="headerImage campaign-icon" mc:label="header_image" mc:edit="header_image" mc:allowdesigner mc:allowtext>
                                            	<!-- // End Module: Standard Header Image  -->
                                            
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Header  -->
                                </td>
                            </tr>
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Body  -->
                                	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateBody">
                                    	<tr>
                                            <td valign="top" style="border-collapse: collapse;">
                                
                                                <!-- // Begin Module: Standard Content  -->
                                                <table border="0" cellpadding="20" cellspacing="0" width="100%">
                                                    <tr>
                                                        <td valign="top" class="bodyContent" style="border-collapse: collapse;background-color: #FFFFFF;">
                                                            <div mc:edit="std_content00" style="color: #505050;font-family: Arial;font-size: 14px;line-height: 150%;text-align: left;">
                                                                <h2 class="h2" style="color: #202020;display: block;font-family: Arial;font-size: 30px;font-weight: bold;line-height: 100%;margin-top: 0;margin-right: 0;margin-bottom: 10px;margin-left: 0;text-align: left;">Bienvenido al Sistema Emprendedor</h2>
								<p>
								Estimado(a) \${toName}, te hemos creado una cuenta para el Sistema Emprendedor.
								</p>
                                                                <p>
                                                                El sistema emprendedor es la herramienta que te permite apoyar
                                                                las buenas de los emprendedores mexicanos.
                                                                </p>
                                                                <strong>Como empezar:</strong> En este correo verás el nombre de usuario (tu correo electrónico) y la contraseña que te fueron asignadas, entra con ellas y no olvides cambiar tu contraseña! 
                                                                Una vez dentro deberás de verificar y completar tus datos.
                                                            </div>
														</td>
                                                    </tr>
                                                    <tr>
                                                    	<td valign="top" style="padding-top: 0;padding-bottom: 0;border-collapse: collapse;">
                                                          <table border="0" cellpadding="10" cellspacing="0" width="100%" class="templateDataTable" style="background-color: #FFFFFF;border: 1px solid #DDDDDD;">
                                                              <tr>
                                                                  <th scope="col" valign="top" width="25%" class="dataTableHeading" mc:edit="data_table_heading00" style="background-color: #D8E2EA;color: #336699;font-family: Helvetica;font-size: 14px;font-weight: bold;line-height: 150%;text-align: left;">
                                                                    USUARIO
                                                                  </th>
                                                                  <th scope="col" valign="top" width="25%" class="dataTableHeading" mc:edit="data_table_heading01" style="background-color: #D8E2EA;color: #336699;font-family: Helvetica;font-size: 14px;font-weight: bold;line-height: 150%;text-align: left;">
                                                                    PASSWORD
                                                                  </th>
                                                              </tr>
                                                              <tr>
                                                                  <td valign="top" class="dataTableContent" style="border-collapse: collapse;border-top: 1px solid #DDDDDD;border-bottom: 0;color: #202020;font-family: Helvetica;font-size: 12px;font-weight: bold;line-height: 150%;text-align: left;">
                                                                    \${username}
                                                                  </td>
                                                                  <td valign="top" class="dataTableContent" style="border-collapse: collapse;border-top: 1px solid #DDDDDD;border-bottom: 0;color: #202020;font-family: Helvetica;font-size: 12px;font-weight: bold;line-height: 150%;text-align: left;">
                                                                    \${password}
                                                                  </td>
                                                              </tr>
                                                          </table>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" class="bodyContent" style="border-collapse: collapse;background-color: #FFFFFF;">
                                                            <div mc:edit="std_content01" style="color: #505050;font-family: Arial;font-size: 14px;line-height: 150%;text-align: left;">
                                                                Vamos a comenzar ya!
                                                            </div>
														</td>
                                                    </tr>
                                                    <tr>
                                                    	<td align="center" valign="top" style="padding-top: 0;border-collapse: collapse;">
                                                        	<table border="0" cellpadding="15" cellspacing="0" class="templateButton" style="-moz-border-radius: 3px;-webkit-border-radius: 3px;background-color: #336699;border: 0;border-radius: 3px;color: #FFFFFF;font-family: Arial;font-size: 15px;font-weight: bold;letter-spacing: -.5px;line-height: 100%;text-align: center;text-decoration: none;border-collapse: separate;">
                                                            	<tr>
                                                                	<td valign="middle" class="templateButtonContent" style="border-collapse: collapse;">
                                                                    	<div mc:edit="std_content02">
                                                                        	<a href="http://bellstrike.com/404" target="_blank" style="color: #FFFFFF;font-family: Arial;font-size: 15px;font-weight: bold;letter-spacing: -.5px;line-height: 100%;text-align: center;text-decoration: none;">Ir al sistema emprendedor</a>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <!-- // End Module: Standard Content  -->
                                                
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Body  -->
                                </td>
                            </tr>
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Footer  -->
                                	<table border="0" cellpadding="10" cellspacing="0" width="600" id="templateFooter" style="background-color: #FFFFFF;border-top: 0;">
                                    	<tr>
                                        	<td valign="top" class="footerContent" style="border-collapse: collapse;">
                                            
                                                <!-- // Begin Module: Transactional Footer  -->
                                                <table border="0" cellpadding="10" cellspacing="0" width="100%">
                                                    <tr>
                                                        <td valign="top" style="border-collapse: collapse;">
                                                            <div mc:edit="std_footer" style="color: #707070;font-family: Arial;font-size: 12px;line-height: 125%;text-align: center;">
                                                                Insurgentes Sur 1940, Colonia Florida, Delegación Álvaro Obregón, México DF 01030
                                                                <br>
                                                                México, Distrito Federal, Tel.(55) 5729-9100 | 01(800) 08 ECONOMIA [32-666]
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <!-- // End Module: Transactional Footer  -->
                                            
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Footer  -->
                                </td>
                            </tr>
                        </table>
                        <br>
                    </td>
                </tr>
            </table>
        </center>
    </body>
</html>

"""
		originalBody = """\
		Bienvenido al INADEM \${applicantMail}, para confirmar
		su password por favor dé click en la siguiente liga:
		<a href="http://localhost:9000/#/tokenConfirm/\${token}">http://localhost:9000/#/tokenConfirm/\${token}</a>
"""
		fromMail = "developers@ediaz.me"
		fromAlias = "Lucasian DEV"
		bccs = ['iamedu@gmail.com']
	}
	REGISTRO_EXTERNO(MailTemplate) {
		key = "REGISTRO_EXTERNO"
		title = "Bienvenido al Sistema Emprendedor"
		body = """\

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        
        <!-- Facebook sharing information tags -->
        <meta property="og:title" content="Bienvenido al Sistema Emprendedor">
        
        <title>Bienvenido al Sistema Emprendedor</title>
		
	</head>
    <body leftmargin="0" marginwidth="0" topmargin="0" marginheight="0" offset="0" style="-webkit-text-size-adjust: none;margin: 0;padding: 0;background-color: #FAFAFA;width: 100%;">
    	<center>
        	<table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%" id="backgroundTable" style="margin: 0;padding: 0;background-color: #FAFAFA;height: 100%;width: 100%;">
            	<tr>
                	<td align="center" valign="top" style="padding-top: 20px;border-collapse: collapse;">
                    	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateContainer" style="border: 1px solid #DDDDDD;background-color: #FFFFFF;">
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Header  -->
                                	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateHeader" style="background-color: #FFFFFF;border-bottom: 0;">
                                        <tr>
                                            <td class="headerContent" style="border-collapse: collapse;color: #202020;font-family: Arial;font-size: 34px;font-weight: bold;line-height: 100%;padding: 0;text-align: center;vertical-align: middle;">
                                            
                                            	<!-- // Begin Module: Standard Header Image  -->
                                            	<img src="cid:wideHeader" style="max-width: 600px;border: 0;height: auto;line-height: 100%;outline: none;text-decoration: none;" id="headerImage campaign-icon" mc:label="header_image" mc:edit="header_image" mc:allowdesigner mc:allowtext>
                                            	<!-- // End Module: Standard Header Image  -->
                                            
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Header  -->
                                </td>
                            </tr>
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Body  -->
                                	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateBody">
                                    	<tr>
                                            <td valign="top" style="border-collapse: collapse;">
                                
                                                <!-- // Begin Module: Standard Content  -->
                                                <table border="0" cellpadding="20" cellspacing="0" width="100%">
                                                    <tr>
                                                        <td valign="top" class="bodyContent" style="border-collapse: collapse;background-color: #FFFFFF;">
                                                            <div mc:edit="std_content00" style="color: #505050;font-family: Arial;font-size: 14px;line-height: 150%;text-align: left;">
                                                                <h2 class="h2" style="color: #202020;display: block;font-family: Arial;font-size: 30px;font-weight: bold;line-height: 100%;margin-top: 0;margin-right: 0;margin-bottom: 10px;margin-left: 0;text-align: left;">Bienvenido al Sistema Emprendedor</h2>
								<p>
								Estimado(a) \${toName}, te hemos creado una cuenta para el Sistema Emprendedor.
								</p>
                                                                <p>
                                                                El sistema emprendedor es la herramienta que te permite apoyar
                                                                las buenas de los emprendedores mexicanos.
                                                                </p>
                                                                <strong>Como empezar:</strong> En este correo verás el nombre de usuario (tu correo electrónico) y la contraseña que te fueron asignadas, entra con ellas y no olvides cambiar tu contraseña! 
                                                                Una vez dentro deberás de verificar y completar tus datos.
                                                            </div>
														</td>
                                                    </tr>
                                                    <tr>
                                                    	<td valign="top" style="padding-top: 0;padding-bottom: 0;border-collapse: collapse;">
                                                          <table border="0" cellpadding="10" cellspacing="0" width="100%" class="templateDataTable" style="background-color: #FFFFFF;border: 1px solid #DDDDDD;">
                                                              <tr>
                                                                  <th scope="col" valign="top" width="25%" class="dataTableHeading" mc:edit="data_table_heading00" style="background-color: #D8E2EA;color: #336699;font-family: Helvetica;font-size: 14px;font-weight: bold;line-height: 150%;text-align: left;">
                                                                    USUARIO
                                                                  </th>
                                                                  <th scope="col" valign="top" width="25%" class="dataTableHeading" mc:edit="data_table_heading01" style="background-color: #D8E2EA;color: #336699;font-family: Helvetica;font-size: 14px;font-weight: bold;line-height: 150%;text-align: left;">
                                                                    PASSWORD
                                                                  </th>
                                                              </tr>
                                                              <tr>
                                                                  <td valign="top" class="dataTableContent" style="border-collapse: collapse;border-top: 1px solid #DDDDDD;border-bottom: 0;color: #202020;font-family: Helvetica;font-size: 12px;font-weight: bold;line-height: 150%;text-align: left;">
                                                                    \${username}
                                                                  </td>
                                                                  <td valign="top" class="dataTableContent" style="border-collapse: collapse;border-top: 1px solid #DDDDDD;border-bottom: 0;color: #202020;font-family: Helvetica;font-size: 12px;font-weight: bold;line-height: 150%;text-align: left;">
                                                                    \${password}
                                                                  </td>
                                                              </tr>
                                                          </table>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" class="bodyContent" style="border-collapse: collapse;background-color: #FFFFFF;">
                                                            <div mc:edit="std_content01" style="color: #505050;font-family: Arial;font-size: 14px;line-height: 150%;text-align: left;">
                                                                Vamos a comenzar ya!
                                                            </div>
														</td>
                                                    </tr>
                                                    <tr>
                                                    	<td align="center" valign="top" style="padding-top: 0;border-collapse: collapse;">
                                                        	<table border="0" cellpadding="15" cellspacing="0" class="templateButton" style="-moz-border-radius: 3px;-webkit-border-radius: 3px;background-color: #336699;border: 0;border-radius: 3px;color: #FFFFFF;font-family: Arial;font-size: 15px;font-weight: bold;letter-spacing: -.5px;line-height: 100%;text-align: center;text-decoration: none;border-collapse: separate;">
                                                            	<tr>
                                                                	<td valign="middle" class="templateButtonContent" style="border-collapse: collapse;">
                                                                    	<div mc:edit="std_content02">
                                                                        	<a href="http://bellstrike.com/404" target="_blank" style="color: #FFFFFF;font-family: Arial;font-size: 15px;font-weight: bold;letter-spacing: -.5px;line-height: 100%;text-align: center;text-decoration: none;">Ir al sistema emprendedor</a>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <!-- // End Module: Standard Content  -->
                                                
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Body  -->
                                </td>
                            </tr>
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Footer  -->
                                	<table border="0" cellpadding="10" cellspacing="0" width="600" id="templateFooter" style="background-color: #FFFFFF;border-top: 0;">
                                    	<tr>
                                        	<td valign="top" class="footerContent" style="border-collapse: collapse;">
                                            
                                                <!-- // Begin Module: Transactional Footer  -->
                                                <table border="0" cellpadding="10" cellspacing="0" width="100%">
                                                    <tr>
                                                        <td valign="top" style="border-collapse: collapse;">
                                                            <div mc:edit="std_footer" style="color: #707070;font-family: Arial;font-size: 12px;line-height: 125%;text-align: center;">
                                                                Insurgentes Sur 1940, Colonia Florida, Delegación Álvaro Obregón, México DF 01030
                                                                <br>
                                                                México, Distrito Federal, Tel.(55) 5729-9100 | 01(800) 08 ECONOMIA [32-666]
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <!-- // End Module: Transactional Footer  -->
                                            
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Footer  -->
                                </td>
                            </tr>
                        </table>
                        <br>
                    </td>
                </tr>
            </table>
        </center>
    </body>
</html>

"""
		originalBody = """\
		Bienvenido al INADEM \${applicantMail}, para confirmar
		su password por favor dé click en la siguiente liga:
		<a href="http://localhost:9000/#/tokenConfirm/\${token}">http://localhost:9000/#/tokenConfirm/\${token}</a>
"""
		fromMail = "developers@ediaz.me"
		fromAlias = "Lucasian DEV"
		bccs = ['iamedu@gmail.com']
	}
	REGISTRO_EVALUADOR(MailTemplate) {
		key = "REGISTRO_EVALUADOR"
		title = "Bienvenido al Sistema Emprendedor"
		body = """\

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        
        <!-- Facebook sharing information tags -->
        <meta property="og:title" content="Bienvenido al Sistema Emprendedor">
        
        <title>Bienvenido al Sistema Emprendedor</title>
		
	</head>
    <body leftmargin="0" marginwidth="0" topmargin="0" marginheight="0" offset="0" style="-webkit-text-size-adjust: none;margin: 0;padding: 0;background-color: #FAFAFA;width: 100%;">
    	<center>
        	<table border="0" cellpadding="0" cellspacing="0" height="100%" width="100%" id="backgroundTable" style="margin: 0;padding: 0;background-color: #FAFAFA;height: 100%;width: 100%;">
            	<tr>
                	<td align="center" valign="top" style="padding-top: 20px;border-collapse: collapse;">
                    	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateContainer" style="border: 1px solid #DDDDDD;background-color: #FFFFFF;">
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Header  -->
                                	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateHeader" style="background-color: #FFFFFF;border-bottom: 0;">
                                        <tr>
                                            <td class="headerContent" style="border-collapse: collapse;color: #202020;font-family: Arial;font-size: 34px;font-weight: bold;line-height: 100%;padding: 0;text-align: center;vertical-align: middle;">
                                            
                                            	<!-- // Begin Module: Standard Header Image  -->
                                            	<img src="cid:wideHeader" style="max-width: 600px;border: 0;height: auto;line-height: 100%;outline: none;text-decoration: none;" id="headerImage campaign-icon" mc:label="header_image" mc:edit="header_image" mc:allowdesigner mc:allowtext>
                                            	<!-- // End Module: Standard Header Image  -->
                                            
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Header  -->
                                </td>
                            </tr>
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Body  -->
                                	<table border="0" cellpadding="0" cellspacing="0" width="600" id="templateBody">
                                    	<tr>
                                            <td valign="top" style="border-collapse: collapse;">
                                
                                                <!-- // Begin Module: Standard Content  -->
                                                <table border="0" cellpadding="20" cellspacing="0" width="100%">
                                                    <tr>
                                                        <td valign="top" class="bodyContent" style="border-collapse: collapse;background-color: #FFFFFF;">
                                                            <div mc:edit="std_content00" style="color: #505050;font-family: Arial;font-size: 14px;line-height: 150%;text-align: left;">
                                                                <h2 class="h2" style="color: #202020;display: block;font-family: Arial;font-size: 30px;font-weight: bold;line-height: 100%;margin-top: 0;margin-right: 0;margin-bottom: 10px;margin-left: 0;text-align: left;">Bienvenido al Sistema Emprendedor</h2>
								<p>
								Estimado(a) \${toName}, te hemos creado una cuenta para el Sistema Emprendedor.
								</p>
                                                                <p>
                                                                El sistema emprendedor es la herramienta que te permite apoyar
                                                                las buenas de los emprendedores mexicanos.
                                                                </p>
                                                                <strong>Como empezar:</strong> En este correo verás el nombre de usuario (tu correo electrónico) y la contraseña que te fueron asignadas, entra con ellas y no olvides cambiar tu contraseña! 
                                                                Una vez dentro deberás de verificar y completar tus datos.
                                                            </div>
														</td>
                                                    </tr>
                                                    <tr>
                                                    	<td valign="top" style="padding-top: 0;padding-bottom: 0;border-collapse: collapse;">
                                                          <table border="0" cellpadding="10" cellspacing="0" width="100%" class="templateDataTable" style="background-color: #FFFFFF;border: 1px solid #DDDDDD;">
                                                              <tr>
                                                                  <th scope="col" valign="top" width="25%" class="dataTableHeading" mc:edit="data_table_heading00" style="background-color: #D8E2EA;color: #336699;font-family: Helvetica;font-size: 14px;font-weight: bold;line-height: 150%;text-align: left;">
                                                                    USUARIO
                                                                  </th>
                                                                  <th scope="col" valign="top" width="25%" class="dataTableHeading" mc:edit="data_table_heading01" style="background-color: #D8E2EA;color: #336699;font-family: Helvetica;font-size: 14px;font-weight: bold;line-height: 150%;text-align: left;">
                                                                    PASSWORD
                                                                  </th>
                                                              </tr>
                                                              <tr>
                                                                  <td valign="top" class="dataTableContent" style="border-collapse: collapse;border-top: 1px solid #DDDDDD;border-bottom: 0;color: #202020;font-family: Helvetica;font-size: 12px;font-weight: bold;line-height: 150%;text-align: left;">
                                                                    \${username}
                                                                  </td>
                                                                  <td valign="top" class="dataTableContent" style="border-collapse: collapse;border-top: 1px solid #DDDDDD;border-bottom: 0;color: #202020;font-family: Helvetica;font-size: 12px;font-weight: bold;line-height: 150%;text-align: left;">
                                                                    \${password}
                                                                  </td>
                                                              </tr>
                                                          </table>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" class="bodyContent" style="border-collapse: collapse;background-color: #FFFFFF;">
                                                            <div mc:edit="std_content01" style="color: #505050;font-family: Arial;font-size: 14px;line-height: 150%;text-align: left;">
                                                                Vamos a comenzar ya!
                                                            </div>
														</td>
                                                    </tr>
                                                    <tr>
                                                    	<td align="center" valign="top" style="padding-top: 0;border-collapse: collapse;">
                                                        	<table border="0" cellpadding="15" cellspacing="0" class="templateButton" style="-moz-border-radius: 3px;-webkit-border-radius: 3px;background-color: #336699;border: 0;border-radius: 3px;color: #FFFFFF;font-family: Arial;font-size: 15px;font-weight: bold;letter-spacing: -.5px;line-height: 100%;text-align: center;text-decoration: none;border-collapse: separate;">
                                                            	<tr>
                                                                	<td valign="middle" class="templateButtonContent" style="border-collapse: collapse;">
                                                                    	<div mc:edit="std_content02">
                                                                        	<a href="http://bellstrike.com/404" target="_blank" style="color: #FFFFFF;font-family: Arial;font-size: 15px;font-weight: bold;letter-spacing: -.5px;line-height: 100%;text-align: center;text-decoration: none;">Ir al sistema emprendedor</a>
                                                                        </div>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <!-- // End Module: Standard Content  -->
                                                
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Body  -->
                                </td>
                            </tr>
                        	<tr>
                            	<td align="center" valign="top" style="border-collapse: collapse;">
                                    <!-- // Begin Template Footer  -->
                                	<table border="0" cellpadding="10" cellspacing="0" width="600" id="templateFooter" style="background-color: #FFFFFF;border-top: 0;">
                                    	<tr>
                                        	<td valign="top" class="footerContent" style="border-collapse: collapse;">
                                            
                                                <!-- // Begin Module: Transactional Footer  -->
                                                <table border="0" cellpadding="10" cellspacing="0" width="100%">
                                                    <tr>
                                                        <td valign="top" style="border-collapse: collapse;">
                                                            <div mc:edit="std_footer" style="color: #707070;font-family: Arial;font-size: 12px;line-height: 125%;text-align: center;">
                                                                Insurgentes Sur 1940, Colonia Florida, Delegación Álvaro Obregón, México DF 01030
                                                                <br>
                                                                México, Distrito Federal, Tel.(55) 5729-9100 | 01(800) 08 ECONOMIA [32-666]
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>
                                                <!-- // End Module: Transactional Footer  -->
                                            
                                            </td>
                                        </tr>
                                    </table>
                                    <!-- // End Template Footer  -->
                                </td>
                            </tr>
                        </table>
                        <br>
                    </td>
                </tr>
            </table>
        </center>
    </body>
</html>

"""
		originalBody = """\
		Bienvenido al INADEM \${applicantMail}, para confirmar
		su password por favor dé click en la siguiente liga:
		<a href="http://localhost:9000/#/tokenConfirm/\${token}">http://localhost:9000/#/tokenConfirm/\${token}</a>
"""
		fromMail = "developers@ediaz.me"
		fromAlias = "Lucasian DEV"
		bccs = ['iamedu@gmail.com']
	}
}
