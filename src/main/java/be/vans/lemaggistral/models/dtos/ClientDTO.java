package be.vans.lemaggistral.models.dtos;

import be.vans.lemaggistral.models.entities.Client;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {
    private String firstname;
    private  String lastname;
    private String password;
    private String mail;
    private String phoneNumber;

    public static ClientDTO toDTO(Client client){
        ClientDTOBuilder dto = ClientDTO.builder();
        return dto
                .firstname(client.getFirstname())
                .lastname(client.getLastname())
                .password(client.getPassword())
                .mail(client.getMail())
                .phoneNumber(client.getPhoneNumber())
                .build();
    }
}
