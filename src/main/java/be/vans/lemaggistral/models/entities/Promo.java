package be.vans.lemaggistral.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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

    @ManyToOne()
    private Article article;

    public boolean isAvailable(){
        return this.startDate.compareTo(new Date()) <= 0;
    }

}
