package be.vans.lemaggistral.services.command;


import be.vans.lemaggistral.models.entities.Command;
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
}
