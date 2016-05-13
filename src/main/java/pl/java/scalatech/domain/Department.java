package pl.java.scalatech.domain;

import java.util.HashSet;
import java.util.Set;

import pl.java.scalatech.domain.common.AbstractEntity;

public class Department extends AbstractEntity{


    private String name;
  //Bidirectional
    private Set<Employee> employees = new HashSet<>();
}