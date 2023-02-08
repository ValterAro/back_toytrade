package ee.valiit.back_toytrade.domain.toy;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ToyService {

    @Resource
    private ToyRepository toyRepository;

    public List<Toy> findActiveListedToys(Integer categoryId) {
        if (categoryId == 0) {
            return toyRepository.findActiveToys("A");
        } else {
            return toyRepository.findListedToys(categoryId, "A");
        }
    }



}
