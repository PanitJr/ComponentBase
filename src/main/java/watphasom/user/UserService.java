package watphasom.user;

import watphasom.role.Role;

import java.util.List;

/**
 * Created by panit on 5/18/2016.
 */
public interface UserService {
    List<User> getAll();
    List<User> shearchUsername(String username);
    User getOne(String id);
    User findByUsername(String username);
    User create(User user);
    User update(User user);
    User delete(String id);
    User changeRole(User user,String roleName);
    User findByEmail(String email);
    void adminNotification(String title,String content);
    List<Role> getRoles ();
}
