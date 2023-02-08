package ee.valiit.back_toytrade.domain.category;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Resource
    private CategoryRepository categoryRepository;


    public void getAllCategories() {

    }
}
