package ee.valiit.back_toytrade.domain.toy;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import java.util.List;
import static ee.valiit.back_toytrade.trade.Status.ACTIVE;

@Service
public class ToyService {

    @Resource
    private ToyRepository toyRepository;

    public List<Toy> findAllToys() {
        return toyRepository.findActiveToys(ACTIVE);
    }

    public List<Toy> findToysByCategory(Integer categoryId) {
        return toyRepository.findToysByCategory(categoryId, ACTIVE);
    }

    public List<Toy> findUserToys(Integer userId) {
        return toyRepository.findUserToys(userId, ACTIVE);
    }

    public Toy findToy(Integer toyId) {
        return toyRepository.findById(toyId).get();
    }

    public void saveToy(Toy toy) {
        toyRepository.save(toy);
    }
}
