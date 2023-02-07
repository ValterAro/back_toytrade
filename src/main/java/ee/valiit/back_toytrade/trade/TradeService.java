package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.toy.Toy;
import ee.valiit.back_toytrade.trade.Dto.ToyDto;
import ee.valiit.back_toytrade.domain.toy.ToyMapper;
import ee.valiit.back_toytrade.domain.toy.ToyService;
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
