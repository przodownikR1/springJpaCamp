package pl.java.scalatech.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;

import pl.java.scalatech.domain.common.AbstractEntity;

@Entity
public class Project extends AbstractEntity{


    protected String name;
    //m2m

    protected Collection<Employee> employees = new ArrayList<>();
}
