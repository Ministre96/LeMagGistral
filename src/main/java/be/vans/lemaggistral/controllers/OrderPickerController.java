package be.vans.lemaggistral.controllers;

import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.models.dtos.OrderPickerDTO;
import be.vans.lemaggistral.models.entities.OrderPicker;
import be.vans.lemaggistral.services.person.employee.orderpicker.OrderPickerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/cashier")
public class OrderPickerController {

    private final OrderPickerService orderPickerService;

    public OrderPickerController(OrderPickerService orderPickerService) {
        this.orderPickerService = orderPickerService;
    }


    @GetMapping("")
    public ResponseEntity<Collection<OrderPickerDTO>> getAllAction() {
        return ResponseEntity.ok(this.orderPickerService.readAll().map(OrderPickerDTO::toDTO).toList());
    }

    @GetMapping(path = {"/id:[0-9]+}"})
    public ResponseEntity<OrderPickerDTO> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        OrderPicker orderPicker = this.orderPickerService.readOneByKey(id)
                .orElseThrow(() -> new HttpNotFoundException("OrderPicker with id  " + id + " is not found"));
        return ResponseEntity.ok(OrderPickerDTO.toDTO(orderPicker));
    }
}