package ee.valiit.back_toytrade.domain.user.role;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Resource
    private RoleRepository roleRepository;

    public Role findRole(String roleName) {
      return roleRepository.findRole(roleName).get();
    }


}
