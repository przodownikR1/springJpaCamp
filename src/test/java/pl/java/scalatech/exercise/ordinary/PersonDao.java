package pl.java.scalatech.exercise.ordinary;

import pl.java.scalatech.domain.simple.Person;

public interface PersonDao {

    Person findById(Long id);

    Long save(Person Person);

    void update(Person Person);

    void delete(Long id);

    void delete(Person conf);

    void deleteAll();

    Person findByName(String name);

}
