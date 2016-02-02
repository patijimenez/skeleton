// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.app.context = "/"
grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
  all:           '*/*',
  atom:          'application/atom+xml',
  css:           'text/css',
  csv:           'text/csv',
  form:          'application/x-www-form-urlencoded',
  html:          ['text/html','application/xhtml+xml'],
  js:            'text/javascript',
  json:          ['application/json', 'text/json'],
  multipartForm: 'multipart/form-data',
  rss:           'application/rss+xml',
  text:          'text/plain',
  xml:           ['text/xml', 'application/xml']
]
grails.cache.enabled = false

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']
grails.resources.processing.enabled=false

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
  development {
    grails.logging.jul.usebridge = true
  }
  production {
    grails.logging.jul.usebridge = false
    // TODO: grails.serverURL = "http://www.changeme.com"
  }
}

// log4j configuration
log4j = {
  // Example of changing the log pattern for the default console appender:
  //
  //appenders {
  //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
  //}

  error  'org.codehaus.groovy.grails.web.servlet',        // controllers
    'org.codehaus.groovy.grails.web.pages',          // GSP
    'org.codehaus.groovy.grails.web.sitemesh',       // layouts
    'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
    'org.codehaus.groovy.grails.web.mapping',        // URL mapping
    'org.codehaus.groovy.grails.commons',            // core / classloading
    'org.codehaus.groovy.grails.plugins',            // plugins
    'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
    'org.springframework',
    'org.hibernate',
    'net.sf.ehcache.hibernate'

  debug "org.springframework.mail",
    "javax.mail"
}

environments {
  development {
    grails {
      mail {
        host = "smtp.mandrillapp.com"
        port = 587
        username = "iamedu@gmail.com"
        password = "yY436NDUhPxKEABppOhnVw"
        props = ["mail.smtp.auth":"true",
          "mail.smtp.socketFactory.port":"465",
          "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
          "mail.smtp.socketFactory.fallback":"false"]

        /* SE Smtp server

        host = "172.18.13.42"
        username = "sistemaemprendedor@economia.gob.mx"
        password = "Inadem2013"
        port = 25
        encoding = "utf-8"
        props = ["mail.smtp.auth":"false","mail.debug":true]
        */
      }
    }
    inadem {
      path {
        tmp = "/tmp/inadem"
        certs = "/inademweb/certs"
        real  = "/inademweb/repository"
      }
      /*ldap {
        admindn = "cn=admin,dc=inadem,dc=gob,dc=mx"
        adminpassword = "passware2014"
        host = "10.100.50.88"
        port = 389
        base = "ou=People,dc=inadem,dc=gob,dc=mx"

        /* LDAP  Internet Connection
        admindn = "cn=Directory Manager"
        adminpassword = "adminadmin"
        host = "inademdb.ediaz.me"
        port = 1389
        base = "ou=People,dc=inadem,dc=gob,dc=mx"
        
      }*/
    }
  }
  test {
    grails {
      mail {
        host = "mail.economia.gob.mx"
        username = "sistema.emprendedor"
        password = "emprendedor14"
        port = 25
        encoding = "utf-8"
        props = ["mail.smtp.auth":"false",
          "mail.smtp.port": "25"]
      }
    }
    inadem {
      path {
        tmp = "/home/admin-fpyme/temp"
        certs = "/u01/inadem/certs"
        real  = "/inademweb/repository"
      }
      ldap {
        admindn = "cn=admin,dc=inadem,dc=gob,dc=mx"
        adminpassword = "aecDfTmVsCSTGi"
        host = "172.18.11.158"
        port = 11589
        base = "ou=People,dc=inadem,dc=gob,dc=mx"
      }
    }
  }
  production {
    grails {
      mail {
        host = "mail.economia.gob.mx"
        username = "sistema.emprendedor"
        password = "emprendedor14"
        port = 25
        encoding = "utf-8"
        props = ["mail.smtp.auth":"true",
          "mail.smtp.port": "25"]
      }
    }
    inadem {
      path {
        tmp = "/home/admin-fpyme/temp"
        certs = "/u01/inadem/certs"
        real  = "/inademweb/repository"
      }
      ldap {
        admindn = "cn=admin,dc=inadem,dc=gob,dc=mx"
        adminpassword = "aecDfTmVsCSTGi"
        host = "10.100.20.164"
        port = 11589
        base = "ou=People,dc=inadem,dc=gob,dc=mx"
      }
    }
  }
}

grails {
  tomcat {
    nio = true
  }
}

jms {
  containers {
    standard {
      sessionTransacted = true
    }
  }
}
