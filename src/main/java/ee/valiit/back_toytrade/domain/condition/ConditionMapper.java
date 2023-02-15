package ee.valiit.back_toytrade.domain.condition;
import ee.valiit.back_toytrade.domain.category.Category;
import ee.valiit.back_toytrade.trade.dto.ConditionDto;
import ee.valiit.back_toytrade.trade.dto.NewCategoryRequest;
import ee.valiit.back_toytrade.trade.dto.NewConditionRequest;
import org.mapstruct.*;

import java.util.List;

import static ee.valiit.back_toytrade.trade.Status.ACTIVE;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ConditionMapper {

    @Mapping(source = "conditionName", target = "name")
    @Mapping(constant = ACTIVE, target = "status")
    Condition toEntity(NewConditionRequest newConditionRequest);

    @Mapping(source = "name", target = "conditionName")
    @Mapping(source = "id", target = "conditionId")
    ConditionDto toDto(Condition condition);
    List<ConditionDto> toDtos(List<Condition> conditions);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Condition updateCondition(NewConditionRequest newConditionRequest, @MappingTarget Condition condition);

}