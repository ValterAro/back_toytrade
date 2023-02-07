package ee.valiit.back_toytrade.domain.toy;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyService {

    @Resource
    private ToyRepository toyRepository;

    public List<Toy> findActiveListedToys(Integer categoryId) {
        List<Toy> listedToys = toyRepository.findListedToys(categoryId, "A");
        return listedToys;
    }



}
