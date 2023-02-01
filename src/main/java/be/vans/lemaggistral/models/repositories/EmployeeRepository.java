package be.vans.lemaggistral.models.repositories;

import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor {
}
