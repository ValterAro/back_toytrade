package ee.valiit.back_toytrade.trade.category;

import ee.valiit.back_toytrade.domain.category.Category;
import ee.valiit.back_toytrade.domain.category.CategoryMapper;
import ee.valiit.back_toytrade.domain.category.CategoryService;
import ee.valiit.back_toytrade.trade.dto.CategoryDto;
import ee.valiit.back_toytrade.trade.dto.NewCategoryRequest;
import ee.valiit.back_toytrade.validator.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import static ee.valiit.back_toytrade.trade.Status.DEACTIVATED;

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

    public void addCategory(NewCategoryRequest newCategoryRequest) {
        checkIfCategoryExists(newCategoryRequest);
        Category category = categoryMapper.toEntity(newCategoryRequest);
        categoryService.saveCategory(category);
    }

    public void editCategory(Integer categoryId,NewCategoryRequest newCategoryRequest) {
        Category category = categoryService.findCategory(categoryId);
        categoryMapper.updateCategory(newCategoryRequest, category);
        categoryService.saveCategory(category);

    }

    public void deleteCategory(Integer categoryId) {
        Category category = categoryService.findCategory(categoryId);
        setNewCategoryName(category);
        category.setStatus(DEACTIVATED);
        categoryService.saveCategory(category);
    }

    private void checkIfCategoryExists(NewCategoryRequest newCategoryRequest) {
        boolean categoryExists = categoryService.categoryExists(newCategoryRequest.getCategoryName());
        Validator.validateCategoryExists(categoryExists);
    }

    private static void setNewCategoryName(Category category) {
        String currentCategoryName = category.getName();
        String newCategoryName = currentCategoryName + " (deactivated: " + LocalDateTime.now() + ")";
        category.setName(newCategoryName);
    }
}
