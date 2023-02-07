package ee.valiit.back_toytrade.trade;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Toy} entity
 */
@Data
public class ToyDto implements Serializable {
    private final Integer id;
    private final Integer userId;
    @Size(max = 255)
    @NotNull
    private final String userUsername;
    private final Integer cityId;
    @Size(max = 255)
    @NotNull
    private final String cityName;
    private final Integer conditionId;
    @Size(max = 255)
    @NotNull
    private final String conditionName;
    private final Integer categoryId;
    @Size(max = 255)
    @NotNull
    private final String categoryName;
    @Size(max = 255)
    @NotNull
    private final String name;
    @Size(max = 255)
    @NotNull
    private final String description;
    @NotNull
    private final byte[] picture;
    @Size(max = 1)
    @NotNull
    private final String status;
}