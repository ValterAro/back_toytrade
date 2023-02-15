package ee.valiit.back_toytrade.domain.toy;

import ee.valiit.back_toytrade.trade.Status;
import ee.valiit.back_toytrade.trade.dto.ToyDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import static ee.valiit.back_toytrade.trade.Status.ACTIVE;

@Service
public class ToyService {

    @Resource
    private ToyRepository toyRepository;

    public List<Toy> findActiveListedToys() {
        return toyRepository.findActiveToys(ACTIVE);
    }

    public List<Toy> findActiveListedToys(Integer categoryId) {
        return toyRepository.findListedToys(categoryId, ACTIVE);
    }
    public List<Toy> findToys(Integer userId){
    return toyRepository.findToys(userId);
    }

    public void addNewToy(Toy toy) {
        toyRepository.save(toy);
    }

    public Toy findToy(Integer toyId) {
        return toyRepository.findById(toyId).get();
    }

    public void saveToy(Toy toy) {
        toyRepository.save(toy);
    }
}
