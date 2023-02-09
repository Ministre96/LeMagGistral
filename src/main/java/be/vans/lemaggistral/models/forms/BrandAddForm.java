package be.vans.lemaggistral.models.forms;

import be.vans.lemaggistral.models.entities.Brand;
import be.vans.lemaggistral.models.entities.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandAddForm {
    @NotBlank(message = "errors.notBlank")
    private String name;
    public Brand toBll(){
        return Brand.builder()
                .name(name)
                .build();
    }
}
