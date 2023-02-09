package be.vans.lemaggistral.controllers;

import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.models.dtos.ClientDTO;
import be.vans.lemaggistral.models.entities.Client;
import be.vans.lemaggistral.services.person.client.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public ResponseEntity<Collection<ClientDTO>> getAllAction() {
        return ResponseEntity.ok(this.clientService.readAll().map(ClientDTO::toDTO).toList());
    }

    @GetMapping(path = {"/id:[0-9]+}"})
    public ResponseEntity<ClientDTO> getOneAction(
            @PathVariable(name = "id") int id
    ) {
        Client client = this.clientService.readOneByKey(id)
                .orElseThrow(() -> new HttpNotFoundException("Client with id  " + id + " is not found"));
        return ResponseEntity.ok(ClientDTO.toDTO(client));
    }
}
