package be.vans.lemaggistral.controllers;


import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.models.dtos.CashierDTO;
import be.vans.lemaggistral.models.entities.Cashier;
import be.vans.lemaggistral.services.person.employee.cashier.CashierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/cashier")
public class CashierController {

    private final CashierService cashierService;


    public CashierController(CashierService cashierService) {
        this.cashierService = cashierService;
    }

    @GetMapping("")
    public ResponseEntity<Collection<CashierDTO>> getAllAction(){
        return ResponseEntity.ok(this.cashierService.readAll().map(CashierDTO::toDTO).toList());
    }

    @GetMapping(path={"/id:[0-9]+}"})
    public ResponseEntity<CashierDTO> getOneAction(
            @PathVariable(name="id") int id
    ){
        Cashier cashier = this.cashierService.readOneByKey(id)
                .orElseThrow(()-> new HttpNotFoundException("Cashier with id  "+id+" is not found"));
        return ResponseEntity.ok(CashierDTO.toDTO(cashier));
    }

}
