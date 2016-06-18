package pl.java.scalatech.exercise.ordinary;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
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
        String[] packagesToScan = new String[]{"pl.java.scalatech.domain.sample"};
        sessionFactory.setPackagesToScan(packagesToScan);
        Properties hibernateProperties = createHibernateProps();
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    private Properties createHibernateProps() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
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
