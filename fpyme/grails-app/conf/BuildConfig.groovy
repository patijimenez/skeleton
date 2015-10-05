grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.7
grails.project.source.level = 1.7
//grails.project.war.file = "target/${appName}-${appVersion}.war"

// uncomment (and adjust settings) to fork the JVM to isolate classpaths
//grails.project.fork = [
//   run: [maxMemory:1024, minMemory:64, debug:false, maxPerm:256]
//]
grails.server.port.http=8090

grails.plugin.location.jms = 'plugins/jms-1.2'

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
      excludes 'bcprov-jdk15', 'bcpg-jdk15', 'bcprov-jdk15on', 'bcprov-jdk14', 'bcpg-jdk14'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
      	mavenRepo "http://oss.arcusys.com/mvn/content/groups/public/"
        mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
        mavenRepo "http://anonsvn.icesoft.org/repo/maven2/releases"
        mavenRepo "http://maven.forgerock.org/repo/releases"
        mavenRepo "http://maven.forgerock.org/repo/snapshots"
      	mavenRepo "https://maven.alfresco.com/nexus/content/repositories/releases/"
      	mavenRepo "https://maven.alfresco.com/nexus/content/groups/public/"
      	mavenRepo "http://jasperreports.sourceforge.net/maven2/"
        mavenRepo "https://repository.jboss.org/nexus/content/repositories/thirdparty-releases"
        mavenRepo "http://dl.bintray.com/iamedu/maven/"
        mavenRepo "http://dl.bintray.com/gerardo-dr/maven/"

    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.

        // runtime 'mysql:mysql-connector-java:5.1.22'
        compile "com.lucasian.crypt:signer-bouncy:0.0.2"
        compile "org.crazycake:shiro-redis:2.4.2.3-RELEASE"
        compile "org.quartz-scheduler:quartz:2.1.1"
				compile ('org.apache.shiro:shiro-aspectj:1.2.0') {
            excludes('quartz')
        }

        compile 'org.apache.activemq:activemq-core:5.7.0'
				compile "org.freemarker:freemarker:2.3.19"
        compile "org.icepdf:icepdf-core:5.0.1"
        compile "org.forgerock.opendj:opendj-ldap-sdk:2.5.0-SNAPSHOT"
        compile "net.sf.ehcache:ehcache-core:2.4.6"
        compile "org.fluttercode.datafactory:datafactory:0.8"
        compile "net.sf.dozer:dozer:5.3.2"
        compile "org.apache.tika:tika-core:1.3"
        compile "org.apache.tika:tika-parsers:1.3"
        compile "com.itextpdf:itextpdf:5.4.2"
        compile "com.itextpdf.tool:xmlworker:5.4.2"
        compile "net.sf.jasperreports:jasperreports:5.2.0"
        compile "org.apache.poi:poi-ooxml:3.9"
        compile "commons-codec:commons-codec:1.9"
        compile "org.codehaus.groovy.modules.http-builder:http-builder:0.6"
        compile "info.bliki.wiki:bliki-core:3.0.19"
        compile "com.google.zxing:core:2.3.0"
        //compile "com.hazelcast:hazelcast:3.1.5"
				compile "net.objectlab.kit:datecalc-common:1.2.0"
				compile "net.objectlab.kit:datecalc-joda:1.2.0"
        compile "org.commonjava.googlecode.markdown4j:markdown4j:2.2-cj-1.0"
		}

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.8.3"
        runtime ":resources:1.1.6"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.5"

        build ":tomcat:$grailsVersion"

        runtime ":database-migration:1.3.2"

        compile ":browser-detection:0.4.3"
        compile ':cache:1.0.1'
				compile(":shiro:1.1.4") {
          excludes('quartz')
        }
	    compile ':cookie:0.4'
			//compile ":jms:1.2"
			compile ":mail:1.0.1"
			compile ":fixtures:1.2"
    	compile ":joda-time:1.3.1"
      compile ":qr-code:0.1.4"
			//compile ":quartz:0.4.2"
    }
}
