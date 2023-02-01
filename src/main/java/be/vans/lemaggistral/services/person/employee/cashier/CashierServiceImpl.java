package be.vans.lemaggistral.services.person.employee.cashier;

import be.vans.lemaggistral.models.entities.Cashier;
import be.vans.lemaggistral.repositories.CashierRepository;
import be.vans.lemaggistral.services.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashierServiceImpl extends CrudServiceImpl<CashierRepository, Cashier, Integer> implements CashierService {

    @Autowired
    public CashierServiceImpl(CashierRepository cashierRepository){
        super(cashierRepository);
    }
}
