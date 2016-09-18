package api.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rx.Observable;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.ObservableResult;

@Component
public class UserServiceProxy {
    @Autowired
    UserService consumer;

    @HystrixCommand(fallbackMethod = "defaultUserObservable")
    public Observable<User> getUserObservable(Integer id) {
        return new ObservableResult<User>() {
            @Override
            public User invoke() {
                return consumer.getUser(id);
            }
        };
    }

    @HystrixCommand(fallbackMethod = "defaultUsersObservable")
    public Observable<List<User>> getUsersObservable() {
        return new ObservableResult<List<User>>() {
            @Override
            public List<User> invoke() {
                return consumer.getUsers();
            }
        };
    }

    public Observable<User> defaultUserObservable(Integer id) {
        System.out.println("defaultUserObservable");
        return null;
    }

    public Observable<User> defaultUsersObservable() {
        System.out.println("defaultUsersObservable");
        return null;
    }

}
