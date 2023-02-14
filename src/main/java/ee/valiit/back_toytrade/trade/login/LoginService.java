package ee.valiit.back_toytrade.trade.login;

import ee.valiit.back_toytrade.domain.user.User;
import ee.valiit.back_toytrade.domain.user.UserMapper;
import ee.valiit.back_toytrade.domain.user.UserService;
import ee.valiit.back_toytrade.domain.user.role.Role;
import ee.valiit.back_toytrade.domain.user.role.RoleService;
import ee.valiit.back_toytrade.trade.dto.LoginResponse;
import ee.valiit.back_toytrade.trade.dto.NewUserRequest;
import ee.valiit.back_toytrade.validator.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserMapper userMapper;


    public LoginResponse login(String username, String password) {
        User user = userService.findUser(username, password);
        return userMapper.toDto(user);

    }

    public void addNewUser(NewUserRequest newUserRequest) {
        boolean userExists = userService.userExists(newUserRequest.getUsername());
        Validator.validateUserExists(userExists);
        User user = userMapper.toEntity(newUserRequest);
        Role role = roleService.findRole("user");
        user.setRole(role);
       userService.addNewUser(user);
    }

}
