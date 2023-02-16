package be.vans.lemaggistral.controllers;

import be.vans.lemaggistral.exceptions.HttpNotFoundException;
import be.vans.lemaggistral.exceptions.HttpPreConditionFailedException;
import be.vans.lemaggistral.models.dtos.CashierDTO;
import be.vans.lemaggistral.models.dtos.ClientDTO;
import be.vans.lemaggistral.models.entities.Cashier;
import be.vans.lemaggistral.models.entities.Client;
import be.vans.lemaggistral.models.forms.CashierAddForm;
import be.vans.lemaggistral.models.forms.ClientAddForm;
import be.vans.lemaggistral.services.person.client.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
/*
    @PostMapping(path={""})
    public ResponseEntity<ClientDTO> addClientAction(
            @Valid @RequestBody ClientAddForm clientAddForm
    ){
        Client client = new Client();
        try{
            client = this.clientService.save(clientAddForm.toBll());
        }catch (Exception exception){
            throw new HttpPreConditionFailedException(exception.getMessage(), new ArrayList<>());
        }
        return ResponseEntity.ok(ClientDTO.toDTO(client));
    }*/
}
