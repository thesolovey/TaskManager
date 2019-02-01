package endpoint;

import entity.Session;
import repository.SessionRepository;
import service.SessionService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class EndpointSession {

    private SessionRepository sessionRepository = new SessionRepository();
    private SessionService sessionService = new SessionService(sessionRepository);

    @WebMethod
    public Session getNewSession(String userId) { return sessionService.getNewSession(userId); }

    @WebMethod
    public Session getSessionByUserId(String userId) { return sessionService.getSessionById(userId); }

    @WebMethod
    public void addSession(Session session) { sessionService.addSession(session); }

    @WebMethod
    public void deleteSession(Session session) { sessionService.delete(session); }
}
