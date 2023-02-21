package ee.valiit.back_toytrade.trade.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ToyEditRequest {

    private Integer cityId;
    private Integer conditionId;
    private Integer categoryId;
    @Size(max = 255)
    @NotNull
    private String name;
    @Size(max = 255)
    @NotNull
    private String description;
    @Size(max = 1)
    @NotNull
    private String status;

    private String picture;

}
