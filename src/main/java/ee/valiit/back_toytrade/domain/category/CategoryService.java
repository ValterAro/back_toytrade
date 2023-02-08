package ee.valiit.back_toytrade.domain.category;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Resource
    private CategoryRepository categoryRepository;


    public List<Category> getAllCategories() {
        return categoryRepository.findAll();

    }

    public Optional<Category> findCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }
}
