package be.vans.lemaggistral.controllers;

import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.exceptions.HttpPreConditionFailedException;
import be.vans.lemaggistral.models.dtos.ArticleDTO;
import be.vans.lemaggistral.models.dtos.OrderPickerDTO;
import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.OrderPicker;
import be.vans.lemaggistral.models.forms.ArticleAddForm;
import be.vans.lemaggistral.models.forms.OrderPickerAddForm;
import be.vans.lemaggistral.services.person.employee.orderpicker.OrderPickerService;
import jakarta.persistence.criteria.Order;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
/*
    @PostMapping(path={""})
    public ResponseEntity<OrderPickerDTO> addOrderPickerAction(
            @Valid @RequestBody OrderPickerAddForm orderPickerAddForm
    ){
        OrderPicker orderPicker = new OrderPicker();
        try{
            orderPicker = this.orderPickerService.save(orderPickerAddForm.toBll());
        }catch (Exception exception){
            throw new HttpPreConditionFailedException(exception.getMessage(), new ArrayList<>());
        }
        return ResponseEntity.ok(OrderPickerDTO.toDTO(orderPicker));
    }*/
}