package ee.valiit.back_toytrade.trade;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}