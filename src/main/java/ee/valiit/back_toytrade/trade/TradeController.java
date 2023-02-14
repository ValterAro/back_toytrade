package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.toy.toy_transaction.ToyTransaction;
import ee.valiit.back_toytrade.domain.toy.toy_transaction.ToyTransactionDto;
import ee.valiit.back_toytrade.domain.toy.toy_transaction.ToyTransactionRequest;
import ee.valiit.back_toytrade.domain.user.UserService;
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

    @Resource
    private UserService userService;

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

    @GetMapping("/myPoints")
    @Operation(summary = "Finds my points", description = "Finds my point total from the db 'user' table based on userId")
    public Integer getMyPoints(@RequestParam Integer userId) {
        return tradeService.getMyPoints(userId);
    }

    @PostMapping("/transaction")
    @Operation(summary = "Posts a transaction", description = "Gets userId and toyId and adds a transaction to the toy_transaction table in the db")
    public void addToyTransaction(@RequestBody ToyTransactionRequest toyTransactionRequest) {
        tradeService.addNewTransaction(toyTransactionRequest);
    }

    @PutMapping("/transaction-sent")
    @Operation(summary = "updates transaction status to Sent", description = "Gets toyTransactionId and updates the status of toy transaction table in db to SENT")
    public void setToyTransactionToSent(@RequestParam Integer toyTransactionId) {
        tradeService.setTransactionStatusSent(toyTransactionId);

    }
    @PutMapping("/transaction-completed")
    @Operation(summary = "updates transaction status to Completed", description = "Gets toyTransactionId and updates the status of toy transaction table in db to COMPLETED")
    public void setToyTransactionToCompleted(@RequestParam Integer toyTransactionId) {
        tradeService.setTransactionStatusCompleted(toyTransactionId);
    }

    @GetMapping("/my-transactions")
    @Operation(summary = "gets users transactions", description = "Gets users transactions based on userId from the toys transaction db where user is buyer or seller")
    public List<ToyTransactionDto> getMyTransactions(@RequestParam Integer userId) {
        return tradeService.findTransactions(userId);

    }

}