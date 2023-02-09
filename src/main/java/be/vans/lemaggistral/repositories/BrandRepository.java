package be.vans.lemaggistral.repositories;

import be.vans.lemaggistral.models.entities.Brand;
import be.vans.lemaggistral.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>, JpaSpecificationExecutor {
}
