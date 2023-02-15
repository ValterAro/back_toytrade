package ee.valiit.back_toytrade.trade.dto;

import ee.valiit.back_toytrade.domain.toy.Toy;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Toy} entity
 */
@Data
public class ToyDto implements Serializable {
    private  Integer id;
    private  Integer userId;
    @Size(max = 255)
    @NotNull
    private  String userUsername;

    private String userMobile;
    private  Integer cityId;
    @Size(max = 255)
    @NotNull
    private  String cityName;
    private  Integer conditionId;
    @Size(max = 255)
    @NotNull
    private  String conditionName;
    private  Integer categoryId;
    @Size(max = 255)
    @NotNull
    private  String categoryName;
    @Size(max = 255)
    @NotNull
    private  String name;
    @Size(max = 255)
    @NotNull
    private  String description;
    @NotNull
    private  String picture;
    @Size(max = 1)
    @NotNull
    private  String status;
}