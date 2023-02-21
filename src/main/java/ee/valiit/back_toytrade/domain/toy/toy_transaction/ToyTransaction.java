package ee.valiit.back_toytrade.domain.toy.toy_transaction;

import ee.valiit.back_toytrade.domain.toy.Toy;
import ee.valiit.back_toytrade.domain.toy.toy_transaction.transaction_status.TransactionStatus;
import ee.valiit.back_toytrade.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "toy_transaction")
public class ToyTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "toy_id", nullable = false)
    private Toy toy;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "buyer_id", nullable = false)
    private User buyer;


    @NotNull
    @Column(name = "timechanged", nullable = false)
    private String timeChanged;

    @Size(max = 255)
    @NotNull
    @Column(name = "parcel_point", nullable = false)
    private String parcelPoint;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_status_id", nullable = false)
    private TransactionStatus transactionStatus;


}