package ee.valiit.back_toytrade.domain.condition;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import static ee.valiit.back_toytrade.trade.Status.ACTIVE;

@Service
public class ConditionService {

    @Resource
    private ConditionRepository conditionRepository;

    public List<Condition> getAllConditions() {
        return conditionRepository.findActiveConditions(ACTIVE);
    }

    public Condition findCondition(Integer conditionId) {
        return conditionRepository.findById(conditionId).get();
    }

    public boolean conditionExists(String conditionName) {
        return conditionRepository.conditionExists(conditionName);
    }

    public void saveCondition(Condition condition) {
        conditionRepository.save(condition);
    }
}