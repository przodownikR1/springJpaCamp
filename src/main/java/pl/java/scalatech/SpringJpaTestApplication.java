package pl.java.scalatech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.simple.Person;
import pl.java.scalatech.repository.simple.PersonRepo;
import pl.java.scalatech.repository.simple.SampleRepo;

@SpringBootApplication
@Slf4j
public class SpringJpaTestApplication implements CommandLineRunner {
@Autowired
    private PersonRepo personRepo;
    

@Autowired
private SampleRepo sampleRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        personRepo.save(Person.builder().name("slawek").pesel("34234234").build());
        log.info("++++  {}",personRepo.count());
        
        
        log.info("{}",sampleRepo.fetchWithPhones());
    }
}
