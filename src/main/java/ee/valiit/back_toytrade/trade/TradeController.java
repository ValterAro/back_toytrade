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

    @GetMapping ("/all")
    @Operation(summary = "Finds toys by category and active status", description = "Finds all toys from the db 'Toy' table based on category and status")
    public List<ToyDto> getAllToys() {
        return tradeService.getAllToys();
    }
    @PostMapping("/trades")
    @Operation(summary = "Finds toys by category and active status", description = "Finds all toys from the db 'Toy' table based on category and status")
    public List<ToyDto> getToysByCategories(@RequestBody List<CategoryDto> categoryDtos) {
        return tradeService.getToysByCategories(categoryDtos);
    }

//    @PostMapping("/trade")
//    @Operation(summary = "Enam ei jaksa", description = "dd")
//    public void setToyCategories(@RequestBody categoryIdsDto) {
//        tradeService.setToyCategories(categoryIds);
//    }

}