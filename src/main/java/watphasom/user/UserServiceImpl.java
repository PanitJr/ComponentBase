package watphasom.user;

import watphasom.role.Role;
import watphasom.role.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by panit on 5/18/2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao){this.userDao=userDao;}
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public List<User> shearchUsername(String username) {
        return userDao.findByUsernameContaining(username);
    }

    @Override
    public User getOne(String id) {
        return userDao.getOne(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User create(User user) {
        Role newRole = roleDao.getByRoleName("customer");
        Set<Role> roles = new HashSet<>();
        roles.add(newRole);
        user.setRoles(roles);
        user.getMessages().add(new Message("Welcome","Welcome to Wat Phasom E-commerce System"));
        return userDao.create(user);
    }

    @Override
    public User update(User user) {
        user.getMessages().add(new Message("Account Update","Your account has been updated"));
        return userDao.update(user);
    }


    @Override
    public User delete(String id) {
        return userDao.delete(userDao.getOne(id));
    }

    @Override
    public User changeRole(User user, String roleName) {
        Role newRole = roleDao.getByRoleName(roleName);
        Set<Role> roles = new HashSet<>();
        roles.add(newRole);
        user.setRoles(roles);
        user.getMessages().add(new Message("User Role Change","Your Account Role has been change to "+roleName));
        return userDao.update(user);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
    @Override
    public void adminNotification(String title,String content){
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getByRoleName("admin"));
        List<User> users = userDao.findByRoles(roles);
        for (User user:users) {
            user.getMessages().add(new Message(title,content));
        }
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.findAll();
    }
}
