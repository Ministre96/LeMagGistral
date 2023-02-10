package be.vans.lemaggistral.services.category;

import be.vans.lemaggistral.models.entities.Category;
import be.vans.lemaggistral.repositories.CategoryRepository;
import be.vans.lemaggistral.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CategoryServiceImpl extends CrudServiceImpl<CategoryRepository, Category, Integer> implements CategoryService {
    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }

    @Override
    public Map<Category, Integer> readCategoryBestSell() {
        return this.readCategoryBestSell();
    }
}
