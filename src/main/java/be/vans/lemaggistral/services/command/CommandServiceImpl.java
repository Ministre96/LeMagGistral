package be.vans.lemaggistral.services.command;


import be.vans.lemaggistral.models.entities.Client;
import be.vans.lemaggistral.models.entities.Command;
import be.vans.lemaggistral.models.entities.Status;
import be.vans.lemaggistral.repositories.CommandRepository;
import be.vans.lemaggistral.services.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandServiceImpl extends CrudServiceImpl<CommandRepository, Command, Integer> implements CommandService {

    @Autowired
    public CommandServiceImpl(CommandRepository commandRepository){
        super(commandRepository);
    }

    @Override
    public Command activeCommand(Client client) {
        if(!repository.lastCommand(client.getId()).equals(null) && repository.lastCommand(client.getId()).getStatus().equals("inProgress"))
            return repository.lastCommand(client.getId());
        else{
            Command c = Command.builder()
                    .client(client)
                    .status(Status.inProgress)
                    .build();
            return c;
        }
    }
}
