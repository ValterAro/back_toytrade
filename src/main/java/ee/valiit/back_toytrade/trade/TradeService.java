package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.toy.Toy;
import ee.valiit.back_toytrade.domain.toy.toy_transaction.*;
import ee.valiit.back_toytrade.domain.toy.toy_transaction.transaction_status.TransactionStatus;
import ee.valiit.back_toytrade.domain.user.User;
import ee.valiit.back_toytrade.domain.user.UserService;
import ee.valiit.back_toytrade.trade.dto.*;
import ee.valiit.back_toytrade.domain.toy.ToyMapper;
import ee.valiit.back_toytrade.domain.toy.ToyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ee.valiit.back_toytrade.domain.toy.toy_transaction.transaction_status.TransactionStatusService;


import java.time.LocalDateTime;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static ee.valiit.back_toytrade.trade.Status.*;

@Service
public class TradeService {

    @Resource
    private ToyService toyService;

    @Resource
    private UserService userService;

    @Resource
    private ToyTransactionService toyTransactionService;

    @Resource
    private ToyMapper toyMapper;

    @Resource
    private ToyTransactionMapper toyTransactionMapper;

    @Resource
    private TransactionStatusService transactionStatusService;

    public List<ToyDto> getAllToys() {
        List<Toy> toys = toyService.findAllToys();
        return toyMapper.toDtos(toys);
    }

    public List<ToyDto> getToysByCategories(List<CategoryDto> categoryDtos) {
        List<Toy> toys = getToys(categoryDtos);
        return toyMapper.toDtos(toys);
    }

    public List<ToyDto> getMyToys(Integer userId) {
        List<Toy> toys = toyService.findUserToys(userId);
        return toyMapper.toDtos(toys);
    }

    public void addNewTransaction(ToyTransactionRequest toyTransactionRequest) {
        User buyer = userService.findUser(toyTransactionRequest.getBuyerId());
        createTransactionIfEnoughPoints(toyTransactionRequest, buyer);
    }

    public void setTransactionStatusSent(Integer toyTransactionId) {
        ToyTransaction toyTransaction = toyTransactionService.findById(toyTransactionId);
        toyTransaction.setTransactionStatus(transactionStatusService.findTransactionStatus(SENT));
        toyTransaction.setTimeChanged(formattedTimeNow());
        toyTransactionService.saveToyTransaction(toyTransaction);
    }

    public void setTransactionStatusCompleted(Integer toyTransactionId) {
        ToyTransaction toyTransaction = toyTransactionService.findById(toyTransactionId);
        transferTradePoints(toyTransaction);
        setTransactionStatusAndTime(toyTransaction);
        toyTransactionService.saveToyTransaction(toyTransaction);
    }

    public List<ToyTransactionDto> findTransactions(Integer userId) {
        List<ToyTransaction> toyTransactions = toyTransactionService.findUserTransactions(userId);
        return toyTransactionMapper.toDtos(toyTransactions);
    }

    private List<Toy> getToys(List<CategoryDto> categoryDtos) {
        List<Toy> toys = new ArrayList<>();
        for (CategoryDto dto : categoryDtos) {
            Integer categoryId = dto.getCategoryId();
            if (dto.getIsSelected()) {
                toys.addAll(toyService.findToysByCategory(categoryId));
            }
        }
        return toys;
    }

    private void createTransactionIfEnoughPoints(ToyTransactionRequest toyTransactionRequest, User buyer) {
        if (buyer.getPoints() > 0) {
            Toy toy = toyService.findToy(toyTransactionRequest.getToyId());
            String parcelPoint = toyTransactionRequest.getParcelPoint();
            ToyTransaction toyTransaction = new ToyTransaction();
            toyTransaction.setToy(toy);
            toyTransaction.setSeller(toy.getUser());
            toyTransaction.setBuyer(buyer);
            toyTransaction.setParcelPoint(parcelPoint);
            toyTransaction.setTransactionStatus(transactionStatusService.findTransactionStatus(WANTED));
            toyTransaction.setTimeChanged(formattedTimeNow());
            toy.setStatus(Status.PROCESS);
            toyTransactionService.saveToyTransaction(toyTransaction);
        }
    }

    private static String formattedTimeNow() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        ZoneId zid = ZoneId.of("Europe/Tallinn");
        LocalDateTime now = LocalDateTime.now(zid);
        return now.format(format);
    }

    private void transferTradePoints(ToyTransaction toyTransaction) {
        User buyer = userService.findUser(toyTransaction.getBuyer().getId());
        User seller = userService.findUser(toyTransaction.getSeller().getId());
        buyer.setPoints(buyer.getPoints() - 1);
        seller.setPoints(seller.getPoints() + 1);
    }

    private void setTransactionStatusAndTime(ToyTransaction toyTransaction) {
        toyTransaction.setTransactionStatus(transactionStatusService.findTransactionStatus(COMPLETED));
        toyTransaction.getToy().setStatus(Status.INACTIVE);
        toyTransaction.setTimeChanged(formattedTimeNow());
    }
}
