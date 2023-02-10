package ee.valiit.back_toytrade.domain.toy.toy_transaction;

import jakarta.annotation.Resource;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
public class ToyTransactionService {

    @Resource
    private ToyTransactionRepository toyTransactionRepository;

    public void saveToyTransaction(ToyTransaction toyTransaction) {
        toyTransactionRepository.save(toyTransaction);

    }

}
