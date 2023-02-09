package be.vans.lemaggistral.models.dtos;

import be.vans.lemaggistral.models.entities.OrderPicker;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderPickerDTO {
    private String firstname;
    private  String lastname;
    private String password;
    private String mail;
    private String phoneNumber;

    public static OrderPickerDTO toDTO(OrderPicker orderPicker){
        OrderPickerDTOBuilder dto = OrderPickerDTO.builder();
        return dto
                .firstname(orderPicker.getFirstname())
                .lastname(orderPicker.getLastname())
                .password(orderPicker.getPassword())
                .mail(orderPicker.getMail())
                .phoneNumber(orderPicker.getPhoneNumber())
                .build();
    }
}
