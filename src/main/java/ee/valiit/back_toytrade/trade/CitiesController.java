package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.trade.dto.CityDto;
import ee.valiit.back_toytrade.trade.dto.NewCityRequest;
import ee.valiit.back_toytrade.trade.dto.NewConditionRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CitiesController {

    @Resource
    private TradeService tradeService;

    @Resource
    private CitiesService citiesService;

    @GetMapping("/cities")
    @Operation(summary = "gets all cities", description = "does what it says")
    public List<CityDto> getAllCities(){

        return tradeService.getAllCities();

    }

    @PostMapping("/cities")
    @Operation(summary = "Adds a new city", description = "Adds a new city to db table 'city'")
    public void addCity(@RequestBody NewCityRequest newCityRequest) {
        citiesService.addCity(newCityRequest);
    }

    @DeleteMapping("/cities")
    @Operation(summary = "Deletes city", description = "City status is changed in database")
    public void deleteCity(@RequestParam Integer cityId) {
        citiesService.deleteCity(cityId);
    }

    @PutMapping("/cities")
    @Operation(summary = "Updates city name", description = "City name is updated in database table 'city'")
    public void updateCity(@RequestParam Integer cityId, @RequestBody NewCityRequest newCityRequest) {
        citiesService.editCity(cityId, newCityRequest);
    }

}
