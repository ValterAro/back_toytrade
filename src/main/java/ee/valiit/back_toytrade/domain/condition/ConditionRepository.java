package ee.valiit.back_toytrade.domain.condition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConditionRepository extends JpaRepository<Condition, Integer> {
    @Query("select (count(c) > 0) from Condition c where c.name = ?1")
    boolean conditionExists(String name);

    @Query("select c from Condition c where c.status = ?1 order by c.id")
    List<Condition> findActiveConditions(String status);
}