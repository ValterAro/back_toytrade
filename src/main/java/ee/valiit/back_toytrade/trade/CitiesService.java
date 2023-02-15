package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.city.City;
import ee.valiit.back_toytrade.domain.city.CityMapper;
import ee.valiit.back_toytrade.domain.city.CityService;
import ee.valiit.back_toytrade.domain.condition.Condition;
import ee.valiit.back_toytrade.trade.dto.NewCityRequest;
import ee.valiit.back_toytrade.validator.Validator;
import jakarta.annotation.Resource;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static ee.valiit.back_toytrade.trade.Status.DEACTIVATED;

@Service
public class CitiesService {

    @Resource
    private CityService cityService;

    @Resource
    private CityMapper cityMapper;

    public void addCity(NewCityRequest newCityRequest) {
        boolean cityExists = cityService.cityExists(newCityRequest.getCityName());
        Validator.validateCityExists(cityExists);
        City city = cityMapper.toEntity(newCityRequest);
        cityService.addCity(city);
    }

    public void deleteCity(Integer cityId) {
        City city = cityService.findCity(cityId);
        String currentCityName = city.getName();
        String newCityName = currentCityName + " (deactivated: " + LocalDateTime.now() + ")";
        city.setName(newCityName);
        city.setStatus(DEACTIVATED);
        cityService.saveCity(city);
    }

    public void editCity(Integer cityId, NewCityRequest newCityRequest) {
        City city = cityService.findCity(cityId);
        cityMapper.updateCity(newCityRequest, city);
        cityService.saveCity(city);
    }
}
