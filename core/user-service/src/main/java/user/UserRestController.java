package user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserRestController {

    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Rodrigo", "C", "Silva"));
        users.add(new User(2, "Israel", "B", "Rodriguez"));
        users.add(new User(3, "Bruno", "", "Souza"));
        users.add(new User(4, "Edson", "", "Yanaga"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getUsers() {
        return users;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return users.stream().filter(g -> g.getId() == id).collect(Collectors.toList()).get(0);
    }

}
