package ee.valiit.back_toytrade.domain.city;

import ee.valiit.back_toytrade.trade.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ee.valiit.back_toytrade.trade.Status.ACTIVE;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;


    public Optional<City> findCityById(Integer cityId) {
       return cityRepository.findById(cityId);
    }

    public List<City> getAllCities() {
       return cityRepository.findActiveCities(ACTIVE);
    }

    public boolean cityExists(String cityName) {
        return cityRepository.cityExists(cityName);
    }

    public void addCity(City city) {
        cityRepository.save(city);
    }

    public City findCity(Integer cityId) {
        return cityRepository.findById(cityId).get();
    }

    public void saveCity(City city) {
        cityRepository.save(city);
    }
}
