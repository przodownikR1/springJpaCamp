package pl.java.scalatech.session;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.simple.Person;
@Slf4j
public class HibernateUtil
{
   private static SessionFactory sessionFactory = buildSessionFactory();
 
   private static SessionFactory buildSessionFactory()
   {
      try
      {
         if (sessionFactory == null)
         {
            Configuration configuration = new Configuration().configure(HibernateUtil.class.getResource("/hibernate.cfg.xml"));
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            configuration.addPackage("pl.java.scalatech.domain.simple")
            .addAnnotatedClass(Person.class);
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         }
         return sessionFactory;
      } catch (Throwable ex)
      {
         log.info("Initial SessionFactory creation failed. {}" , ex);
         throw new ExceptionInInitializerError(ex);
      }
   }
 
   public static SessionFactory getSessionFactory()
   {
      return sessionFactory;
   }
 
   public static void shutdown()
   {
      getSessionFactory().close();
   }
}