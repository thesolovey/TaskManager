package api;

import entity.Session;
import exception.AccessForbiddenException;

public interface ISessionService {
    void validateSession(Session session) throws AccessForbiddenException;
    void logOut(Session session);
    Session getNewSession(String userId);
    Session getSessionById(String userId);

}
