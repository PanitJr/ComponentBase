package ComponentBase.role;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by panit on 5/4/2016.
 */
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleDao roleDao;
    @Override
    public Role findByName(String name) {
        return roleDao.findByName(name);
    }
}
