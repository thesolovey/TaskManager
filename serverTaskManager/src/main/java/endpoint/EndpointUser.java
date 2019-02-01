package endpoint;

import api.ServiceLocator;
import entity.Session;
import entity.User;
import repository.SessionRepository;
import repository.UserRepository;
import service.SessionService;
import service.UserService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class EndpointUser {

    private ServiceLocator serviceLocator;
    public EndpointUser(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }
    private UserRepository userRepository = new UserRepository();
    private UserService userService = new UserService(userRepository);

    private SessionRepository sessionRepository = new SessionRepository();
    private SessionService sessionService = new SessionService(sessionRepository);

    @WebMethod
    public void createUser(User user) {
        userService.addUserByList(user);
    }

    @WebMethod
    public void logOutUser() {
        sessionService.logOut();
    }

    @WebMethod
    public Session getCurrentUser() {
        return sessionService.getCurrentSession();
    }

    @WebMethod
    public void setCurrentUser(Session currentSession) {
        sessionService.setCurrentSession(currentSession);
    }

    @WebMethod
    public List<User> findAllUser() {
        return userService.getUsersList();
    }

    @WebMethod
    public boolean authUser() {
        return sessionService.isAuth();
    }

    @WebMethod
    public List<User> getUserList() { return userService.getUsersList(); }

    @WebMethod
    public User getUserById(String userId) { return userService.getUserById(userId); }
}
