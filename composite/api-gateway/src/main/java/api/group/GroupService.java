package api.group;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("GROUP-SERVICE")
public interface GroupService {

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    List<Group> getGroups();

    @RequestMapping(value = "/group/{id}", method = RequestMethod.GET)
    Group getGroup(@PathVariable("id") Integer id);

}
