package ee.valiit.back_toytrade.domain.city;

import ee.valiit.back_toytrade.domain.condition.Condition;
import ee.valiit.back_toytrade.trade.Status;
import ee.valiit.back_toytrade.trade.dto.CityDto;
import ee.valiit.back_toytrade.trade.dto.NewCityRequest;
import ee.valiit.back_toytrade.trade.dto.NewConditionRequest;
import org.mapstruct.*;

import java.util.List;

import static ee.valiit.back_toytrade.trade.Status.ACTIVE;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityMapper {
    @Mapping(source = "cityName", target = "name")
    @Mapping(constant = ACTIVE, target = "status")
    City toEntity(NewCityRequest newCityRequest);

    @Mapping(source = "name", target = "cityName")
    @Mapping(source = "id", target = "cityId")
    CityDto toDto(City city);

    List<CityDto> toDtos(List<City> cities);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City updateCity(NewCityRequest newCityRequest, @MappingTarget City city);
}