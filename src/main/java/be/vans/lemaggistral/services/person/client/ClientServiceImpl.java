package be.vans.lemaggistral.services.person.client;

import be.vans.lemaggistral.models.entities.Client;
import be.vans.lemaggistral.repositories.ClientRepository;
import be.vans.lemaggistral.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends CrudServiceImpl<ClientRepository, Client, Integer> implements ClientService {
    public ClientServiceImpl(ClientRepository repository) {
        super(repository);
    }
}
