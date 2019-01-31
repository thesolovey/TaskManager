package endpoint;

import entity.User;
import repository.UserRepository;
import service.UserService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService
public class UserEndPoint {

    private UserRepository userRepository = new UserRepository();
    private UserService userService = new UserService(userRepository);

    @WebMethod
    public void run() {
        Endpoint.publish("http://localhost:8080/user?wsdl", new UserEndPoint());
    }

    @WebMethod
    public void createUser(User user) {
        userService.addUserByList(user);
    }

    @WebMethod
    public void logOutUser() {
        userService.logOut();
    }

    @WebMethod
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    @WebMethod
    public void setCurrentUser(User currentUser) {
        userService.setCurrentUser(currentUser);
    }

    @WebMethod
    public List<User> findAllUser() {
        return userService.getUsersList();
    }

    @WebMethod
    public boolean authUser() {
        return userService.isAuth();
    }
}
