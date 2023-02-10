package be.vans.lemaggistral.repositories;

import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Promo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer>, JpaSpecificationExecutor {

    @Query(value="SELECT a, SUM(ca.quantity) as qtt FROM Command_Article ca JOIN ca.article a JOIN FETCH a.category cat group by a ORDER BY qtt DESC")
    Map<Article, Integer> readArticleBestSellByCat(Pageable pageable);

    @Query(value="SELECT a, p FROM Article as a JOIN FETCH a.promos p WHERE p.startDate < :date AND p.endDate > :date ORDER BY p.percentage DESC")
    Map<Article, Promo> readArticleBestPromo(@Param("date") LocalDate date, Pageable pageable);

}
