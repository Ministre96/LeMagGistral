package be.vans.lemaggistral.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Promo extends BaseEntity<Integer>{
    @Column(nullable = false)
    private float percentage;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
}
