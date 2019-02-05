package endpoint;

import api.ServiceLocator;
import entity.Session;
import entity.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class EndpointUser {

    private ServiceLocator serviceLocator;
    public EndpointUser(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    @WebMethod
    public void createUser(final User user) { serviceLocator.getiUserService().addUserByList(user); }

    @WebMethod
    public List<User> getUserList(final Session session) {
        serviceLocator.getiSessionService().validateSession(session);
        return serviceLocator.getiUserService().getUsersList();
    }

    @WebMethod
    public List<User> getUserListForRegistration() { return serviceLocator.getiUserService().getUsersList(); }

    @WebMethod
    public User getUserById(final Session session, final String userId) {
        serviceLocator.getiSessionService().validateSession(session);
        return serviceLocator.getiUserService().getUserById(userId); }
}
