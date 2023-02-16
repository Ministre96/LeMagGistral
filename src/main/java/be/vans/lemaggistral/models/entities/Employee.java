package be.vans.lemaggistral.models.entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
public abstract class Employee extends Person{
}
