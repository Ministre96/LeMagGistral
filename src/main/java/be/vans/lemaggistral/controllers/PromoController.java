package be.vans.lemaggistral.controllers;

import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.exceptions.HttpPreConditionFailedException;
import be.vans.lemaggistral.models.dtos.PromoDTO;
import be.vans.lemaggistral.models.entities.Promo;
import be.vans.lemaggistral.models.forms.PromoAddForm;
import be.vans.lemaggistral.services.promo.PromoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/promo")
public class PromoController {

    private final PromoService promoService;

    public PromoController(PromoService promoService) {
        this.promoService = promoService;
    }


    @GetMapping
    public ResponseEntity<Collection<PromoDTO>> getAllAction(){
        return ResponseEntity.ok(this.promoService.readAll().map(PromoDTO::toDTO).toList());
    }

    @GetMapping(path={"/{id:[0-9]+}"})
    public ResponseEntity<PromoDTO> getOneAction(
            @PathVariable(name ="id") int id
    ){
        Promo promo = this.promoService.readOneByKey(id)
                .orElseThrow(()-> new HttpNotFoundException("Promo with id"+id+" is not found"));
        return ResponseEntity.ok(PromoDTO.toDTO(promo));
    }

    @PostMapping(path={""})
    public ResponseEntity<PromoDTO> addPromoAction(
            @Valid @RequestBody PromoAddForm promoAddForm
    ){
        Promo promo = new Promo();
        try{
            promo = this.promoService.save(promoAddForm.toBll());
        }catch (Exception exception){
            throw new HttpPreConditionFailedException(exception.getMessage(), new ArrayList<>());
        }
        return ResponseEntity.ok(PromoDTO.toDTO(promo));
    }

    //faire le post + commit changement relation Promo->Article
}
