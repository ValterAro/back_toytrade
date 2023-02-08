package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.trade.dto.CategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
