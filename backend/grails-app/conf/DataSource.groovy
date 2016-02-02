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

      dbCreate = "update"
      dialect = org.hibernate.dialect.PostgreSQLDialect
      driverClassName = "org.postgresql.Driver"
      url = "jdbc:postgresql://localhost/mschool"
      username = "u_mschool"
      password = "mschool"

      /* Oracle connection
      driverClassName = "oracle.jdbc.OracleDriver"
      dbCreate = "update"
      url = "jdbc:oracle:thin:@10.100.30.12:1521:service"
      dialect = org.hibernate.dialect.Oracle10gDialect
      pooled = true
      username = "*******"
      password = "*******"
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
