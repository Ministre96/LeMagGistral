package be.vans.lemaggistral.services.command_article;

import be.vans.lemaggistral.models.entities.Client;
import be.vans.lemaggistral.models.entities.Command_Article;
import be.vans.lemaggistral.repositories.ClientRepository;
import be.vans.lemaggistral.repositories.Command_ArticleRepository;
import be.vans.lemaggistral.services.CrudServiceImpl;
import be.vans.lemaggistral.services.person.client.ClientService;
import org.springframework.stereotype.Service;

@Service
public class Command_ArticleServiceImpl extends CrudServiceImpl<Command_ArticleRepository, Command_Article, Integer> implements Command_ArticleService {
    public Command_ArticleServiceImpl(Command_ArticleRepository repository) {
        super(repository);
    }
}
