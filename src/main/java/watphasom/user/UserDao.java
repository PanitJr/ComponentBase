package watphasom.user;

import watphasom.role.Role;

import java.util.List;
import java.util.Set;

/**
 * Created by panit on 5/18/2016.
 */
public interface UserDao {
    List<User> getAll();
    List<User> findByUsernameContaining(String username);
    User getOne(String id);
    User findByUsername(String username);
    User create(User user);
    User update(User user);
    User delete(User user);
    User findByEmail(String email);
    List<User> findByRoles(Set<Role> roles);
}
