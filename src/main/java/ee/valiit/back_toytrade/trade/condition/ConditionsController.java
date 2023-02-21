package ee.valiit.back_toytrade.trade.condition;

import ee.valiit.back_toytrade.trade.dto.ConditionDto;
import ee.valiit.back_toytrade.trade.dto.NewConditionRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/conditions")
@RestController
public class ConditionsController {

    @Resource
    private ConditionsService conditionsService;

    @PostMapping
    @Operation(summary = "Adds a new category", description = "Adds a new category to db table 'category'")
    public void addCategory(@RequestBody NewConditionRequest newConditionRequest) {
        conditionsService.addCondition(newConditionRequest);
    }

    @GetMapping
    @Operation(summary = "Gets all conditions", description = "Finds all conditions from db table 'condition'")
    public List<ConditionDto> getAllConditions(){
                return conditionsService.getAllConditions();
    }

    @PutMapping
    @Operation(summary = "Updates condition name", description = "Condition name is updated in database table 'condition'")
    public void updateCondition(@RequestParam Integer conditionId, @RequestBody NewConditionRequest newConditionRequest) {
        conditionsService.editCondition(conditionId, newConditionRequest);
    }

    @DeleteMapping
    @Operation(summary = "Deletes condition", description = "Condition status is changed in database")
    public void deleteCondition(@RequestParam Integer conditionId) {
        conditionsService.deleteCondition(conditionId);
    }
}
