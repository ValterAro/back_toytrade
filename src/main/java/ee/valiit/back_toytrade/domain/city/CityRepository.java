package ee.valiit.back_toytrade.domain.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("select (count(c) > 0) from City c where c.name = ?1")
    boolean cityExists(String name);

    @Query("select c from City c where c.status = ?1 order by c.name")
    List<City> findActiveCities(String status);



}