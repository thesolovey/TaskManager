package service;

import api.ISessionService;
import entity.Session;
import repository.SessionRepository;

import java.util.List;

public class SessionService implements ISessionService {
    private SessionRepository sessionRepository = new SessionRepository();

    public SessionService(SessionRepository sessionRepository) { this.sessionRepository = sessionRepository; }

    private Session currentSession = null;

    public Session getCurrentSession() { return currentSession; }

    public void setCurrentSession(Session currentSession) { this.currentSession = currentSession; }

    public void addSession(Session session) {
        if (session == null) return;
        sessionRepository.addSession(session);
    }

    public void deleteSession(Session session) {
        if (session == null) return;
        sessionRepository.deleteSession(session);
    }

    public List<Session> getSessionList() {
        return sessionRepository.getSessionList();
    }
}
