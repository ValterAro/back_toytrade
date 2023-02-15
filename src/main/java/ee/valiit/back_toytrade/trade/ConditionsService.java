package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.category.Category;
import ee.valiit.back_toytrade.domain.condition.Condition;
import ee.valiit.back_toytrade.domain.condition.ConditionMapper;
import ee.valiit.back_toytrade.domain.condition.ConditionService;
import ee.valiit.back_toytrade.trade.dto.NewConditionRequest;
import ee.valiit.back_toytrade.validator.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static ee.valiit.back_toytrade.trade.Status.DEACTIVATED;

@Service
public class ConditionsService {

    @Resource
    private ConditionService conditionService;

    @Resource
    private ConditionMapper conditionMapper;

    public void addCondition(NewConditionRequest newConditionRequest) {
        boolean conditionExists = conditionService.conditionExists(newConditionRequest.getConditionName());
        Validator.validateConditionExists(conditionExists);
        Condition condition = conditionMapper.toEntity(newConditionRequest);
        conditionService.addCondition(condition);
    }

    public void deleteCondition(Integer conditionId) {
        Condition condition = conditionService.findCondition(conditionId);
        String currentConditionName = condition.getName();
        String newConditionName = currentConditionName + " (deactivated: " + LocalDateTime.now() + ")";
        condition.setName(newConditionName);
        condition.setStatus(DEACTIVATED);
        conditionService.saveCondition(condition);
    }

    public void editCondition(Integer conditionId, NewConditionRequest newConditionRequest) {
        Condition condition = conditionService.findCondition(conditionId);
        conditionMapper.updateCondition(newConditionRequest, condition);
        conditionService.saveCondition(condition);
    }
}
