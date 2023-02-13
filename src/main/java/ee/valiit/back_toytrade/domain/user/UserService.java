package ee.valiit.back_toytrade.domain.user;

import ee.valiit.back_toytrade.trade.Status;
import ee.valiit.back_toytrade.validator.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User findUser(String username, String password) {
        Optional<User> user = userRepository.findUser(username, password, Status.ACTIVE);
        return Validator.getValidUser(user);

    }

    public void addNewUser(User user) {
      userRepository.save(user);
    }

    public boolean userExists(String username) {
        return userRepository.userExists(username);
    }

    public User findUser(Integer userId) {
        return userRepository.findById(userId).get();
    }

    public List<User> getAllUsers() {
        return userRepository.findActiveUsers(Status.ACTIVE);
    }



}