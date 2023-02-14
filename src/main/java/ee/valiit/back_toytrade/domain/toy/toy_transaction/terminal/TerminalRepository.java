package ee.valiit.back_toytrade.domain.toy.toy_transaction.terminal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TerminalRepository extends JpaRepository<Terminal, Integer> {


    @Override
    Optional<Terminal> findById(Integer integer);
}