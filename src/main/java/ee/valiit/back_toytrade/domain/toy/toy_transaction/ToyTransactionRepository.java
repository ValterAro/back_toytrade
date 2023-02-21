package ee.valiit.back_toytrade.domain.toy.toy_transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToyTransactionRepository extends JpaRepository<ToyTransaction, Integer> {

    @Query("select t from ToyTransaction t where t.seller.id = ?1 or t.buyer.id = ?2 order by t.transactionStatus.id")
    List<ToyTransaction> findTransactions(Integer sellerId, Integer buyerId);


}