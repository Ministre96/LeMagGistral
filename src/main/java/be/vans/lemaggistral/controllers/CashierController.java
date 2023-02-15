package be.vans.lemaggistral.controllers;


import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.exceptions.HttpPreConditionFailedException;
import be.vans.lemaggistral.models.dtos.ArticleDTO;
import be.vans.lemaggistral.models.dtos.CashierDTO;
import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Cashier;
import be.vans.lemaggistral.models.forms.ArticleAddForm;
import be.vans.lemaggistral.models.forms.CashierAddForm;
import be.vans.lemaggistral.services.person.employee.cashier.CashierService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping(path={""})
    public ResponseEntity<CashierDTO> addCashierAction(
            @Valid @RequestBody CashierAddForm cashierAddForm
    ){
        Cashier cashier = new Cashier();
        try{
            cashier = this.cashierService.save(cashierAddForm.toBll());
        }catch (Exception exception){
            throw new HttpPreConditionFailedException(exception.getMessage(), new ArrayList<>());
        }
        return ResponseEntity.ok(CashierDTO.toDTO(cashier));
    }

}
