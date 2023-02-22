package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.toy.toy_transaction.ToyTransactionDto;
import ee.valiit.back_toytrade.domain.toy.toy_transaction.ToyTransactionRequest;
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
    @Operation(summary = "Finds all tradeable toys with active status", description = "Finds all toys from the db 'toy' table with active status")
    public List<ToyDto> getAllToys() {
        return tradeService.getAllToys();
    }

    @PostMapping("/filter")
    @Operation(summary = "Finds toys by category and active status", description = "Finds all active toys from the db 'toy' table based on category")
    public List<ToyDto> getToysByCategories(@RequestBody List<CategoryDto> categoryDtos) {
        return tradeService.getToysByCategories(categoryDtos);
    }
    @GetMapping("/me")
    @Operation(summary = "Finds toys sold by me and by active status", description = "Finds all active toys from the db 'toy' table based on userId")
    public List<ToyDto> getMyToys(@RequestParam Integer userId) {
        return tradeService.getMyToys(userId);
    }

    @PostMapping("/transaction")
    @Operation(summary = "Posts a transaction", description = "Gets userId and toyId and adds a transaction to the toy_transaction table in the db")
    public void addToyTransaction(@RequestBody ToyTransactionRequest toyTransactionRequest) {
        tradeService.addNewTransaction(toyTransactionRequest);
    }

    @PutMapping("/transaction-sent")
    @Operation(summary = "Updates transaction status to Sent", description = "Gets toyTransactionId and updates the status of toy transaction table in db to SENT")
    public void setToyTransactionToSent(@RequestParam Integer toyTransactionId) {
        tradeService.setTransactionStatusSent(toyTransactionId);

    }
    @PutMapping("/transaction-completed")
    @Operation(summary = "Updates transaction status to Completed", description = "Gets toyTransactionId and updates the status of toy transaction table in db to COMPLETED")
    public void setToyTransactionToCompleted(@RequestParam Integer toyTransactionId) {
        tradeService.setTransactionStatusCompleted(toyTransactionId);
    }

    @GetMapping("/my-transactions")
    @Operation(summary = "Gets users transactions", description = "Gets users transactions based on userId from the toys transaction db where user is buyer or seller")
    public List<ToyTransactionDto> getMyTransactions(@RequestParam Integer userId) {
        return tradeService.findTransactions(userId);
    }
}