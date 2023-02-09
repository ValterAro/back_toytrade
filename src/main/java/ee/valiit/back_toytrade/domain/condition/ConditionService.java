package ee.valiit.back_toytrade.domain.condition;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConditionService {

    @Resource
    private ConditionRepository conditionRepository;


    public Optional<Condition> findConditionById(Integer conditionId) {
       return  conditionRepository.findById(conditionId);
    }

    public List<Condition> getAllConditions() {
        List<Condition> allConditions = conditionRepository.findAll();
        return allConditions;
    }
}
