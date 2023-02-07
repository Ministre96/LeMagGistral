package be.vans.lemaggistral.models.dtos;


import be.vans.lemaggistral.models.entities.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {
    private String name;
    public static CategoryDTO toDTO(Category category){
        CategoryDTOBuilder dto = CategoryDTO.builder();
        return dto
                .name(category.getName())
                .build();
    }
}
