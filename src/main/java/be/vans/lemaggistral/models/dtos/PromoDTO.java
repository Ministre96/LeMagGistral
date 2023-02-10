package be.vans.lemaggistral.models.dtos;

import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Category;
import be.vans.lemaggistral.models.entities.Promo;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PromoDTO {

    private float percentage;
    private Date startDate;
    private Date endDate;
    private Article article;

    public static PromoDTO toDTO(Promo promo){
        PromoDTO.PromoDTOBuilder dto = PromoDTO.builder();
        return dto
                .percentage(promo.getPercentage())
                .startDate(promo.getStartDate())
                .endDate(promo.getEndDate())
                .article(promo.getArticle())
                .build();
    }

}
