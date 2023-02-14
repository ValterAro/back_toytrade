package ee.valiit.back_toytrade.domain.toy.toy_transaction;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ToyTransaction} entity
 */
@Data
public class ToyTransactionRequest implements Serializable {

    private  Integer toyId;

    private  Integer buyerId;

    private  Integer terminalId;

}