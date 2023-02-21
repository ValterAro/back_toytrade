package ee.valiit.back_toytrade.domain.city;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import static ee.valiit.back_toytrade.trade.Status.ACTIVE;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findActiveCities(ACTIVE);
    }

    public City findCity(Integer cityId) {
        return cityRepository.findById(cityId).get();
    }

    public boolean cityExists(String cityName) {
        return cityRepository.cityExists(cityName);
    }

    public void saveCity(City city) {
        cityRepository.save(city);
    }
}
