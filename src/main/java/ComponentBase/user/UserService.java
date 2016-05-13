package ComponentBase.user;

import ComponentBase.role.Role;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by waiti on 5/1/2016.
 */
public interface UserService {
    List<User> getUsers();
    List<User> findByName(String name);
    List<User> findBySurname(String surname);
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findByPhoneNumber(String phoneNumber);
    List<User> findByAddresses(Address address);
    List<User> findByDob(Date dob);
    List<User> findByRoles(Set<Role> roles);
    User create(User user);
    User edit(User user);
    User delete(String id);
    User getUser(String id);
    User addAddress(Address address,String id);

}
