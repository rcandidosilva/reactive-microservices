package api;

import api.group.Group;
import api.group.GroupServiceProxy;
import api.user.User;
import api.user.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

import java.util.List;

@RestController
public class APIController {

    @Autowired
    GroupServiceProxy groupConsumerService;

    @Autowired
    UserServiceProxy userConsumerService;

    @RequestMapping(method = RequestMethod.GET, value = "/userGroups")
    public UserGroup getUserGroups() {
        Observable<List<Group>> groups = groupConsumerService.getGroupsObservable();
        Observable<List<User>> users = userConsumerService.getUsersObservable();

        Observable<UserGroup> userGroupObservable = Observable.zip(groups, users, (g, u) -> new UserGroup(u, g));

        return userGroupObservable.toList().toBlocking().single().get(0);
    }

    @RequestMapping("/{userId}/{groupId}/userGroup")
    public UserGroup getUserGroup(@PathVariable("userId") Integer userId, @PathVariable("groupId") Integer groupId) {
        Observable<Group> groups = groupConsumerService.getGroupObservable(groupId);
        Observable<User> users = userConsumerService.getUserObservable(userId);

        Observable<UserGroup> userGroupObservable = Observable.zip(groups, users, (g, u) -> new UserGroup(u, g));

        return userGroupObservable.toList().toBlocking().single().get(0);
    }
}
