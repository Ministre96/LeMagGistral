package be.vans.lemaggistral.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Category extends BaseEntity<Integer>{
    @Column(nullable = false)
    private String name;
}
