package pl.java.scalatech.exercise.creating;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.FixMethodOrder;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.simple.Person;
import pl.java.scalatech.exercise.creating.sessionBuilder.HibernateUtil;
@Slf4j
@FixMethodOrder(NAME_ASCENDING)
public class CreateUsingStandardServiceRegistryBuilderTest {
    
    //AnnotationConfiguration,  ServiceRegistryBuilder  deprecated from hibernate 4
    
    SessionFactory sf = HibernateUtil.getSessionFactory();
    
    @Test
    public void should_A_CreateSession(){
        assertThat(sf).isNotNull();
        Session session = sf.getCurrentSession();
        log.info("{}",session);
    }
    @Test
    public void should_B_SaveObject(){
        Session session = sf.openSession();
        try{        
        Transaction tx = session.beginTransaction();
        session.save(Person.builder().name("przodownik").build());
        tx.commit();
        }finally {
            session.close();
        }
        
    }
    @Test
    public void should_C_RetrieveObject(){        
        Session session = sf.openSession();
        try{
        List<Person> people = session.createCriteria(Person.class).list();
        assertThat(people).hasSize(1);        
        log.info("{}",people.get(0));
        }finally {
            session.close();
            
        }
    }
    @Test
    public void should_D_RetrieveByLoad(){
        Session session = sf.openSession();
        try{
            Person loaded = session.load(Person.class, 1l);            
            assertThat(loaded).isNotNull();
        }finally {
            session.close();
            
        }
        
    }
}
