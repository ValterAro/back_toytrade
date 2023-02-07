package ee.valiit.back_toytrade.trade;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ToyMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "condition.name", target = "conditionName")
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "picture", target = "picture")
    ToyDto toDto(Toy toy);
    List<ToyDto> toDtos(List<Toy> toys);



}