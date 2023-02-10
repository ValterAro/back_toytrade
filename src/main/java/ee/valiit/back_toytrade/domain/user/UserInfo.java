package ee.valiit.back_toytrade.domain.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserInfo implements Serializable {
    private final Integer id;
    private final Integer roleId;
    @Size(max = 50)
    @NotNull
    private final String roleName;
    @Size(max = 255)
    @NotNull
    private final String username;
    @NotNull
    private final Integer points;
    @Size(max = 15)
    @NotNull
    private final String mobile;
    @Size(max = 1)
    @NotNull
    private final String status;
}