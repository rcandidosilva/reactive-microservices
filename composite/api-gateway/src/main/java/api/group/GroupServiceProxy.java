package api.group;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rx.Observable;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.ObservableResult;

@Component
public class GroupServiceProxy {
    @Autowired
    GroupService consumer;

    @HystrixCommand(fallbackMethod = "defaultGroupObservable")
    public Observable<Group> getGroupObservable(Integer id) {
        return new ObservableResult<Group>() {
            @Override
            public Group invoke() {
                return consumer.getGroup(id);
            }
        };
    }

    @HystrixCommand(fallbackMethod = "defaultGroupsObservable")
    public Observable<List<Group>> getGroupsObservable() {
        return new ObservableResult<List<Group>>() {
            @Override
            public List<Group> invoke() {
                return consumer.getGroups();
            }
        };
    }

    public Observable<Group> defaultGroupObservable(Integer id) {
        System.out.println("defaultGroupObservable");
        return null;
    }

    public Observable<Group> defaultGroupsObservable() {
        System.out.println("defaultGroupsObservable");
        return null;
    }

}
