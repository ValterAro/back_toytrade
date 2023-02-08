package ee.valiit.back_toytrade.domain.condition;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConditionService {

    @Resource
    private ConditionRepository conditionRepository;


    public Optional<Condition> findConditionById(Integer conditionId) {
       return  conditionRepository.findById(conditionId);
    }
}
