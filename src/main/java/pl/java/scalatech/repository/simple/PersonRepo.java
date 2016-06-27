package pl.java.scalatech.repository.simple;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.simple.Person;
public interface PersonRepo extends JpaRepository<Person, Long>{

}
