package ee.valiit.back_toytrade.domain.toy.toy_transaction;

import ee.valiit.back_toytrade.trade.Status;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ToyTransactionMapper {


    @Mapping(constant = Status.COMPLETED, target = "status")
    ToyTransaction toEntity(ToyTransactionRequest toyTransactionRequest);

    ToyTransactionRequest toDto(ToyTransaction toyTransaction);


}