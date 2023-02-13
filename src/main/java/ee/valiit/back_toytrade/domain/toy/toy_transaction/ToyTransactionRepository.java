package ee.valiit.back_toytrade.domain.toy.toy_transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToyTransactionRepository extends JpaRepository<ToyTransaction, Integer> {
}