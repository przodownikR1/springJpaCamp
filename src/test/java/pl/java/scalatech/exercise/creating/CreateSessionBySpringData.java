package pl.java.scalatech.exercise.creating;
import javax.persistence.EntityManager;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringJpaDataConfig.class})
public class CreateSessionBySpringData {
    @Autowired
    private EntityManager em;
    
    @Test
    public void shouldEntityManagerInject(){
        Assertions.assertThat(em).isNotNull();
    }
}
