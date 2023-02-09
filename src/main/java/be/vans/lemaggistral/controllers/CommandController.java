package be.vans.lemaggistral.controllers;


import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.exceptions.HttpPreConditionFailedException;
import be.vans.lemaggistral.models.dtos.ArticleDTO;
import be.vans.lemaggistral.models.dtos.CategoryDTO;
import be.vans.lemaggistral.models.dtos.CommandDTO;
import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Category;
import be.vans.lemaggistral.models.entities.Command;
import be.vans.lemaggistral.models.forms.CategoryAddForm;
import be.vans.lemaggistral.services.command.CommandService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(path = {"/comm"})
public class CommandController {

    private final CommandService commandService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @GetMapping
    public ResponseEntity<Collection<CommandDTO>> getAllAction(){
        return ResponseEntity.ok(this.commandService.readAll().map(CommandDTO::toDTO).toList());
    }

    @GetMapping(path={"/{id:[0-9]+}"})
    public ResponseEntity<CommandDTO> getOneAction(
            @PathVariable(name ="id") int id
    ){
        Command command = this.commandService.readOneByKey(id)
                .orElseThrow(()-> new HttpNotFoundException("Command with id"+id+" is not found"));
        return ResponseEntity.ok(CommandDTO.toDTO(command));
    }
}
