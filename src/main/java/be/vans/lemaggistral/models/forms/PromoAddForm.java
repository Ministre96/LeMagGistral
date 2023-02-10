package be.vans.lemaggistral.models.forms;

import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Promo;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoAddForm {

    @NotBlank()
    private float percentage;
    @NotBlank()
    private Date startDate;
    @NotBlank()
    private Date endDate;
    @NotBlank()
    private Article article;

    public Promo toBll(){
        return Promo.builder()
                .percentage(percentage)
                .startDate(startDate)
                .endDate(endDate)
                .article(article)
                .build();
    }
}
