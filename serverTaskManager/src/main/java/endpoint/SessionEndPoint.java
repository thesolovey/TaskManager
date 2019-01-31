package endpoint;

import entity.Session;
import repository.SessionRepository;
import service.SessionService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class SessionEndPoint {

    private SessionRepository sessionRepository = new SessionRepository();
    private SessionService sessionService = new SessionService(sessionRepository);

    @WebMethod
    public void run() {
        Endpoint.publish("http://localhost:8080/session?wsdl", new SessionEndPoint());
    }

    @WebMethod
    public void addSession(Session session) {sessionService.addSession(session);}

    @WebMethod
    public void deleteSession(Session session) {sessionService.deleteSession(session);}
}
