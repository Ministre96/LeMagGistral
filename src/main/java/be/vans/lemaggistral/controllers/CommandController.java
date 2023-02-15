package be.vans.lemaggistral.controllers;


import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.models.dtos.CommandDTO;
import be.vans.lemaggistral.models.entities.Article;
import be.vans.lemaggistral.models.entities.Client;
import be.vans.lemaggistral.models.entities.Command;
import be.vans.lemaggistral.models.entities.Command_Article;
import be.vans.lemaggistral.models.forms.Command_ArticleForm;
import be.vans.lemaggistral.services.command.CommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

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

    @PatchMapping(path={""})
    public ResponseEntity<CommandDTO> AddArticleToCommandAction(
            Client client,
            Command_ArticleForm commandArticle
    ){
        Command command = this.commandService.activeCommand(client);
        Optional<Command_Article> temp = command.getCommandArticles().stream()
                    .filter(a -> a.equals(commandArticle))
                    .findFirst();
        temp.ifPresentOrElse(
                a-> a.setQuantity(a.getQuantity()+commandArticle.toBll().getQuantity()),
                ()-> command.getCommandArticles().add(commandArticle.toBll())
        );
        Command saveCommand = this.commandService.save(command);
        return ResponseEntity.ok(CommandDTO.toDTO(saveCommand));
    }
}
