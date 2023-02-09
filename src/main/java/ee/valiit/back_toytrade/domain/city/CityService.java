package ee.valiit.back_toytrade.domain.city;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;


    public Optional<City> findCityById(Integer cityId) {
       return cityRepository.findById(cityId);
    }

    public List<City> getAllCities() {
       return cityRepository.findAll();
    }
}
