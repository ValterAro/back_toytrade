package ee.valiit.back_toytrade.domain.condition;

import ee.valiit.back_toytrade.trade.dto.ConditionDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ConditionMapper {

    Condition toEntity(ConditionDto conditionDto);

    @Mapping(source = "name", target = "conditionName")
    @Mapping(source = "id", target = "conditionId")
    ConditionDto toDto(Condition condition);
    List<ConditionDto> toDtos(List<Condition> conditions);


}