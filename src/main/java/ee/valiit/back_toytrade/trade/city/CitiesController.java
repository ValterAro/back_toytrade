package ee.valiit.back_toytrade.trade.city;

import ee.valiit.back_toytrade.trade.dto.CityDto;
import ee.valiit.back_toytrade.trade.dto.NewCityRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/cities")
@RestController
public class CitiesController {

    @Resource
    private CitiesService citiesService;

    @PostMapping
    @Operation(summary = "Adds a new city", description = "Adds a new city to db table 'city'")
    public void addCity(@RequestBody NewCityRequest newCityRequest) {
        citiesService.addCity(newCityRequest);
    }

    @GetMapping
    @Operation(summary = "Gets all cities", description = "Finds all cities from db table 'city'")
    public List<CityDto> getAllCities(){
        return citiesService.getAllCities();
    }

    @PutMapping
    @Operation(summary = "Updates city name", description = "City name is updated in database table 'city'")
    public void updateCity(@RequestParam Integer cityId, @RequestBody NewCityRequest newCityRequest) {
        citiesService.editCity(cityId, newCityRequest);
    }

    @DeleteMapping
    @Operation(summary = "Deletes city", description = "City status is changed in database")
    public void deleteCity(@RequestParam Integer cityId) {
        citiesService.deleteCity(cityId);
    }
}
