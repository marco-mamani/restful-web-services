package duo.code.rest.webservices.resfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User newUser) {
        if(newUser.getId()==null)
            newUser.setId(++usersCount);
        users.add(newUser);
        return newUser;
    }

    public User findOne(int id) {
        for(User user: users) {
            if (user.getId()==id)
                return user;
        }
        return null;
    }
}
