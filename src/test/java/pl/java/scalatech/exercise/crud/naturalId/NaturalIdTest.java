package pl.java.scalatech.exercise.crud.naturalId;

import static pl.java.scalatech.utils.HibernateUtils.getSessionFactory;
import static pl.java.scalatech.utils.HibernateUtils.shutdown;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.simple.Person;

@Slf4j
public class NaturalIdTest {
    private static final String PESEL = "443333222";
    private static SessionFactory sf = null;

    @BeforeClass
    public static void init() {
        sf = getSessionFactory();
    }

    @AfterClass
    public static void close() {
        shutdown();
    }

    @Test
    public void shouldSavePerson() {
        Person person = Person.builder().name("przodownik").pesel(PESEL).build();
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();
            session.save(person);
            session.flush();
            Person loaded = session.load(Person.class, 1l);
            log.info("{}", loaded);

            tx.commit();
        } finally {
            session.close();
        }

    }

    @Test
    public void shouldLoadedByNaturalIdPerson() {

        Person person = Person.builder().name("przodownik").pesel(PESEL).build();
        Session session = sf.openSession();
        try {
            Transaction tx = session.beginTransaction();

            Person loaded = session.byNaturalId(Person.class).using("pesel", PESEL).load();
            log.info("loaded by naturalId : {}", loaded);

            tx.commit();
        } finally {
            session.close();
        }

    }

}
