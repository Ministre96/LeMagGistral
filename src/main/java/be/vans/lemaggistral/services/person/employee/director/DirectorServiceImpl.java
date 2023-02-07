package be.vans.lemaggistral.services.person.employee.director;

import be.vans.lemaggistral.models.entities.Director;
import be.vans.lemaggistral.repositories.DirectorRepository;
import be.vans.lemaggistral.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl extends CrudServiceImpl<DirectorRepository, Director, Integer> implements DirectorService {

    public DirectorServiceImpl(DirectorRepository repository) {
        super(repository);
    }
}
