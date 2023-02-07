package be.vans.lemaggistral.controllers;

import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.models.dtos.ArticleDTO;
import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.services.promo.PromoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promo")
public class PromoController {

    private final PromoService promoService;

    public PromoController(PromoService promoService) {
        this.promoService = promoService;
    }
}
