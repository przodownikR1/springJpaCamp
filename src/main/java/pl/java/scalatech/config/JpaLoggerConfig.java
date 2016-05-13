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

}
