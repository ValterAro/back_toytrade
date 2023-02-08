package ee.valiit.back_toytrade.domain.toy;

import ee.valiit.back_toytrade.trade.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyService {

    @Resource
    private ToyRepository toyRepository;

    public List<Toy> findActiveListedToys(Integer categoryId) {
        if (categoryId == 0) {
            return toyRepository.findActiveToys(Status.ACTIVE);
        } else {
            return toyRepository.findListedToys(categoryId, Status.ACTIVE);
        }
    }


    public void addNewToy(Toy toy) {
        toyRepository.save(toy);
    }
}
