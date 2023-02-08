package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.trade.dto.ToyDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToyContoller {

    @Resource
    private TradeService tradeService;

    @PostMapping("/toy")
    @Operation(summary = "adds toys and its properties", description = "adds picture, name, category, condition to db")
    public void addNewToy(@RequestBody ToyDto toyDto) {

        tradeService.addNewToy(toyDto);
    }

}
