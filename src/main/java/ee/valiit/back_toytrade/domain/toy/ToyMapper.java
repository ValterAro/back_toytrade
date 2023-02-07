package ee.valiit.back_toytrade.domain.toy;

import ee.valiit.back_toytrade.trade.Dto.ToyDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ToyMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "condition.id", target = "conditionId")
    @Mapping(source = "condition.name", target = "conditionName")
    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "picture", target = "picture")
    ToyDto toDto(Toy toy);
    List<ToyDto> toDtos(List<Toy> toys);



}