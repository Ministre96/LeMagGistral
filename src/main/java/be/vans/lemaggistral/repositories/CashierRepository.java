package be.vans.lemaggistral.repositories;

import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Cashier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CashierRepository extends JpaRepository<Cashier, Integer>, JpaSpecificationExecutor {
}
