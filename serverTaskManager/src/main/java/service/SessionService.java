package service;

import api.ISessionService;
import entity.Session;
import repository.SessionRepository;

import java.util.List;

public class SessionService implements ISessionService {
    private SessionRepository sessionRepository;
    public SessionService(SessionRepository sessionRepository) { this.sessionRepository = sessionRepository; }

//    private Session currentSession = null;
//    public Session getCurrentSession() { return currentSession; }
//    public void setCurrentSession(Session userSession) { this.currentSession = userSession; }

    // НИКАКИХ ТЕКУЩИХ СЕССИЙ НА СЕРВЕРЕ, ПРОВЕРЯЕМ ВСЕГДА СЕССИЮ ПРИ ПОСТУПЛЕНИИ С КАЖДЫМ ЗАПРОСОМ

    public void validateSession(Session session) {
        if (session == null) {  }
        if (session.getUserId() == null) {   }
        // тут проверяю сессию полученную от клиента разными проверками
    }

//    public boolean isAuth() { return currentSession != null; }

    public void logOut() { //тут убиваю сессию
         }

    public Session getNewSession(String userId) { if (userId == null) { return null; }
        final Session session = new Session();
        session.setUserId(userId);
        sessionRepository.addSession(session);
        return session;
    }

    public void addSession(Session session) {
        if (session == null) return;
        sessionRepository.addSession(session);
    }

    public Session getSessionById(String userId) {
        if (userId == null || userId.isEmpty()) { return null; }
        final List<Session> sessionList = sessionRepository.getSessionList();
//        for (Session session: sessionList)
//            if (session.getUserId().equals(userId))
              return null;
    }

    public void delete(Session session) {
        if (session == null) return;
        sessionRepository.delete(session);
    }
}
