package ComponentBase.role;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by panit on 5/4/2016.
 */
public interface RoleDao {
    Role findByName(String name);
}
