package pl.java.scalatech.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pl.java.scalatech.repository.impl.Hibernate5PersonDaoImpl;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses=Hibernate5PersonDaoImpl.class)
//@EntityScan(basePackages="pl.java.scalatech.domain.simple")
@Profile("hib")
public class SpringOrdinaDataConfig {
    
 /*   @Resource(name="dataSource")
    public DataSource dataSource;
 */ 

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
}

    @Bean(name = "transactionManager")
    public HibernateTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(localSessionFactoryBean().getObject());
        return hibernateTransactionManager;
}
    
    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean localSessionFactoryBean() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        Properties hibernateProperties = createHibernateProps();
        sessionFactory.setHibernateProperties(hibernateProperties);
        String[] packagesToScan = new String[]{"pl.java.scalatech.domain.simple"};
        sessionFactory.setPackagesToScan(packagesToScan);
       
        return sessionFactory;
    }

    private Properties createHibernateProps() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.current_session_context_class","org.springframework.orm.hibernate5.SpringSessionContext");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        return hibernateProperties;
    }
    @Bean
    public HibernateTemplate hibernate5Template(SessionFactory sessionFactory) {
        return new HibernateTemplate(sessionFactory);
}
}
