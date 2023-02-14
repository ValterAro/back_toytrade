package ee.valiit.back_toytrade.domain.category;

import ee.valiit.back_toytrade.trade.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ee.valiit.back_toytrade.trade.Status.ACTIVE;

@Service
public class CategoryService {

    @Resource
    private CategoryRepository categoryRepository;


    public List<Category> getAllCategories() {
        return categoryRepository.findActiveCategories(ACTIVE);

    }

    public Optional<Category> findCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public boolean categoryExists(String categoryName) {
        return categoryRepository.categoryExists(categoryName);
    }

    public Category findCategory(Integer categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}
