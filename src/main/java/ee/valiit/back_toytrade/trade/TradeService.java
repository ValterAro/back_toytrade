package ee.valiit.back_toytrade.trade;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {

    @Resource
    private ToyService toyService;

    @Resource
    private ToyMapper toyMapper;

    public List<ToyDto> getToysByCategory(Integer categoryId) {
        List<Toy> toys = toyService.findActiveListedToys(categoryId);
        List<ToyDto> toyDtos = toyMapper.toDtos(toys);

        return toyDtos;
    }



}
