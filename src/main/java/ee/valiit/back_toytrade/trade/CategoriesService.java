package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.category.Category;
import ee.valiit.back_toytrade.domain.category.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    @Resource
    private CategoryService categoryService;

    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
