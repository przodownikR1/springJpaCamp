package pl.java.scalatech.domain.simple;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Person {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @NaturalId
    private String pesel;

}
