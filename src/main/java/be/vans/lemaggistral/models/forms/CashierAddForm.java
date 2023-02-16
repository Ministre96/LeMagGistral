package be.vans.lemaggistral.models.forms;

import be.vans.lemaggistral.models.entities.Brand;
import be.vans.lemaggistral.models.entities.Cashier;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CashierAddForm {
    @NotBlank(message = "errors.notBlank")
    private String firstname;

    @NotBlank(message = "errors.notBlank")
    private String lastname;

    @NotBlank(message = "errors.notBlank")
    private String password;

    @NotBlank(message = "errors.notBlank")
    private String mail;

    @NotBlank(message = "errors.notBlank")
    private String phoneNumber;
/*
    public Cashier toBll(){
        return Cashier.builder()
                .firstname(firstname)
                .lastname(lastname)
                .password(password)
                .mail(mail)
                .phoneNumber(phoneNumber)
                .build();
    }*/
}
