package pl.java.scalatech.exercise.creating;

import org.assertj.core.api.Assertions;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.exercise.ordinary.SpringOrdinaDataConfig;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringOrdinaDataConfig.class})
public class CreateSessionByOrdinarySpring {
    @Autowired
    private SessionFactory em;
    
    @Test
    public void shouldEntityManagerInject(){
        Assertions.assertThat(em).isNotNull();
    }
}
