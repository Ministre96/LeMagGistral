package be.vans.lemaggistral.repositories;

import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PromoRepository extends JpaRepository<Promo, Integer>, JpaSpecificationExecutor {
}
