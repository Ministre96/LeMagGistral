package be.vans.lemaggistral.models.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Command extends BaseEntity<Integer>{

    @Column(nullable = true)
    private Date dateCommand;

    @Column(nullable = true)
    private Date dateReceipt;

    @Column(nullable = true)
    private Status status;

    @ManyToOne()
    private Client client;

    @OneToMany()
    @JoinColumn(name = "commandId")
    private List<Command_Article> commandArticles;
}
