package be.vans.lemaggistral.models.forms;

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
public class CategoryAddForm {
    @NotBlank(message = "errors.notBlank")
    private String name;
    public Category  toBll(){
        return Category.builder()
                .name(name)
                .build();
    }
}
