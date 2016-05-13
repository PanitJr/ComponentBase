package ComponentBase.role;

import ComponentBase.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by panit on 5/4/2016.
 */
public class RoleDaoImpl implements  RoleDao{

    @Autowired
    RoleRepository roleRepository;
    @Override
    public Role findByName(String name) {
        return roleRepository.findByRoleName(name);
    }
}
