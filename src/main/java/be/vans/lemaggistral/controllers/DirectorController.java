package be.vans.lemaggistral.controllers;

import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.exceptions.HttpPreConditionFailedException;
import be.vans.lemaggistral.models.dtos.ClientDTO;
import be.vans.lemaggistral.models.dtos.DirectorDTO;
import be.vans.lemaggistral.models.entities.Client;
import be.vans.lemaggistral.models.entities.Director;
import be.vans.lemaggistral.models.forms.ClientAddForm;
import be.vans.lemaggistral.models.forms.DirectorAddForm;
import be.vans.lemaggistral.services.person.employee.director.DirectorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/director")
public class DirectorController {

    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("")
    public ResponseEntity<Collection<DirectorDTO>> getAllAction(){
        return ResponseEntity.ok(this.directorService.readAll().map(DirectorDTO::toDTO).toList());
    }

    @GetMapping(path={"/id:[0-9]+}"})
    public ResponseEntity<DirectorDTO> getOneAction(
            @PathVariable(name="id") int id
    ){
        Director director = this.directorService.readOneByKey(id)
                .orElseThrow(()-> new HttpNotFoundException("Director with id  "+id+" is not found"));
        return ResponseEntity.ok(DirectorDTO.toDTO(director));
    }
    @PostMapping(path={""})
    public ResponseEntity<DirectorDTO> addDirectorAction(
            @Valid @RequestBody DirectorAddForm directorAddForm
    ){
        Director director = new Director();
        try{
            director = this.directorService.save(directorAddForm.toBll());
        }catch (Exception exception){
            throw new HttpPreConditionFailedException(exception.getMessage(), new ArrayList<>());
        }
        return ResponseEntity.ok(DirectorDTO.toDTO(director));
    }
}
