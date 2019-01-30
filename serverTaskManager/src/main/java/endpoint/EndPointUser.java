package endpoint;

import entity.User;
import repository.UserRepository;
import service.UserService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService
public class EndPointUser {

    private UserRepository userRepository = new UserRepository();
    private UserService userService = new UserService(userRepository);

    @WebMethod
    public void run() {
        Endpoint.publish("http://localhost:8080/user?wsdl", new EndPointUser());
    }

    @WebMethod
    public void create(User user) {
        userService.addUserByList(user);
    }

    @WebMethod
    public void logOut() {
        userService.logOut();
    }

    @WebMethod
    public User getCurrentUser() {
        User user = userService.getCurrentUser();
        return user;
    }

    @WebMethod
    public void setCurrentUser(User currentUser) {
        userService.setCurrentUser(currentUser);
    }

    @WebMethod
    public List<User> findAll() {
        final List<User> userList = userService.getUsersList();
        return userList;
    }

    @WebMethod
    public boolean auth() {
        boolean authz = userService.isAuth();
        return authz;
    }
}
