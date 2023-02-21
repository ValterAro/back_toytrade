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

    @NotNull
    private  Integer transactionId;
    @Size(max = 255)
    @NotNull
    private String toyName;

    @Size(max = 255)
    @NotNull
    private String sellerUsername;

    @Size(max = 255)
    @NotNull
    private String buyerUsername;

    @Size(max = 15)
    @NotNull
    private String buyerMobile;

    @Size(max = 255)
    @NotNull
    private String parcelPoint;

    @NotNull
    private String timeChanged;

    @Size(max = 255)
    @NotNull
    private String transactionStatusName;
}