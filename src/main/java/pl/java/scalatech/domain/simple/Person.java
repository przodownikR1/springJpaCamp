package pl.java.scalatech.domain.simple;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Person {
    
    @Id
    private Long id;
    
    private String name;

}
