package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.trade.dto.CategoryDto;
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

    @GetMapping("/all")
    @Operation(summary = "Finds toys with active status", description = "Finds all toys from the db 'Toy' table with active status")
    public List<ToyDto> getAllToys() {
        return tradeService.getAllToys();
    }

    @PostMapping("/trades")
    @Operation(summary = "Finds toys by category and active status", description = "Finds all toys from the db 'Toy' table based on category and status")
    public List<ToyDto> getToysByCategories(@RequestBody List<CategoryDto> categoryDtos) {
        return tradeService.getToysByCategories(categoryDtos);
    }
    @GetMapping("/me")
    @Operation(summary = "Finds toys sold by me and by active status", description = "Finds all toys from the db 'Toy' table based on userId and status")
    public List<ToyDto> getMyToys(@RequestParam Integer userId) {
        return tradeService.getMyToys(userId);
    }


}