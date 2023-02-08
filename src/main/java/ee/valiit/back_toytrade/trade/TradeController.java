package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.trade.dto.ToyDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trade")
public class TradeController {

    @Resource
    private TradeService tradeService;

    @GetMapping ("/trades")
    @Operation(summary = "Finds toys by category and active status", description = "Finds all toys from the db 'Toy' table based on category and status")
    public List<ToyDto> getToysByCategory(@RequestParam Integer categoryId) {
        return tradeService.getToysByCategory(categoryId);
    }

//    @PostMapping("/trade")
//    @Operation(summary = "Enam ei jaksa", description = "dd")
//    public void setToyCategories(@RequestBody categoryIdsDto) {
//        tradeService.setToyCategories(categoryIds);
//    }

}