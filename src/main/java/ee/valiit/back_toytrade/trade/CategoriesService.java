package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.category.Category;
import ee.valiit.back_toytrade.domain.category.CategoryMapper;
import ee.valiit.back_toytrade.domain.category.CategoryService;
import ee.valiit.back_toytrade.trade.dto.CategoryDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    @Resource
    private CategoryService categoryService;

    @Resource
    private CategoryMapper categoryMapper;

    public List<CategoryDto> getAllCategories() {
        List<Category> allCategories = categoryService.getAllCategories();
        return categoryMapper.toDtos(allCategories);

    }
}
