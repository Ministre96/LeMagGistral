package be.vans.lemaggistral.services.category;


import be.vans.lemaggistral.models.entities.Category;
import be.vans.lemaggistral.services.CrudService;

import java.util.Map;

public interface CategoryService extends CrudService<Category, Integer> {

    Map<Category, Integer> readCategoryBestSell();
}
