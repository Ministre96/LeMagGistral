package be.vans.lemaggistral.controllers;

import be.vans.lemaggistral.exceptions.HttpPreConditionFailedException;
import be.vans.lemaggistral.models.dtos.CategoryDTO;
import be.vans.lemaggistral.models.entities.Category;
import be.vans.lemaggistral.models.forms.CategoryAddForm;
import be.vans.lemaggistral.services.category.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = {"/cat"})
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Collection<CategoryDTO>> getAllAction(){
        return ResponseEntity.ok(this.categoryService.readAll().map(CategoryDTO::toDTO).toList());
    }
    @PostMapping(path={""})
    public ResponseEntity<CategoryDTO> addCategoryAction(
            @Valid @RequestBody CategoryAddForm categoryAddForm
    ){
        Category category = new Category();
        try{
            category = this.categoryService.save(categoryAddForm.toBll());
        }catch (Exception exception){
            throw new HttpPreConditionFailedException(exception.getMessage(), new ArrayList<>());
        }
        return ResponseEntity.ok(CategoryDTO.toDTO(category));
    }

    @GetMapping(path = {"/bs"})
    public ResponseEntity<Collection<CategoryDTO>> getAllBestSell(){
        return ResponseEntity.ok(this.categoryService.readCategoryBestSell().keySet().stream().map(CategoryDTO::toDTO).toList());
    }



}
