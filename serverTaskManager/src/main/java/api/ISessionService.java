package api;

import entity.Session;

public interface ISessionService {
    void validateSession(Session session);
    void logOut(Session session);
    Session getNewSession(String userId);
}
