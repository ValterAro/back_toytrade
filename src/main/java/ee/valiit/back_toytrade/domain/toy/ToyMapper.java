package ee.valiit.back_toytrade.domain.toy;

import ee.valiit.back_toytrade.trade.dto.ToyDto;
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


    @Mapping(source = "name", target = "name")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "picture", target = "picture")
    @Mapping(source = "cityId", target = "city.id")
    @Mapping(source = "cityName", target = "city.name")
    @Mapping(source = "conditionId", target = "condition.id")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "status", target = "status")
    Toy toEntity(ToyDto toyDto);
}