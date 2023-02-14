package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.trade.dto.ConditionDto;
import ee.valiit.back_toytrade.trade.dto.NewCategoryRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConditionsController {

    @Resource
    private TradeService tradeService;
    @Resource
    private C

    @GetMapping("/conditions")
    @Operation(summary = "gets all conditions", description = "does what it says")
    public List<ConditionDto> getAllConditions(){
                return tradeService.getAllConditions();
    }

//    @PostMapping("/conditions")
//    @Operation(summary = "Adds a new category", description = "Adds a new category to db table 'category'")
//    public void addCategory(@RequestBody NewConditionRequest newConditionRequest) {
//        ConditionsService.addCondition(newConditionRequest);
//    }
}
