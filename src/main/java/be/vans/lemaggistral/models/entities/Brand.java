package be.vans.lemaggistral.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Brand extends BaseEntity<Integer>{

    @Column(nullable = false)
    private String name;

}
