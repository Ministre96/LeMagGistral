package be.vans.lemaggistral.services.command;

import be.vans.lemaggistral.models.entities.Client;
import be.vans.lemaggistral.services.CrudService;
import be.vans.lemaggistral.models.entities.Command;
import org.springframework.data.repository.query.Param;

public interface CommandService extends CrudService<Command, Integer> {

    Command activeCommand(Client client);
}
