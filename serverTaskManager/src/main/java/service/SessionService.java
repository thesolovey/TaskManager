package service;

import api.ISessionService;
import entity.Session;
import exception.AccessForbiddenException;
import repository.SessionRepository;

import java.util.List;

public class SessionService implements ISessionService {
    private SessionRepository sessionRepository;
    public SessionService(SessionRepository sessionRepository) { this.sessionRepository = sessionRepository; }

    public Session getNewSession(final String userId) { if (userId == null) { return null; }
        final Session session = new Session();
        session.setUserId(userId);
        sessionRepository.addSession(session);
        return session;
    }

    public void validateSession(final Session currentSession) throws AccessForbiddenException {
        final List<Session> sessionList = sessionRepository.getSessionList();
        if (currentSession == null) { throw new AccessForbiddenException(); }
        if (currentSession.getUserId() == null) { throw new AccessForbiddenException(); }
        if (sessionList.size() == 0) { throw new AccessForbiddenException(); }
        for (Session session: sessionList)
            if (!session.getUserId().equals(currentSession.getUserId())) { throw new AccessForbiddenException(); }
    }

    public void logOut(final Session currentSession) { //тут убиваю сессию
        if (currentSession == null) return;
        final List<Session> sessionList = sessionRepository.getSessionList();
        for (Session session : sessionList) {
            if (session.getUserId().equals(currentSession.getUserId())) {
                sessionRepository.delete(session);
                return;
            }
        }
    }

    public Session getSessionById(final String userId) {
        if (userId == null || userId.isEmpty()) { return null; }
        final List<Session> sessionList = sessionRepository.getSessionList();
//        for (Session session: sessionList)
//            if (session.getUserId().equals(userId))
              return null;
    }
}
