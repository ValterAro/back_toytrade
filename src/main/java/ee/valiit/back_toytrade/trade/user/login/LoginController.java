package ee.valiit.back_toytrade.trade.user.login;

import ee.valiit.back_toytrade.trade.dto.LoginResponse;
import ee.valiit.back_toytrade.trade.dto.NewUserRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/register")
    @Operation(summary = "New users can register here", description = "Checks if username is not taken already and then creates a new user")
    public void addNewUser(@RequestBody NewUserRequest newUserRequest) {
        loginService.addNewUser(newUserRequest);
    }

    @GetMapping("/login")
    @Operation(summary = "Users can log in from here", description = "Checks if user and password exist in db table 'user'")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        return loginService.login(username, password);
    }
}