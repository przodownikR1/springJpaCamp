package pl.java.scalatech.exercise.creating;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.SpringPersistenceConfig;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringPersistenceConfig.class})
@ActiveProfiles("xml")
//@ActiveProfiles("withoutXml")
public class CreateSessionByPersistentContextTest {
    
    @PersistenceContext
    private EntityManager em;
    
    @Test
    public void shouldEmSession(){
        Assertions.assertThat(em).isNotNull();
    }
}
