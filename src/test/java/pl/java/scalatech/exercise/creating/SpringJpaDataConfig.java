package pl.java.scalatech.exercise.creating;

import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import pl.java.scalatech.domain.simple.Person;

@Configuration
@ComponentScan(basePackages = { "pl.java.scalatech.repository.simple" })
@EnableJpaRepositories(basePackageClasses=Person.class)
@EntityScan(basePackages = "pl.java.scalatech.domain.simple")
@PropertySource(value = "classpath:application-test.properties")
@Import({ DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class, PersistenceExceptionTranslationAutoConfiguration.class,
        PropertyPlaceholderAutoConfiguration.class })
public class SpringJpaDataConfig {

}
