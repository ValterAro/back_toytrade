package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.trade.dto.CityDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityContoller {

    @Resource
    private TradeService tradeService;

    @GetMapping("/cities")
    @Operation(summary = "gets all cities", description = "does what it says")
    public List<CityDto> getAllCities(){

        return tradeService.getAllCities();

    }
}
