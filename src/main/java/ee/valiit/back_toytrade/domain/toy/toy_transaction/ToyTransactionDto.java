package ee.valiit.back_toytrade.domain.toy.toy_transaction;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link ToyTransaction} entity
 */
@Data
public class ToyTransactionDto implements Serializable {

    @Size(max = 255)
    @NotNull
    private final String toyName;

    @Size(max = 255)
    @NotNull
    private final String sellerUsername;

    @Size(max = 255)
    @NotNull
    private final String buyerUsername;

    @Size(max = 255)
    @NotNull
    private final String terminalName;
    @Size(max = 2)
    @NotNull
    private final String status;
}