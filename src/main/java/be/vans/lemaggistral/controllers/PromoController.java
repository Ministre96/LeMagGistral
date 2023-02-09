package be.vans.lemaggistral.controllers;

import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.models.dtos.ArticleDTO;
import be.vans.lemaggistral.models.dtos.CommandDTO;
import be.vans.lemaggistral.models.dtos.PromoDTO;
import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Command;
import be.vans.lemaggistral.models.entities.Promo;
import be.vans.lemaggistral.services.promo.PromoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
