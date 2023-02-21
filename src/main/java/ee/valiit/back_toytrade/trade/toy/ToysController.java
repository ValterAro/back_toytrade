package ee.valiit.back_toytrade.trade.toy;

import ee.valiit.back_toytrade.trade.dto.ToyDto;
import ee.valiit.back_toytrade.trade.dto.ToyEditRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toy")
public class ToysController {

    @Resource
    private ToysService toysService;

    @PostMapping
    @Operation(summary = "Adds toys and its properties", description = "Adds picture, name, category, condition to db table 'toy'")
    public void addNewToy(@RequestBody ToyDto toyDto) {
        toysService.addNewToy(toyDto);
    }

    @GetMapping
    @Operation(summary = "Gets toys by ID", description = "Gets toy name, description, location, condition, trading user, picture, category from db table 'toy'")
    public ToyDto getToy(@RequestParam Integer toyId){
        return toysService.findToy(toyId);
    }

    @PutMapping
    @Operation(summary = "Updates toy by ID", description = "Updates toy name, description, location, condition, picture, category in db table 'toy'")
    public void updateToy(@RequestParam Integer toyId, @RequestBody ToyEditRequest toyEditRequest){
        toysService.editToy(toyId, toyEditRequest);
    }

    @DeleteMapping
    @Operation(summary = "Deletes toy by ID", description = "Changes toy status and name in db table 'toy'")
    public void deleteToy(@RequestParam Integer toyId) {
        toysService.deleteToy(toyId);
    }
}
