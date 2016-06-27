package pl.java.scalatech.session;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public final class HibernateUtils {

    private static SessionFactory sf;
    
    private static void populateParams(Configuration cfg) {
        cfg.setProperty("hibernate.show_sql","true");
        cfg.setProperty("hibernate.connection.driver_class","org.h2.Driver");
        cfg.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
        cfg.setProperty("hibernate.connection.password","");
        cfg.setProperty("hibernate.connection.url","jdbc:h2:mem:testdb");
        cfg.setProperty("hibernate.connection.username","sa");
        cfg.setProperty("hibernate.generate_statistics","true");
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");
        cfg.setProperty("hibernate.current_session_context_class", "thread");
    }
	
	 public static SessionFactory getSessionFactory(ClassMapper cm) {
	        log.info("+++ getConcreteEntitySessionFactory");
	        if (sf == null) {
	            Configuration cfg = new Configuration();    
	            populateParams(cfg);
	            // @formatter:off
	            cfg = cm.createCfgClassMapper(cfg);
	            // @formatter:on
	            cfg.setProperty("hibernate.generate_statistics","true");
	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
	            sf = cfg.buildSessionFactory(serviceRegistry);
	        }

	        return sf;

	    }

    private static Configuration createCfgClassMapper(Class[] clazz, Configuration cfg) {
        for (Class cl : clazz) {
            log.info("+++     mapped entity => {}",cl);
            cfg.addPackage("pl.java.scalatech.domain.sample").addAnnotatedClass(cl);
        }
        return cfg;
    }
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}