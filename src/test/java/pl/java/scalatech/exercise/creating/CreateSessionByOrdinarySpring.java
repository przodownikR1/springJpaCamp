package pl.java.scalatech.exercise.creating;

import static org.junit.runners.MethodSorters.NAME_ASCENDING;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.hibernate.SessionFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.simple.Person;
import pl.java.scalatech.exercise.ordinary.PersonDao;
import pl.java.scalatech.exercise.ordinary.SpringOrdinaDataConfig;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringOrdinaDataConfig.class})
@FixMethodOrder(NAME_ASCENDING)
@Transactional
public class CreateSessionByOrdinarySpring {
    @Autowired
    private SessionFactory em;
    @Autowired
    private PersonDao personDao;
    
    @Test
    public void shouldEntityManagerInject(){
        Assertions.assertThat(em).isNotNull();
        Assertions.assertThat(personDao).isNotNull();
    }
    
    @Test
    public void should_A_CreatePerson(){
        personDao.save(Person.builder().name("slawek.b").build());
    }
    
    @Test
    public void should_B_RetrieveByNamePerson(){
        personDao.save(Person.builder().name("test").build());
        Person loaded = personDao.findByName("test");
        Assertions.assertThat(loaded).isNotNull();
    }
    
    
    @Test
    public void should_C_RetrieveByIdPerson(){
        
        Person loaded = personDao.findById(1l);
        Assertions.assertThat(loaded).isNotNull();
    }
    
    @Test
    public void should_D_DeletePerson(){
        personDao.deleteAll();
        
       
    }
    
}
