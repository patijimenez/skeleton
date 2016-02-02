import org.apache.shiro.authc.credential.Sha256CredentialsMatcher

import org.forgerock.opendj.ldap.*
import mx.com.mschool.freemarker.InademTemplateLoader
import freemarker.template.Configuration
import grails.util.Environment

// Place your Spring DSL code here
beans = {
	credentialMatcher(Sha256CredentialsMatcher) {
		storedCredentialsHexEncoded = false
			hashIterations = 1024
			hashSalted = true
	}
	templateLoader(InademTemplateLoader) {
	}
	freemarkerConfiguration(Configuration) {
		templateLoader = templateLoader
	}

  /*ldapOptions(LDAPOptions) {
  }
  ldapConnectionFactory(LDAPConnectionFactory, application.config.inadem.ldap.host, application.config.inadem.ldap.port, ldapOptions) {
  // ldapConnectionFactory(LDAPConnectionFactory, "alfresco.ediaz.me", 1389, ldapOptions) {
  }
  heartBeatLdapFactory(Connections, ldapConnectionFactory) { bean ->
    bean.factoryMethod = "newHeartBeatConnectionFactory"
  }
  ldapConnectionPool(Connections, heartBeatLdapFactory, 10) { bean ->
    bean.factoryMethod = "newFixedConnectionPool"
  }*/
  
  mapper(org.dozer.DozerBeanMapper){
  }

  /*
  //Redis configuration

  jedisConfig(redis.clients.jedis.JedisPoolConfig){
    testOnBorrow = true
  }

  redisManager(org.crazycake.shiro.RedisManager) {
    config = jedisConfig
  }

  shiroCacheManager(mx.com.mschool.shiro.RedisCacheManagerSerializable) {
    redisManager = redisManager
  }

  shiroSessionDAO(org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO) {
    cacheManager = shiroCacheManager
  }*/

  shiroSessionManager(org.apache.shiro.web.session.mgt.DefaultWebSessionManager) {
    //sessionDAO = shiroSessionDAO   // Redis config
    sessionValidationSchedulerEnabled = false
  }

  shiroSecurityManager(org.apache.shiro.web.mgt.DefaultWebSecurityManager) {
    realm = ref('DbRealmWrapper')
    sessionManager = shiroSessionManager
    rememberMeManager = ref('shiroRememberMeManager')
  }

  schedulerFactory(org.quartz.impl.StdSchedulerFactory){
  }
  quartzScheduler(schedulerFactory) { bean ->
    bean.factoryMethod = "getScheduler"
    bean.initMethod = "start"
  }

  /*quartzScheduler(schedulerFactory) { bean ->
    bean.factoryMethod = "getScheduler"
    bean.initMethod = "start"
  }*/

  Environment.executeForCurrentEnvironment {
    development {
      jmsDestinationResolver(org.springframework.jms.support.destination.DynamicDestinationResolver)
      jmsConnectionFactory(org.apache.activemq.ActiveMQConnectionFactory) {
        brokerURL = 'vm://localhost'
      }
    }
    test {
      xmlns jee:"http://www.springframework.org/schema/jee"
      jee.'jndi-lookup'(id:"jmsConnectionFactory", 'jndi-name':"jms/inademConnectionFactory", proxyInterface: "javax.jms.ConnectionFactory")
      jmsDestinationResolver(org.springframework.jms.support.destination.JndiDestinationResolver) {
      }
      standardJmsTemplate(org.springframework.jms.core.JmsTemplate) {
        connectionFactory = ref('jmsConnectionFactory')
        destinationResolver = jmsDestinationResolver
      }
    }
    production {
      xmlns jee:"http://www.springframework.org/schema/jee"
      jee.'jndi-lookup'(id:"jmsConnectionFactory", 'jndi-name':"jms/inademConnectionFactory", proxyInterface: "javax.jms.ConnectionFactory")
      jmsDestinationResolver(org.springframework.jms.support.destination.JndiDestinationResolver) {
      }
      standardJmsTemplate(org.springframework.jms.core.JmsTemplate) {
        connectionFactory = ref('jmsConnectionFactory')
        destinationResolver = jmsDestinationResolver
      }
    }
  }
}
