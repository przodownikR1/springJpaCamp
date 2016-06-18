package pl.java.scalatech.exercise;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.PropertiesLoader;
import pl.java.scalatech.repository.exerciseOne.SampleRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PropertiesLoader.class, Jpa1Config.class })

@ActiveProfiles(value = "exerciseOne")
@Transactional
@Slf4j
@SqlDataExercise
public class JpaExerciseOneTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private SampleRepo sampleRepo;

    @Test
    public void shouldBoostrap() {
        assertThat(em).isNotNull();
        assertThat(sampleRepo).isNotNull();

    }

}
