package be.vans.lemaggistral.models.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
public abstract class Employee extends Person{
}
