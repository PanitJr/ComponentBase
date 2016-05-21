package watphasom.role;

import watphasom.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by panit on 5/18/2016.
 */
@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role getByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
