package ee.valiit.back_toytrade.trade.category;

import ee.valiit.back_toytrade.trade.dto.CategoryDto;
import ee.valiit.back_toytrade.trade.dto.NewCategoryRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/categories")
@RestController
public class CategoriesController {

    @Resource
    private CategoriesService categoriesService;

    @PostMapping
    @Operation(summary = "Adds a new category", description = "Adds a new category to db table 'category'")
    public void addCategory(@RequestBody NewCategoryRequest newCategoryRequest) {
        categoriesService.addCategory(newCategoryRequest);
    }
    @GetMapping
    @Operation(summary = "Finds all categories", description = "Gets all categories from db table 'category'")
    public List<CategoryDto> getAllCategories() {
        return categoriesService.getAllCategories();
    }

    @PutMapping
    @Operation(summary = "Updates category name", description = "Category name is updated in database table 'category'")
    public void updateCategory(@RequestParam Integer categoryId, @RequestBody NewCategoryRequest newCategoryRequest) {
        categoriesService.editCategory(categoryId, newCategoryRequest);
    }

    @DeleteMapping
    @Operation(summary = "Deletes category", description = "Category status is changed in database and timestamp added")
    public void deleteCategory(@RequestParam Integer categoryId) {
        categoriesService.deleteCategory(categoryId);
    }
}