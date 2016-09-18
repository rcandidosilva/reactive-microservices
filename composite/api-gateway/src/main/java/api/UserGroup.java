package api;

import java.io.Serializable;
import java.util.List;

import api.group.Group;
import api.user.User;

public class UserGroup implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -1431551194203587080L;

    List<User> users;

    List<Group> groups;

    User user;

    Group group;

    UserGroup() {
        super();
    }

    public UserGroup(List<User> users, List<Group> groups) {
        super();
        this.users = users;
        this.groups = groups;
    }

    public UserGroup(User user, Group group) {
        super();
        this.user = user;
        this.group = group;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}
