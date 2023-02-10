package be.vans.lemaggistral.services.article;

import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.repositories.ArticleRepository;
import be.vans.lemaggistral.services.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Stream;

@Service
public class ArticleServiceImpl extends CrudServiceImpl<ArticleRepository, Article, Integer> implements ArticleService{

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository)
    {
        super(articleRepository);
    }


    @Override
    public Map<Article, Integer> readArticleBestSellByCat() {
        return this.readArticleBestSellByCat();
    }
}
