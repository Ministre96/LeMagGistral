package be.vans.lemaggistral.services.brand;

import be.vans.lemaggistral.models.entities.Brand;
import be.vans.lemaggistral.repositories.BrandRepository;
import be.vans.lemaggistral.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl extends CrudServiceImpl<BrandRepository, Brand, Integer> implements BrandService {
    protected BrandServiceImpl(BrandRepository repository) {
        super(repository);
    }
}
