#Emprendedor

##Introducción

**Emprendedor** es un proyecto creado por los super desarrolladores de Licasian México, desarrollado sobre Groovy (Java Interpreter) y el Framework Grails, quienes han puesto tiempo, esfuerzo y tacos en hacer que esta herramienta cumpla con los requerimientos que necesita la dependecia del Gobierno INADEM.


##Índice

 1. [Requerimientos](#requirements)
 2. [Descarga](#download)
 3. [Configuración de Grails](#grailsConfiguration)
 4. [Iniciar Grails](#startGrails)
 5. [Iniciar Grunt Server](#startGrunt)
 6. Problemas con Grails
 7. [Problemas con Grunt Server](#gruntProblems)

##1.<a name="requirements"></a> Requerimientos

 - **Redis** v2.8.x 
 - **Java** VM v1.7.x
 - **JDK** v1.7.x
 - **Groovy** v2.4.x
 - **Grails** v2.2.x
 - **Node** v0.10.x
 - **Grunt-cli** v0.13.x
 - **Bower** v1.3.x
 - **Yeoman** v1.4.x
 - **Git** +v1.5
 - **Ruby, Ruby Gems** y **compass**
 
> Nota: Es necesario tener instaladas las versiones solicitadas dado que pueden ocasionar problemas al levantar la plataforma.

##2.<a name="download"></a> Descarga

Puede descargar el paquete completo en un [archivo zip]() o bien usando git en la consola ingresando el siguiente comando:
```
git clone https://github.com/just-cloud/inadem.git -b master
```

Si se ha descargado en formato comprimido es necesario desempaquetar y una vez se halla hecho tendremos un directorio con el nombre 'inadem' (mismo que se tendra si se clono el proyecto desde el repositorio) en cual desde este momento llamaremos **directorio Base**.

##3.<a name="grailsConfiguration"></a> Configuración de Grails

Antes de ejecutar e iniciar la plataforma es necesario agregar ciertas opciones (variables) de configuración en el Sistema Operativo. Una de ellas es la variable `JAVA_OPTS` y para mostrarla en entornos Unix ingresaremos a la consola la siguiente instrucción:

```
env | grep JAVA_OPTS
```

>Nota: La variable `JAVA_OPTS` indica a Java la cantidad de memoria RAM a utilizar en la compilación y ejecución del entorno.

La salida debe ser semejante a la siguiente:

```
$ JAVA_OPTS=-Xms2048m -Xmx2048m -XX:MaxPermSize=512m -XX:ReservedCodeCacheSize=256m
```

Donde el primer parámetro `-Xmx2048m` indica la máxima cantidad de memoria RAM a consumir (Megabytes), en el ejemplo anterior se tiene configurada para 2GB aproximados, si se desea por ejemplo cambiar a 1GB (1024 MB) se puede indicar de la siguiente manera: `-Xms1024m`. El siguiente parámetro (`-Xms2048m`) es parecida a la anterior solamente que indica el minimo de memoria RAM a usar. En seguida el parámetro que indica el bloque máximo a utilizar (`-XX:MaxPermSize=512m`) y ya por último el caché a reservar (`-XX:ReservedCodeCacheSize=256m`).

En caso de no tener esta variable se puede agregar ingresando la siguiente línea en la consola:
```
export JAVA_OPTS=$(-Xms2048m -Xmx2048m -XX:MaxPermSize=512m -XX:ReservedCodeCacheSize=256m)
```

###Proxy en JAVA_OPTS

Si hay un proxy de tipo Socks en la red en la que se encuentra se deben añadir 2 parámetros extra a la variable `JAVA_OPTS` que indican la configuración del Proxy. Para agregarlas basta hacer lo siguiente:
```
export JAVA_OPTS=$(-Xms2048m -Xmx2048m -XX:MaxPermSize=512m -XX:ReservedCodeCacheSize=256m -DsocksProxyHost=localhost -DsocksProxyPort=9988)
```

Donde el último parámetro `socksProxyPort` indica el puerto por el cual están saliendo las peticiones; si el proxy está ejecutando en un puerto diferente se debe de indicar en la consola, por ejemplo para el puerto **8080**:

```
export JAVA_OPTS=$(-Xms2048m -Xmx2048m -XX:MaxPermSize=512m -XX:ReservedCodeCacheSize=256m -DsocksProxyHost=localhost -DsocksProxyPort=8080)
```

Ya por último, para acelerar la compilación vamos a abrir un archivo de configuración del Grails que se encuentra en la siguiente ruta del **Directorio Base** `./fpyme/grails-app/conf/DataSource.groovy` y comentaremos la directiva `dbCreate` de la siguiente manera:

```python
driverClassName = "oracle.jdbc.OracleDriver"
//dbCreate = "update"
url = "jdbc:oracle:thin:@10.100.30.12:1521:qadgi2"
```

##4.<a name="startGrails"></a> Iniciar Grails

###Pero primero Redis
Antes de iniciar grails es necesario iniciar una instancia de Redis, ya que en ella se almacenan las sesiones generadas. Para iniciar redis, en la consola ingresamos lo siguiente:

```
redis-server
```

Redis nos responderá con el siguiente mensaje si todo ha salido bien:

```
[1043] 29 Apr 02:43:33.099 # Server started, Redis version 2.8.19
[1043] 29 Apr 02:43:33.099 * The server is now ready to accept connections on port 6379
```

###Grails

Ahora debemos saber que la aplicación en Grails (backend) se encuentra dentro del directorio *fpyme*, el cual ingresaremos en línea de comandos:

```
cd inadem/fpyme
```

Como primer paso compilaremos el proyecto, para ello en línea de comandos ingresaremos la siguiente instrucción:

```
grails compile
```

Este proceso puede tomar varios minutos así que en lo que termina la compilación podemos ir por un café.

Una vez terminada la compilación correremos la aplicación ingresando la siguiente instrucción:

```
grails run-app
```

Para saber si la aplicación está en línea grails debe de mostrarnos una salida parecida a esta:

```
| Server running. Browse to http://localhost:8090/
| Application loaded in interactive mode. Type 'stop-app' to shutdown.
| Enter a script name to run. Use TAB for completion: 
```

Con esto ya tenemos el servidor Backend junto con los endpoints correspondientes listos para usarlos y consumirlos. Para detener el servidor bien podemos ingresar una de las siguientes instrucciónes: `quit` o `stop-app`.

##5.<a name="startGrunt"></a> Iniciar Grunt Server

En este paso iniciaremos el proceso para levantar el Grunt server (instancia de Node.js) para el servidor Frontend. Como primer paso es necesario entrar al directorio en línea de comandos **Directorio Base:** 

```
cd ./fpyme-front/
```

Ahora como siguiente paso es iniciar la instalación de Yeoman, Grunt y Bower (en caso de no tenerlos instalados globalmente):

```
npm install -g yo grunt-cli bower
```

Como siguiente paso, ahora instalaremos las dependencias Boostrap, Angular y Karma:

```
npm install -g generator-angular generator-karma generator-bootstrap
```

Ahora instalaremos las dependencias locales:

```
npm install
```

En seguida compilaremos los archivos JS y CSS:

```
bower install
```

Y ya por último inciaremos el servidor Node.js (Grunt Server):

```
grunt server
```

Y listo, tendremos un servidor local escuchando por el puerto **9000**.

##7.<a name="gruntProblems"></a> Problemas con Grunt Server

###Proxy
Si se está usando un proxy en la red que está conectado, a veces Grunt no puede ejecutarse debido a un fallo en el tiempo de ejecución del módulo `grunt-connect-proxy`. Para saber si el error existe usted visualizara un mensaje parecido a este:

```
Loading "Gruntfile.js" tasks...ERROR
>> TypeError: Cannot read property 'prototype' of undefined
Warning: Task "server" not found. Use --force to continue.

Aborted due to warnings.
```

Para solventar este problema [descargaremos]() esta versión especial del mismo módulo y reemplazaremos el existente en la siguiente ruta **Directorio Base:** `./fpyme-front/node_modules/`.

###Assets

Otro problema que se puede suscitar es que Bower no crea en el directorio `components` dentro de la ruta **Directorio Base** `./fpyme-front/app/` dando como resultado que los archivos Javascript y CSS (y algunas imágenes) no carguen. En caso de ser así [descargaremos]() el comprimido de esta ruta y lo colocaremos en el **Directorio Base** `./fpyme-front/app/` y con ello solucionaremos este problema.