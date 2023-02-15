package be.vans.lemaggistral.models.forms;

import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Command_Article;
import be.vans.lemaggistral.models.entities.Director;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Command_ArticleForm {
    @NotBlank(message = "errors.notBlank")

    private Article article;

    @NotBlank(message = "errors.notBlank")
    @Min(1)
    private int quantity;

    public Command_Article toBll(){
        return Command_Article.builder()
                .article(article)
                .quantity(quantity)
                .build();
    }
}
