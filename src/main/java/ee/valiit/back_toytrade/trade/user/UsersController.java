package ee.valiit.back_toytrade.trade.user;

import ee.valiit.back_toytrade.domain.user.role.Role;
import ee.valiit.back_toytrade.trade.dto.NewUserRequest;
import ee.valiit.back_toytrade.trade.dto.UserInfo;
import ee.valiit.back_toytrade.trade.dto.UserRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Resource
    private UsersService usersService;

    @GetMapping("/all")
    @Operation(summary = "Finds all users", description = "Finds all active users from db table 'user'")
    public List<UserInfo> getAllUsers() {
        return usersService.getAllUsers();
    }

    @PutMapping
    @Operation(summary = "Updates user information", description = "Updates user information in db table 'user'")
    public void updateUser(@RequestParam Integer userId, @RequestBody UserRequest userRequest) {
        usersService.editUser(userId, userRequest);
    }

    @DeleteMapping
    @Operation(summary = "Deletes user", description = "User status is changed in db table 'user' and timestamp added")
    public void deleteUser(@RequestParam Integer userId) {
        usersService.deleteUser(userId);
    }

    @GetMapping("/me")
    @Operation(summary = "Gets user profile info", description = "Gets username and mobile from the db table 'user' based on userId")
    public UserRequest getUserInfo(@RequestParam Integer userId) {
        return usersService.getUserInfo(userId);
    }

    @PutMapping("/me")
    @Operation(summary = "Updates user information", description = "Updates user information in db table 'user'")
    public void updateUser(@RequestParam Integer userId, @RequestBody NewUserRequest userInfo) {
        usersService.editMyUser(userId, userInfo);
    }

    @GetMapping("/my-name")
    @Operation(summary = "gets users username", description = "Gets users username from the user db based on int userId")
    public String getMyUsername(@RequestParam Integer userId) {
        return usersService.getUsername(userId);
    }

    @GetMapping("/points")
    @Operation(summary = "Finds my points", description = "Finds my point total from the db 'user' table based on userId")
    public Integer getMyPoints(@RequestParam Integer userId) {
        return usersService.getMyPoints(userId);
    }

    @GetMapping("/roles")
    @Operation(summary = "Finds all roles", description = "Finds all roles from db table 'role")
    public List<Role> getAllRoles() {
        return usersService.getAllRoles();
    }


}