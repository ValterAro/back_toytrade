package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.trade.dto.ConditionDto;
import ee.valiit.back_toytrade.trade.dto.NewCategoryRequest;
import ee.valiit.back_toytrade.trade.dto.NewConditionRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConditionsController {

    @Resource
    private TradeService tradeService;
    @Resource
    private ConditionsService conditionsService;

    @GetMapping("/conditions")
    @Operation(summary = "gets all conditions", description = "does what it says")
    public List<ConditionDto> getAllConditions(){
                return tradeService.getAllConditions();
    }

    @PostMapping("/conditions")
    @Operation(summary = "Adds a new category", description = "Adds a new category to db table 'category'")
    public void addCategory(@RequestBody NewConditionRequest newConditionRequest) {
        conditionsService.addCondition(newConditionRequest);
    }

    @DeleteMapping("/conditions")
    @Operation(summary = "Deletes condition", description = "Condition status is changed in database")
    public void deleteCondition(@RequestParam Integer conditionId) {
        conditionsService.deleteCondition(conditionId);
    }

    @PutMapping("/conditions")
    @Operation(summary = "Updates condition name", description = "Condition name is updated in database table 'condition'")
    public void updateCondition(@RequestParam Integer conditionId, @RequestBody NewConditionRequest newConditionRequest) {
        conditionsService.editCondition(conditionId, newConditionRequest);
    }
}
