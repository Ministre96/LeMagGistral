package be.vans.lemaggistral.controllers;

import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.models.dtos.DirectorDTO;
import be.vans.lemaggistral.models.entities.Director;
import be.vans.lemaggistral.services.person.employee.director.DirectorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
