package endpoint;

import api.ServiceLocator;
import entity.Session;
import entity.User;
import exception.AccessForbiddenException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class EndpointUser {

    private ServiceLocator serviceLocator;
    public EndpointUser(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    @WebMethod
    public void createUser(@WebParam final User user) { serviceLocator.getiUserService().addUserByList(user); }

    @WebMethod
    public List<User> getUserList(@WebParam final Session session) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        return serviceLocator.getiUserService().getUsersList();
    }

    @WebMethod
    public List<User> getUserListForRegistration() { return serviceLocator.getiUserService().getUsersList(); }

    @WebMethod
    public User getUserById(@WebParam final Session session, @WebParam final String userId) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        return serviceLocator.getiUserService().getUserById(userId); }
}
