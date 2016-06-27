package pl.java.scalatech.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import lombok.extern.slf4j.Slf4j;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import net.sf.log4jdbc.tools.Log4JdbcCustomFormatter;
import net.sf.log4jdbc.tools.LoggingType;

@Configuration
@Slf4j
@Profile("logger")
public class JpaLoggerConfig {

    public JpaLoggerConfig() {
     log.info("++++ JpaLoggerConfig....");
    }

    private DataSource dataSourceOrginal() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        log.info("+++++ dataSource init ....");        
        Log4jdbcProxyDataSource dataSource = new Log4jdbcProxyDataSource(dataSourceOrginal());
        dataSource.setLogFormatter(logFormater());
        return dataSource;
    }

    @Bean
    public Log4JdbcCustomFormatter logFormater() {
        Log4JdbcCustomFormatter formatter = new Log4JdbcCustomFormatter();
        formatter.setLoggingType(LoggingType.SINGLE_LINE);
        formatter.setSqlPrefix("SQL:\r");
        return formatter;
    }
/*
 * HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("db.url"));
        dataSourceConfig.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSourceConfig.setUsername(env.getRequiredProperty("db.username"));
        dataSourceConfig.setPassword(env.getRequiredProperty("db.password"));
        return new HikariDataSource(dataSourceConfig);
        
        =================================================
         
          @Bean(name="hikariDataSource",destroyMethod="close")
    public DataSource hikariDataSource() {
        log.info( "configure hikariCP config" );
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName( driverClassName );
      // dataSource.setDataSourceProperties( hikariCPConfig.getHikariDatasource() );
        dataSource.setUsername( username );
        dataSource.setPassword( password );
        dataSource.setJdbcUrl( url );
        dataSource.addDataSourceProperty("dataSource.cachePrepStmts", "true");
        dataSource.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
        dataSource.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
        dataSource.addDataSourceProperty("dataSource.useServerPrepStmts", "true");
        dataSource.setMaximumPoolSize(80);
        dataSource.setConnectionTimeout(2000);
        dataSource.setMinimumIdle(30);
        dataSource.setMetricRegistry(metricRegistry);
        dataSource.setConnectionTestQuery("SELECT 1;");

        return dataSource;
    }
 */
}
