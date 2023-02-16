package be.vans.lemaggistral.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@ToString
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Director extends Employee {

}
