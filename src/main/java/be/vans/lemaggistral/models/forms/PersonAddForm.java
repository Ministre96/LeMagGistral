package be.vans.lemaggistral.models.forms;

import be.vans.lemaggistral.models.entities.Person;
import be.vans.lemaggistral.models.entities.Client;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonAddForm {
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

    public <T extends Person> T toBll(Class<T> entityClass){

        switch (entityClass.getName()){
            case "Client":
                break;
            case "Cashier":
                break;
            case "Director":
                break;
            case "OrderPicker":
                break;
        }
        return null;
    }
}
