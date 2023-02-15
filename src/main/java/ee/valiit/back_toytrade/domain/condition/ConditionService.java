package ee.valiit.back_toytrade.domain.condition;

import ee.valiit.back_toytrade.trade.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static ee.valiit.back_toytrade.trade.Status.ACTIVE;

@Service
public class ConditionService {

    @Resource
    private ConditionRepository conditionRepository;


    public Optional<Condition> findConditionById(Integer conditionId) {
       return  conditionRepository.findById(conditionId);
    }

    public List<Condition> getAllConditions() {
        List<Condition> allConditions = conditionRepository.findActiveConditions(ACTIVE);
        return allConditions;
    }

    public boolean conditionExists(String conditionName) {
        return conditionRepository.conditionExists(conditionName);
    }

    public void addCondition(Condition condition) {
        conditionRepository.save(condition);
    }

    public Condition findCondition(Integer conditionId) {
        return conditionRepository.findById(conditionId).get();
    }

    public void saveCondition(Condition condition) {
        conditionRepository.save(condition);
    }
}
