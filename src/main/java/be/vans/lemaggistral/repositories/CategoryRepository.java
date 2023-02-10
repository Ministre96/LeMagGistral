package be.vans.lemaggistral.repositories;

import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface CategoryRepository extends JpaRepository<be.vans.lemaggistral.models.entities.Category, Integer>, JpaSpecificationExecutor {

    @Query(value="SELECT cat, SUM(ca.quantity) as qtt FROM Command_Article ca JOIN ca.article a JOIN FETCH a.category cat group by cat ORDER BY qtt DESC")
    Map<Category, Integer> readCategoryBestSell();

}
