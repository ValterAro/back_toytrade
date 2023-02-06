package ee.valiit.back_toytrade.domain.user;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User findUser(String username, String password) {
        return userRepository.findUser(username, password, "A").get();
    }
}
