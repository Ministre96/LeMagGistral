package be.vans.lemaggistral.services.article;

import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Promo;
import be.vans.lemaggistral.services.CrudService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Stream;

public interface ArticleService extends CrudService<Article, Integer> {
/*
    Map<Article, Integer> readArticleBestSellByCat(Pageable pageable);

    Map<Article, Promo> readArticleBestPromo(Pageable pageable);
*/
}
