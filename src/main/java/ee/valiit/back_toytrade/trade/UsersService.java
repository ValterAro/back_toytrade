package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.user.User;
import ee.valiit.back_toytrade.domain.user.UserInfo;
import ee.valiit.back_toytrade.domain.user.UserMapper;
import ee.valiit.back_toytrade.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public List<UserInfo> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return userMapper.toInfos(allUsers);
    }
}
