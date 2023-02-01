package be.vans.lemaggistral.repositories;

import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommandRepository extends JpaRepository<Command, Integer>, JpaSpecificationExecutor {
}
