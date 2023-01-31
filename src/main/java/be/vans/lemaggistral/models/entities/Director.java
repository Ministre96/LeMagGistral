package be.vans.lemaggistral.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@ToString
@AllArgsConstructor
@Getter
@Setter
public class Director extends Employee {

}
