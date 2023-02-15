package be.vans.lemaggistral.repositories;

import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Client;
import be.vans.lemaggistral.models.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommandRepository extends JpaRepository<Command, Integer>, JpaSpecificationExecutor {

    @Query(value="SELECT c FROM Command c JOIN FETCH c.client cli WHERE cli.id = :client ORDER BY c.id DESC LIMIT 1")
    Command lastCommand(@Param("client") Integer idClient);

}
