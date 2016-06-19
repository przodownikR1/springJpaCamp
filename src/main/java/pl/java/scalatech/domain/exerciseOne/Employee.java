package pl.java.scalatech.domain.exerciseOne;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import pl.java.scalatech.domain.common.AbstractEntity;

public class Employee extends AbstractEntity{

    private static final long serialVersionUID = -6882527852158059488L;
    private String name;
    private long salary;
    //DATA format
    private Date startDate;

    //O2O
    private Address address;

    //o2m
    //bidirectional
    private Collection<Phone> phones = new ArrayList<>();

    //m2o
    private Department dept;

    //m2o
    private Employee manager;

    //manager o2m
    private Collection<Employee> directs = new ArrayList<>();

    //m2m
    private Collection<Project> projects = new ArrayList<>();
}