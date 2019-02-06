package service;
import org.apache.commons.codec.digest.DigestUtils;
import api.ISessionService;
import config.ApplicationConfig;
import entity.Session;
import exception.AccessForbiddenException;
import repository.SessionRepository;

import java.util.List;

public class SessionService implements ISessionService {
    private SessionRepository sessionRepository;
    public SessionService(SessionRepository sessionRepository) { this.sessionRepository = sessionRepository; }
    private static final int SESSION_VALID_PERIOD = ApplicationConfig.sessionLifeTime;

    public Session getNewSession(final String userId) { if (userId == null) { return null; }
        final Session session = new Session();
        session.setUserId(userId);

        final String secretKey = ApplicationConfig.secretKey;
        final int saltCount = ApplicationConfig.saltCount;

        String signature = DigestUtils.md5Hex(session.getUserId());
        for (int i = 0; i < saltCount; i++) {
            signature = DigestUtils.md5Hex(signature + secretKey);
        }

        session.setSignature(signature);
        sessionRepository.addSession(session);
        return session;
    }

    public void validateSession(final Session currentSession) throws AccessForbiddenException {
        final List<Session> sessionList = sessionRepository.getSessionList();
        if (currentSession == null)  throw new AccessForbiddenException();
        if (currentSession.getSignature() == null || currentSession.getSignature().isEmpty()) throw new AccessForbiddenException();
        if (currentSession.getUserId() == null || currentSession.getUserId().isEmpty())  throw new AccessForbiddenException();
        if (currentSession.getStartValidPeriod() == null) throw new AccessForbiddenException();
        if (sessionList.size() == 0)  throw new AccessForbiddenException();
        Session temp = new Session();
        for (Session session: sessionList) {
            if (!session.getUserId().equals(currentSession.getUserId())) { throw new AccessForbiddenException(); }
            if (session.getUserId().equals(currentSession.getUserId())) {temp = session;}
        }
        final String signatureSource = currentSession.getSignature();
        final String signatureTarget = temp.getSignature();
        final boolean checkSignature = signatureSource.equals(signatureTarget);
        if (!checkSignature) throw new  AccessForbiddenException();

        if (System.currentTimeMillis() - currentSession.getStartValidPeriod().getTime() > SESSION_VALID_PERIOD) {
            sessionRepository.delete(currentSession);}
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
