package pl.java.scalatech.exercise.creating;


import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import org.assertj.core.api.Assertions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.simple.Person;
import pl.java.scalatech.exercise.creating.sessionBuilder.HibernateUtil;
@Slf4j
@FixMethodOrder(NAME_ASCENDING)
public class CreateUsingStandardServiceRegistryBuilderTest {
    
    //AnnotationConfiguration,  ServiceRegistryBuilder  deprecated from hibernate 4
    
    SessionFactory sf = null;
    @Test
    public void should_A_CreateSession(){
        Assertions.assertThat(sf).isNotNull();
        Session session = sf.getCurrentSession();
        log.info("{}",session);
    }
    @Test
    public void should_B_SaveObject(){        
        Session session = sf.getCurrentSession();
        session.save(Person.builder().name("przodownik").build());
    }
    @Test
    public void should_C_RetrieveObject(){        
        Session session = sf.getCurrentSession();
        Person p = session.load(Person.class, 1l);
        Assertions.assertThat(p).isNotNull();
    }
}
