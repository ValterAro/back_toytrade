package ee.valiit.back_toytrade.domain.user.role;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginResponse implements Serializable {
    private final Integer userId;
    @Size(max = 50)
    @NotNull
    private final String roleName;
}