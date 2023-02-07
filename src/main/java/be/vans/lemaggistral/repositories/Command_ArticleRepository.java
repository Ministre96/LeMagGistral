package be.vans.lemaggistral.repositories;

import be.vans.lemaggistral.models.entities.Command;
import be.vans.lemaggistral.models.entities.Command_Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Command_ArticleRepository extends JpaRepository<Command_Article, Integer>, JpaSpecificationExecutor {
}
