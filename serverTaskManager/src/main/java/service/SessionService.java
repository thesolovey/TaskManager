package service;

import api.ISessionService;
import entity.Session;
import repository.SessionRepository;

import java.util.List;

public class SessionService implements ISessionService {
    private SessionRepository sessionRepository;
    public SessionService(SessionRepository sessionRepository) { this.sessionRepository = sessionRepository; }

    public void validateSession(final Session currentSession) {
        if (currentSession == null) { throw new NullPointerException("CurrentSession is null!!!"); }
        if (currentSession.getUserId() == null) { throw new NullPointerException("UserId is null"); }
        final List<Session> sessionList = sessionRepository.getSessionList();
        if (sessionList.size() == 0) { throw new NullPointerException("You don't have valid session!!!"); }
        for (Session session: sessionList)
            if (!session.getUserId().equals(currentSession.getUserId())) { throw new NullPointerException("Invalid currentSession!!!"); }
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

    public Session getNewSession(final String userId) { if (userId == null) { return null; }
        final Session session = new Session();
        session.setUserId(userId);
        sessionRepository.addSession(session);
        return session;
    }

    public Session getSessionById(final String userId) {
        if (userId == null || userId.isEmpty()) { return null; }
        final List<Session> sessionList = sessionRepository.getSessionList();
//        for (Session session: sessionList)
//            if (session.getUserId().equals(userId))
              return null;
    }
}
