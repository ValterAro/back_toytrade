package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.trade.dto.ConditionDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConditionsController {

    @Resource
    private TradeService tradeService;

    @GetMapping("/conditions")
    @Operation(summary = "gets all conditions", description = "does what it says")
    public List<ConditionDto> getAllConditions(){
                return tradeService.getAllConditions();
    }
}
