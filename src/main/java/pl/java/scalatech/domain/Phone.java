package pl.java.scalatech.domain;

import pl.java.scalatech.domain.common.AbstractEntity;


public class Phone extends AbstractEntity{


    private static final long serialVersionUID = -2151027066005229271L;

    private String number;

    private PhoneType type;


    //m2o
    private Employee employee;
}