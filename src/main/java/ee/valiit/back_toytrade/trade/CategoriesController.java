package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.trade.dto.CategoryDto;
import ee.valiit.back_toytrade.trade.dto.NewCategoryRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesController {

    @Resource
    private CategoriesService categoriesService;

    @GetMapping("/categories")
    @Operation(summary = "Toob ära kõik toodete kategooriad", description = "Võtab db tabelist category kõik kategooriad")
    public List<CategoryDto> getAllCategories() {
        return categoriesService.getAllCategories();
    }

    @PostMapping("/categories")
    @Operation(summary = "Adds a new category", description = "Adds a new category to db table 'category'")
    public void addCategory(@RequestBody NewCategoryRequest newCategoryRequest) {
        categoriesService.addCategory(newCategoryRequest);
    }

    @DeleteMapping("/categories")
    @Operation(summary = "Deletes category", description = "Category status is changed in database")
    public void deleteCategory(@RequestParam Integer categoryId) {
        categoriesService.deleteCategory(categoryId);
    }

    @PutMapping("/categories")
    @Operation(summary = "Updates category name", description = "Category name is updated in database table 'category'")
    public void updateCategory(@RequestParam Integer categoryId, @RequestBody NewCategoryRequest newCategoryRequest) {
        categoriesService.editCategory(categoryId, newCategoryRequest);
    }


}
