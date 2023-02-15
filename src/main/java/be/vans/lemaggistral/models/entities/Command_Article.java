package be.vans.lemaggistral.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Command_Article extends BaseEntity<Integer>{

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    private Article article;

    public boolean equals(Command_Article commandArticle) {
        if(commandArticle.article == this.article)
            return true;
        return false;
    }
}
