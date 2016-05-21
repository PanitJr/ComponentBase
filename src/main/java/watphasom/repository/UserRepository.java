package watphasom.repository;

import watphasom.role.Role;
import watphasom.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Set;


/**
 * Created by waiti on 5/1/2016.
 */
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAll();
    List<User> findByUsernameContaining(String username);
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findByRoles(Set<Role> roles);
}
