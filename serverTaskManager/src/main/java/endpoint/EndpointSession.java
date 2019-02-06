package endpoint;

import api.ServiceLocator;
import entity.Session;
import exception.AccessForbiddenException;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class EndpointSession {

    private ServiceLocator serviceLocator;
    public EndpointSession(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    @WebMethod
    public Session getNewSession(String userId) { return serviceLocator.getiSessionService().getNewSession(userId); }

    @WebMethod
    public void logOut(Session session) { serviceLocator.getiSessionService().logOut(session); }

    @WebMethod
    public Session getSessionByUserId(String userId) { return serviceLocator.getiSessionService().getSessionById(userId); }

    @WebMethod
    public void validateSession(Session session) throws AccessForbiddenException { serviceLocator.getiSessionService().validateSession(session); }
}
