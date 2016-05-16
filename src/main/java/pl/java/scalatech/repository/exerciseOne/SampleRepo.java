package pl.java.scalatech.repository.exerciseOne;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleRepo {

    @Autowired
    private EntityManager em;



}
