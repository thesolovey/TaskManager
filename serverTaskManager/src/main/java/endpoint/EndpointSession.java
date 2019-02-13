package endpoint;

import api.ServiceLocator;
import entity.Session;
import exception.AccessForbiddenException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class EndpointSession {

    private ServiceLocator serviceLocator;
    public EndpointSession(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    @WebMethod
    public Session getNewSession(@WebParam(name = "userId") final String userId) { return serviceLocator.getiSessionService().getNewSession(userId); }

    @WebMethod
    public void logOut(@WebParam(name = "session") final Session session) { serviceLocator.getiSessionService().logOut(session); }

    @WebMethod
    public Session getSessionByUserId(@WebParam(name = "userId") final String userId) { return serviceLocator.getiSessionService().getSessionById(userId); }

    @WebMethod
    public void validateSession(@WebParam(name = "session") final Session session) throws AccessForbiddenException { serviceLocator.getiSessionService().validateSession(session); }
}
