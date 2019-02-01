package api;

import entity.Session;

public interface ISessionService {
    boolean invalidSession(Session session);
}
