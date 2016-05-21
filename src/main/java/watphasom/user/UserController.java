package watphasom.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import watphasom.role.Role;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by panit on 5/18/2016.
 */
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;
    //user crud
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> getUser(){return userService.getAll();}

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable("id") String id){return userService.getOne(id);}

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody
    User add(@Valid @RequestBody User user, BindingResult bindingResult){
        return userService.create(user);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public User delete(@PathVariable("id") String id){
        return userService.delete(id);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public  User edit(@PathVariable("id") String id,@RequestBody User user, BindingResult bindingResult){
        return userService.update(user);
    }
    //service
    @RequestMapping(value = "/user/search/{name}",method = RequestMethod.GET)
    public List<User> findUserByUsername (@PathVariable("name") String name){return userService.shearchUsername(name);}

    @RequestMapping(value = "/user/{role}",method = RequestMethod.PUT)
    public User changeUserRole (@RequestBody User user,@PathVariable("role")String role){
        return userService.changeRole(user,role);
    }
    @RequestMapping(value = "/user/roles",method = RequestMethod.GET)
    public List<Role> getRoles(){return userService.getRoles();}
}
