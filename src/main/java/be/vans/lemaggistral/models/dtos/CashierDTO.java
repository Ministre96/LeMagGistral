package be.vans.lemaggistral.models.dtos;

import be.vans.lemaggistral.models.entities.Cashier;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CashierDTO {
    private String firstname;
    private  String lastname;
    private String password;
    private String mail;
    private String phoneNumber;

    public static CashierDTO toDTO(Cashier cashier){
        CashierDTOBuilder dto = CashierDTO.builder();
        return dto
                .firstname(cashier.getFirstname())
                .lastname(cashier.getLastname())
                .password(cashier.getPassword())
                .mail(cashier.getMail())
                .phoneNumber(cashier.getPhoneNumber())
                .build();
    }
}
