package ee.valiit.back_toytrade.domain.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("select (count(c) > 0) from Category c where c.name = ?1")
    boolean categoryExists(String categoryName);

    @Query("select c from Category c where c.status = ?1 order by c.name")
    List<Category> findActiveCategories(String status);

}