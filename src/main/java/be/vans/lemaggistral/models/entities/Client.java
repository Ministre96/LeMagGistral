package be.vans.lemaggistral.models.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Client extends Person{
    @OneToMany()
    private List<Command> commands;
}
