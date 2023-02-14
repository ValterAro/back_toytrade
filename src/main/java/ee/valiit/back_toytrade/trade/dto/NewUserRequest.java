package ee.valiit.back_toytrade.trade.dto;

import lombok.Data;

/**
 * A DTO for the {@link ee.valiit.back_toytrade.domain.user.User} entity
 */
@Data
public class NewUserRequest {

    private String username;

    private String password;

    private String mobile;
}