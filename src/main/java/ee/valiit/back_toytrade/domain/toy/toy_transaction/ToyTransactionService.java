package ee.valiit.back_toytrade.domain.toy.toy_transaction;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyTransactionService {

    @Resource
    private ToyTransactionRepository toyTransactionRepository;

    public ToyTransaction findById(Integer toyTransactionId) {
       return toyTransactionRepository.findById(toyTransactionId).get();
    }

    public List<ToyTransaction> findUserTransactions(Integer userId) {
        return toyTransactionRepository.findTransactions(userId, userId);
    }

    public void saveToyTransaction(ToyTransaction toyTransaction) {
        toyTransactionRepository.save(toyTransaction);
    }
}
