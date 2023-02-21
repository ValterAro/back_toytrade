package ee.valiit.back_toytrade.domain.toy.toy_transaction.transaction_status;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionStatusService {

    @Resource
    private TransactionStatusRepository transactionStatusRepository;

    public TransactionStatus findTransactionStatus(Integer transactionStatusId) {
        Optional<TransactionStatus> transactionStatus = transactionStatusRepository.findById(transactionStatusId);
        return transactionStatus.get();
    };

}
