package ee.valiit.back_toytrade.trade.login;

import ee.valiit.back_toytrade.trade.dto.LoginResponse;
import ee.valiit.back_toytrade.trade.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "Sisse logimine käib siit", description = "Siin on logimise pikem description")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        return loginService.login(username, password);
    }

    @PostMapping("/register")
    @Operation(summary = "Regamine käib siit", description = "Siit saab regada")
    public void addNewUser(@RequestBody UserDto userDto) {
         loginService.addNewUser(userDto);
    }

}
