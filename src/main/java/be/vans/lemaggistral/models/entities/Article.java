package be.vans.lemaggistral.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article extends BaseEntity<Integer> {

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String brand;

    @ManyToOne(targetEntity = Category.class)
    private Category category;
    @Column(nullable = false)
    private float price;
    private String nutriScore;

    @Column(nullable = false)
    private boolean bio;

    @Column(nullable = false)
    private boolean glutenFree;

    @Column(nullable = false)
    private boolean vegan;

    @Column(nullable = false)
    private float quantity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Unity unity;

    @ManyToMany()
    private List<Promo> promos;

}
