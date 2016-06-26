package pl.java.scalatech.exercise.crud.naturalId;

import static pl.java.scalatech.utils.HibernateUtils.getSessionFactory;
import static pl.java.scalatech.utils.HibernateUtils.shutdown;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class NaturalIdTest {
    private static SessionFactory sf= null;
    @BeforeClass
    public static void init(){
        sf = getSessionFactory();
    }
    @AfterClass
    public static void close(){
        shutdown();
    }
    
    @Test
    public void shouldSavePerson(){
        //tODO
    }
    
    
    @Test
    public void shouldLoadedByNaturalIdPerson() {
        //TODO
    }
}
