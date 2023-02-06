package ee.valiit.back_toytrade.domain.user;

import ee.valiit.back_toytrade.validator.Validator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User findUser(String username, String password) {
        Optional<User> user = userRepository.findUser(username, password, "A");
        return Validator.getValidUser(user);


    }
}
