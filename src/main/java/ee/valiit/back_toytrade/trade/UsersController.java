package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.user.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Resource
    private UsersService usersService;

    @GetMapping("/users")
    @Operation(summary = "Finds all users", description = "Finds all active users from db table user")
    public List<UserInfo> getAllUsers() {
        return usersService.getAllUsers();
    }

}
