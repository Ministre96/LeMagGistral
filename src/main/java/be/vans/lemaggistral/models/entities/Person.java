package be.vans.lemaggistral.models.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Person extends BaseEntity<Integer>{

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String mail;

    @Column(nullable = false)
    private String phoneNumber;
}
