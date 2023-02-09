package ee.valiit.back_toytrade.domain.city;

import ee.valiit.back_toytrade.trade.dto.CityDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CityMapper {
    City toEntity(CityDto cityDto);

    @Mapping(source = "name", target = "cityName")
    @Mapping(source = "id", target = "cityId")
    CityDto toDto(City city);

    List<CityDto> toDtos(List<City> cities);
}