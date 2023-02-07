package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.user.*;
import ee.valiit.back_toytrade.domain.user.role.LoginResponse;
import ee.valiit.back_toytrade.trade.dto.UserDto;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResponse login(String username, String password) {
        User user = userService.findUser(username, password);
        return userMapper.toDto(user);

    }

    public void addNewUser(UserDto userDto) {

        User user = userMapper.toEntity(userDto);
        User checkUser = userService.findUser(user.getUsername(), user.getPassword());
        if (checkUser == null) {

            userService.addNewUser(user);

        }
    }

}
