package be.vans.lemaggistral.controllers;


import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.models.dtos.ArticleDTO;
import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.services.article.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/art")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("")
    public ResponseEntity<Collection<ArticleDTO>> getAllAction(){
        return ResponseEntity.ok(this.articleService.readAll().map(ArticleDTO::toDTO).toList());
    }

    @GetMapping(path={"/{id:[0-9]+}"})
    public ResponseEntity<ArticleDTO> getOneAction(
            @PathVariable(name ="id") int id
    ){
        Article article = this.articleService.readOneByKey(id)
                .orElseThrow(()-> new HttpNotFoundException("Article with id"+id+" is not found"));
        return ResponseEntity.ok(ArticleDTO.toDTO(article));
    }
}
