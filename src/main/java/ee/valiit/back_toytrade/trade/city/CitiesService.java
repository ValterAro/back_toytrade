package ee.valiit.back_toytrade.trade.city;

import ee.valiit.back_toytrade.domain.city.City;
import ee.valiit.back_toytrade.domain.city.CityMapper;
import ee.valiit.back_toytrade.domain.city.CityService;
import ee.valiit.back_toytrade.domain.condition.Condition;
import ee.valiit.back_toytrade.trade.dto.CityDto;
import ee.valiit.back_toytrade.trade.dto.NewCityRequest;
import ee.valiit.back_toytrade.validator.Validator;
import jakarta.annotation.Resource;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static ee.valiit.back_toytrade.trade.Status.DEACTIVATED;

@Service
public class CitiesService {

    @Resource
    private CityService cityService;

    @Resource
    private CityMapper cityMapper;

    public List<CityDto> getAllCities() {
        List<City> allCities = cityService.getAllCities();
        return cityMapper.toDtos(allCities);
    }

    public void addCity(NewCityRequest newCityRequest) {
        checkIfCityExists(newCityRequest);
        City city = cityMapper.toEntity(newCityRequest);
        cityService.saveCity(city);
    }

    public void editCity(Integer cityId, NewCityRequest newCityRequest) {
        City city = cityService.findCity(cityId);
        cityMapper.updateCity(newCityRequest, city);
        cityService.saveCity(city);
    }

    public void deleteCity(Integer cityId) {
        City city = cityService.findCity(cityId);
        setNewCityName(city);
        city.setStatus(DEACTIVATED);
        cityService.saveCity(city);
    }

    private void checkIfCityExists(NewCityRequest newCityRequest) {
        boolean cityExists = cityService.cityExists(newCityRequest.getCityName());
        Validator.validateCityExists(cityExists);
    }

    private static void setNewCityName(City city) {
        String currentCityName = city.getName();
        String newCityName = currentCityName + " (deactivated: " + LocalDateTime.now() + ")";
        city.setName(newCityName);
    }
}
