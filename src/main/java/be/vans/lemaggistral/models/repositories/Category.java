package be.vans.lemaggistral.models.repositories;

import be.vans.lemaggistral.models.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Category extends JpaRepository<be.vans.lemaggistral.models.entities.Category, Integer>, JpaSpecificationExecutor {
}
