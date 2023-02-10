package be.vans.lemaggistral.controllers;


import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.models.dtos.ArticleDTO;
import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.services.article.ArticleService;
import org.hibernate.mapping.Map;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/art")
public class ArticleController implements BaseRestController<ArticleDTO, Integer>{

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping(path={"/{id:[0-9]+}"})
    public ResponseEntity<ArticleDTO> getOneAction(
            @PathVariable(name ="id") Integer id
    ){
        Article article = this.articleService.readOneByKey(id)
                .orElseThrow(()-> new HttpNotFoundException("Article with id"+id+" is not found"));
        return ResponseEntity.ok(ArticleDTO.toDTO(article));
    }

    @GetMapping("")
    public ResponseEntity<Collection<ArticleDTO>> getAllAction(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_size", defaultValue = "5") int size
    ){
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(this.articleService.readAll(pageable).map(ArticleDTO::toDTO).toList());
    }

    @GetMapping(path={"/bs"})
    public ResponseEntity<Collection<ArticleDTO>> getAllBestSell(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_size", defaultValue = "5") int size
    ){
        return ResponseEntity.ok(this.articleService.readArticleBestSellByCat(PageRequest.of(page, size)).keySet().stream().map(ArticleDTO::toDTO).toList());
    }

    @GetMapping(path={"/bp"})
    public ResponseEntity<Collection<ArticleDTO>> getAllBestPromos(
            @RequestParam(name = "_page", defaultValue = "1") int page,
            @RequestParam(name = "_size", defaultValue = "5") int size
    ){
        return ResponseEntity.ok(this.articleService.readArticleBestPromo(PageRequest.of(page, size)).keySet().stream().map(ArticleDTO::toDTO).toList());
    }


}
