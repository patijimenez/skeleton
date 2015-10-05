dataSource {
  pooled = true
  driverClassName = "org.h2.Driver"
  username = "sa"
  password = ""
}
hibernate {
  cache.use_second_level_cache = true
  cache.use_query_cache = true
  cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
  development {
    dataSource {
      driverClassName = "oracle.jdbc.OracleDriver"
//      dbCreate = "update"
      url = "jdbc:oracle:thin:@10.100.30.12:1521:qadgi2"
      dialect = org.hibernate.dialect.Oracle10gDialect
      pooled = true
      username = "FPYME_LECT"
      password = "SerqI1406"

      /*Producction */
      /*url = "jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = 10.100.30.28)(PORT = 1521)) (ADDRESS = (PROTOCOL = TCP)(HOST = 10.100.30.29)(PORT = 1521)) (LOAD_BALANCE = yes) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = INADEM) (FAILOVER_MODE = (TYPE = select) (METHOD = BASIC))))"
 			dialect = org.hibernate.dialect.Oracle10gDialect
	    pooled = true
  		username = "FPYME_LECT"
	    password = "Ks0804sdF"*/

      /* Internet Connection

      driverClassName = "oracle.jdbc.OracleDriver"
      dbCreate = "update"
      url = "jdbc:oracle:thin:@inademdb.ediaz.me:1521:XE"
      dialect = org.hibernate.dialect.Oracle10gDialect
      pooled = true
      username = "fpyme"
      password = "fpyme"
      */
    }
  }
  test {
    dataSource {
      dbCreate = "update"
      jndiName = "jdbc/alternoDS"
    }
  }
  production {
    dataSource {
      jndiName = "jdbc/alternoDS"
    }
  }
}
