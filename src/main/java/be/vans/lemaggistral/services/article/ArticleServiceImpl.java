package be.vans.lemaggistral.services.article;

import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Promo;
import be.vans.lemaggistral.repositories.ArticleRepository;
import be.vans.lemaggistral.services.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
public class ArticleServiceImpl extends CrudServiceImpl<ArticleRepository, Article, Integer> implements ArticleService{

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository)
    {
        super(articleRepository);
    }

/*
    @Override
    public Map<Article, Integer> readArticleBestSellByCat(
            Pageable pageable
    ) {
        return this.repository.readArticleBestSellByCat(pageable);
    }

    @Override
    public Map<Article, Promo> readArticleBestPromo(
            Pageable pageable
    ) {
        return this.repository.readArticleBestPromo(LocalDate.now(), pageable);
    }*/
}
