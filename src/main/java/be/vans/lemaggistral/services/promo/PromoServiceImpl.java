package be.vans.lemaggistral.services.promo;

import be.vans.lemaggistral.models.entities.Promo;
import be.vans.lemaggistral.repositories.PromoRepository;
import be.vans.lemaggistral.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PromoServiceImpl extends CrudServiceImpl<PromoRepository, Promo, Integer> implements PromoService {
    public PromoServiceImpl(PromoRepository repository) {
        super(repository);
    }
}
