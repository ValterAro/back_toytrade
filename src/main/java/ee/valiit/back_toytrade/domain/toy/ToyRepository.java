package ee.valiit.back_toytrade.domain.toy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToyRepository extends JpaRepository<Toy, Integer> {
    @Query("select t from Toy t where t.category.id = ?1 and t.status = ?2 order by t.category.name, t.name")
    List<Toy> findListedToys(Integer categoryId, String status);

    @Query("select t from Toy t where t.status = ?1 order by t.category.name, t.name")
    List<Toy> findActiveToys(String status);



}