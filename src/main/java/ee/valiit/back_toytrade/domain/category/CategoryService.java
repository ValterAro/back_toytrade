package ee.valiit.back_toytrade.domain.category;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import static ee.valiit.back_toytrade.trade.Status.ACTIVE;

@Service
public class CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findActiveCategories(ACTIVE);
    }

    public Category findCategory(Integer categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    public boolean categoryExists(String categoryName) {
        return categoryRepository.categoryExists(categoryName);
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}