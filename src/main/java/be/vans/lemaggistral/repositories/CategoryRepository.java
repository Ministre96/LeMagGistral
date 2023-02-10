package be.vans.lemaggistral.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoryRepository extends JpaRepository<be.vans.lemaggistral.models.entities.Category, Integer>, JpaSpecificationExecutor {



}
