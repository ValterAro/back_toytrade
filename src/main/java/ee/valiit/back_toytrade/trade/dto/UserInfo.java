package ee.valiit.back_toytrade.trade.dto;

import ee.valiit.back_toytrade.domain.user.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserInfo implements Serializable {
    private Integer id;
    private Integer roleId;
    @Size(max = 50)
    @NotNull
    private String roleName;
    @Size(max = 255)
    @NotNull
    private String username;
    @NotNull
    private Integer points;
    @Size(max = 15)
    @NotNull
    private String mobile;
    @Size(max = 1)
    @NotNull
    private String status;
}