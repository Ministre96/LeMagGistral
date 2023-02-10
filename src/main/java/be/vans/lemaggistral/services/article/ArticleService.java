package be.vans.lemaggistral.services.article;

import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.services.CrudService;


import java.util.Map;
import java.util.stream.Stream;

public interface ArticleService extends CrudService<Article, Integer> {

    Map<Article, Integer> readArticleBestSellByCat();
}
