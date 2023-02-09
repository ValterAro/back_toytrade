package ee.valiit.back_toytrade.trade.dto;

import ee.valiit.back_toytrade.domain.city.City;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link City} entity
 */
@Data
public class CityDto implements Serializable {
    private Integer cityId;
    @Size(max = 255)
    @NotNull
    private String cityName;
}