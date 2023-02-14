package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.user.role.Role;
import ee.valiit.back_toytrade.trade.dto.UserInfo;
import ee.valiit.back_toytrade.trade.dto.UserRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("users")
    @Operation(summary = "Updates user information", description = "Updates user information in db table 'user'")
    public void updateUser(@RequestParam Integer userId, @RequestBody UserRequest userRequest) {
        usersService.editUser(userId, userRequest);
    }

    @DeleteMapping("/users")
    @Operation(summary = "Deletes user", description = "User status is changed in database")
    public void deleteUser(@RequestParam Integer userId) {
        usersService.deleteUser(userId);
    }

    @GetMapping("/users/roles")
    @Operation(summary = "Finds all roles", description = "Finds all roles from db table 'role")
    public List<Role> getAllRoles() {
        return usersService.getAllRoles();
    }
}