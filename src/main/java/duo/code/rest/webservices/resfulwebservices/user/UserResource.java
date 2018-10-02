package duo.code.rest.webservices.resfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    //GET /users
    //retrieveallUsers
    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    //GET /users/{id}
    //retrieveUser(int id)
    @RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        return service.findOne(id);
    }

    //CREATED
    // input - details of the User
    // output - CREATED & Return the created URI
    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        User savedUser = service.save(user);

    }

}
