package be.vans.lemaggistral.models.dtos;

import be.vans.lemaggistral.models.entities.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ArticleDTO {

    private String name;
    private Brand brand;
    private Category category;
    private float price;
    private NutriScore nutriScore;
    private boolean bio;
    private boolean glutenFree;
    private boolean vegan;
    private float quanity;
    private Unity unity;
    private List<Promo> promos;
    public static ArticleDTO toDTO(Article article){
        ArticleDTO.ArticleDTOBuilder dto = ArticleDTO.builder();
        return dto
                .name(article.getName())
                .brand(article.getBrand())
                .category(article.getCategory())
                .price(article.getPrice())
                .nutriScore(article.getNutriScore())
                .bio(article.isBio())
                .glutenFree(article.isGlutenFree())
                .vegan(article.isVegan())
                .quanity(article.getQuantity())
                .unity(article.getUnity())
                .promos(article.getPromos())
                .build();
    }
}
