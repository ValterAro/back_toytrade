package ee.valiit.back_toytrade.domain.toy.toy_transaction;

import ee.valiit.back_toytrade.trade.Status;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ToyTransactionMapper {


//    @Mapping(constant = Status.COMPLETED, target = "toyStatus.id")
//    ToyTransaction toEntity(ToyTransactionRequest toyTransactionRequest);

    @Mapping(source = "toy.name", target = "toyName")
    @Mapping(source = "seller.username", target = "sellerUsername")
    @Mapping(source = "buyer.username", target = "buyerUsername")
    @Mapping(source = "buyer.mobile", target = "buyerMobile")
    @Mapping(source = "id", target = "transactionId")
    @Mapping(source = "transactionStatus.name", target = "transactionStatusName")
    ToyTransactionDto toDto(ToyTransaction toyTransaction);

    List<ToyTransactionDto> toDtos(List<ToyTransaction> toyTransactions);
}