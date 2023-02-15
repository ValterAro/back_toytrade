package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.trade.dto.ToyDto;
import ee.valiit.back_toytrade.trade.dto.ToyEditRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class ToyContoller {

    @Resource
    private TradeService tradeService;

    @PostMapping("/toy")
    @Operation(summary = "adds toys and its properties", description = "adds picture, name, category, condition to db")
    public void addNewToy(@RequestBody ToyDto toyDto) {

        tradeService.addNewToy(toyDto);
    }

    @GetMapping("/toy")
    @Operation(summary = "gets toys by ID", description = "gets toy name, description, location, condition, trading user, picture, category")
    public ToyDto toyDto(@RequestParam Integer toyId){
        return tradeService.findToy(toyId);
    }

    @PutMapping("/toy")
    @Operation(summary = "updates toy by ID", description = "updates toy name, description, location, condition, picture, category")
    public void updateToy(@RequestParam Integer toyId, @RequestBody ToyEditRequest toyEditRequest){

        tradeService.editToy(toyId, toyEditRequest);
    }


}
