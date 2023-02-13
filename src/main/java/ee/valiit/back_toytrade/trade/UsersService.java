package ee.valiit.back_toytrade.trade;

import ee.valiit.back_toytrade.domain.user.User;
import ee.valiit.back_toytrade.trade.dto.UserInfo;
import ee.valiit.back_toytrade.domain.user.UserMapper;
import ee.valiit.back_toytrade.domain.user.UserService;
import ee.valiit.back_toytrade.domain.user.role.Role;
import ee.valiit.back_toytrade.domain.user.role.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static ee.valiit.back_toytrade.trade.Status.DEACTIVATED;

@Service
public class UsersService {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserMapper userMapper;

    public List<UserInfo> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return userMapper.toInfos(allUsers);
    }

    public void deleteUser(Integer userId) {
        User user = userService.findUser(userId);
        String currentUsername = user.getUsername();
        String newUsername = currentUsername + " (deactivated: " + LocalDateTime.now() + ")";
        user.setUsername(newUsername);
        user.setStatus(DEACTIVATED);
        userService.saveUser(user);
    }

    public void editUser(Integer userId, UserInfo userInfo) {
        User user = userService.findUser(userId);
        userMapper.updateUser(userInfo, user);
        updateRoleIfChanged(userInfo.getRoleName(), user);
        userService.saveUser(user);
    }

    private void updateRoleIfChanged(String roleName, User user) {
        if (!roleName.equals(user.getRole().getName())) {
            Role role = roleService.findRole(roleName);
            user.setRole(role);
        }
    }


}
