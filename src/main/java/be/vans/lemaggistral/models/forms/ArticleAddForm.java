package be.vans.lemaggistral.models.forms;

import be.vans.lemaggistral.models.entities.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleAddForm {
    @NotBlank(message = "errors.notBlank")
    private String name;
    @NotBlank(message = "errors.notBlank")
    private Brand brand;
    @NotBlank(message = "errors.notBlank")
    private Category category;
    @NotBlank(message = "errors.notBlank")
    private float price;
    private NutriScore nutriScore;
    @NotBlank(message = "errors.notBlank")
    private boolean bio;
    @NotBlank(message = "errors.notBlank")
    private boolean glutenFree;
    @NotBlank(message = "errors.notBlank")
    private boolean vegan;

    @NotBlank(message = "errors.notBlank")
    private float quantity;
    @NotBlank(message = "errors.notBlank")
    private Unity unity;

    public Article toBll(){
        return Article.builder()
                .name(name)
                .brand(brand)
                .category(category)
                .price(price)
                .nutriScore(nutriScore)
                .bio(bio)
                .glutenFree(glutenFree)
                .vegan(vegan)
                .quantity(quantity)
                .unity(unity)
                .build();
    }
}
