package ee.valiit.back_toytrade.domain.toy.toy_transaction.terminal;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TerminalService {

    @Resource
    private TerminalRepository terminalRepository;

    public Terminal findTerminal(Integer terminalId) {
        return terminalRepository.findById(terminalId).get();
    }


}
