package pl.java.scalatech.domain.exerciseOne;

import java.util.ArrayList;
import java.util.Collection;

import pl.java.scalatech.domain.common.AbstractEntity;

public class Project extends AbstractEntity{


    protected String name;
    //m2m

    protected Collection<Employee> employees = new ArrayList<>();
}
