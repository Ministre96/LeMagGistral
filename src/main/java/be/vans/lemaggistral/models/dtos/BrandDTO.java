package be.vans.lemaggistral.models.dtos;

import be.vans.lemaggistral.models.entities.Brand;
import be.vans.lemaggistral.models.entities.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BrandDTO {

    private String name;
    public static BrandDTO toDTO(Brand brand){
        BrandDTO.BrandDTOBuilder dto = BrandDTO.builder();
        return dto
                .name(brand.getName())
                .build();
    }
}
