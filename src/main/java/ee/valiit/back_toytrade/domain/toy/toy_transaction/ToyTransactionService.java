package ee.valiit.back_toytrade.domain.toy.toy_transaction;

import ee.valiit.back_toytrade.domain.user.User;
import jakarta.annotation.Resource;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyTransactionService {

    @Resource
    private ToyTransactionRepository toyTransactionRepository;

    public void saveToyTransaction(ToyTransaction toyTransaction) {
        toyTransactionRepository.save(toyTransaction);

    }

    public ToyTransaction findById(Integer toyTransactionId) {
       return toyTransactionRepository.findById(toyTransactionId).get();
    }

    public List<ToyTransaction> findUserTransactions(Integer userId) {
        return toyTransactionRepository.findTransactions(userId, userId);
    }
}
