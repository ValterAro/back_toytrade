package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.category.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {

    @Resource
    private CategoryService categoryService;

    public void getAllCategories() {
        categoryService.getAllCategories();
    }
}
