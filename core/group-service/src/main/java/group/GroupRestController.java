package group;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GroupRestController {

    private static final List<Group> groups = new ArrayList<>();

    static {
        groups.add(new Group(1, "Developer", "Developer's Group"));
        groups.add(new Group(2, "Manager", "Manager's Group"));

    }

    @RequestMapping(method = RequestMethod.GET, value = "/groups")
    public List<Group> getGroups() {
        return groups;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/group/{id}")
    public Group getGroup(@PathVariable("id") Integer id) {
        return groups.stream().filter(g -> g.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Value("${configuration.projectName}")
    private String projectName;

    @RequestMapping("/project-name")
    public String projectName() {
        return this.projectName;
    }

}
