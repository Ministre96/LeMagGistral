package be.vans.lemaggistral.controllers;

import be.vans.lemaggistral.exceptions.HttpPreConditionFailedException;
import be.vans.lemaggistral.models.dtos.BrandDTO;
import be.vans.lemaggistral.models.entities.Brand;
import be.vans.lemaggistral.models.forms.BrandAddForm;
import be.vans.lemaggistral.services.brand.BrandService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/brand")
public class BrandController {
    private final BrandService brandService;


    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public ResponseEntity<Collection<BrandDTO>> getAllAction(){
        return ResponseEntity.ok(this.brandService.readAll().map(BrandDTO::toDTO).toList());
    }
    @PostMapping(path={""})
    public ResponseEntity<BrandDTO> addBrandAction(
            @Valid @RequestBody BrandAddForm brandAddForm
    ){
        Brand brand = new Brand();
        try{
            brand = this.brandService.save(brandAddForm.toBll());
        }catch (Exception exception){
            throw new HttpPreConditionFailedException(exception.getMessage(), new ArrayList<>());
        }
        return ResponseEntity.ok(BrandDTO.toDTO(brand));
    }
}
