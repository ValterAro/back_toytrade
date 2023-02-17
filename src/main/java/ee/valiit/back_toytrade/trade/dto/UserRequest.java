package ee.valiit.back_toytrade.trade.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {
    private Integer roleId;
    @Size(max = 255)
    @NotNull
    private String username;
    @NotNull
    private Integer points;
    @Size(max = 15)
    @NotNull
    private String mobile;
}
