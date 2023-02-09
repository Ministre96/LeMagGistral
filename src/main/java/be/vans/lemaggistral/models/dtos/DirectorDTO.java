package be.vans.lemaggistral.models.dtos;

import be.vans.lemaggistral.models.entities.Director;
import be.vans.lemaggistral.models.entities.Director;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DirectorDTO {
    private String firstname;
    private  String lastname;
    private String password;
    private String mail;
    private String phoneNumber;

    public static DirectorDTO toDTO(Director director){
        DirectorDTOBuilder dto = DirectorDTO.builder();
        return dto
                .firstname(director.getFirstname())
                .lastname(director.getLastname())
                .password(director.getPassword())
                .mail(director.getMail())
                .phoneNumber(director.getPhoneNumber())
                .build();
    }
}
