package be.vans.lemaggistral.services.person.employee.orderpicker;

import be.vans.lemaggistral.models.entities.OrderPicker;
import be.vans.lemaggistral.repositories.OrderPickerRepository;
import be.vans.lemaggistral.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderPcikerServiceImpl extends CrudServiceImpl<OrderPickerRepository, OrderPicker, Integer> implements OrderPickerService {
    public OrderPcikerServiceImpl(OrderPickerRepository repository) {
        super(repository);
    }
}
