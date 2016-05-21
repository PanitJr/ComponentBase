package watphasom.role;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by panit on 5/18/2016.
 */
@Repository
public interface RoleDao {
    Role getByRoleName(String roleName);
    List<Role> findAll();
}
