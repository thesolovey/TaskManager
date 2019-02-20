package service;
import api.ISessionService;
import config.ApplicationConfig;
import entity.Session;
import exception.AccessForbiddenException;
import org.apache.commons.codec.digest.DigestUtils;
import org.jetbrains.annotations.Nullable;
import repository.SessionRepository;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

import static domain.HibernateUtil.getEntityManager;

public class SessionService implements ISessionService {
    private SessionRepository sessionRepository;
    public SessionService(SessionRepository sessionRepository) {this.sessionRepository = sessionRepository;}

    private static final int SESSION_VALID_PERIOD = ApplicationConfig.SESSION_LIFE_TIME;

    @Nullable
    @Override
    public Session getNewSession(final String userId) {
        if (userId == null) { return null; }
        final Session session = new Session();
        final Date dateBegin = new Date();
        session.setUserId(userId);
        session.setStartValidPeriod(dateBegin);

        final String secretKey = ApplicationConfig.SECRET_KEY;
        final int saltCount = ApplicationConfig.SALT_COUNT;
        String signature = DigestUtils.md5Hex(session.getUserId());
        for (int i = 0; i < saltCount; i++) {
            signature = DigestUtils.md5Hex(signature + secretKey);
        }
        session.setSignature(signature);
        final EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        sessionRepository.setManager(manager);
        sessionRepository.addSession(session);
        manager.getTransaction().commit();
        manager.close();
        sessionRepository.setManager(manager);
        return session;
    }

    @Override
    public void validateSession(final Session currentSession) throws AccessForbiddenException {
        if (currentSession == null)  throw new AccessForbiddenException();
        if (currentSession.getSignature() == null || currentSession.getSignature().isEmpty()) throw new AccessForbiddenException();
        if (currentSession.getUserId() == null || currentSession.getUserId().isEmpty())  throw new AccessForbiddenException();
        if (currentSession.getStartValidPeriod() == null) throw new AccessForbiddenException();

        Session temp = new Session();
        final EntityManager manager = getEntityManager();
        sessionRepository.setManager(manager);
        final List<Session> sessionList = sessionRepository.getSessionList();
        for (Session session: sessionList) {
            if (!session.getUserId().equals(currentSession.getUserId())) { throw new AccessForbiddenException(); }
            if (session.getUserId().equals(currentSession.getUserId())) {temp = session;}
        }
        final String signatureSource = currentSession.getSignature();
        final String signatureTarget = temp.getSignature();
        final boolean checkSignature = signatureSource.equals(signatureTarget);
        if (!checkSignature) throw new  AccessForbiddenException();

        if (System.currentTimeMillis() - currentSession.getStartValidPeriod().getTime() > SESSION_VALID_PERIOD) {
            manager.getTransaction().begin();
            sessionRepository.setManager(manager);
            sessionRepository.delete(currentSession);
            manager.getTransaction().commit();
            manager.close();
            sessionRepository.setManager(manager);
        }
    }

    @Override
    public void logOut(final Session currentSession) {
        if (currentSession == null) return;
        final EntityManager manager = getEntityManager();
        sessionRepository.setManager(manager);
        final List<Session> sessionList = sessionRepository.getSessionList();
            for (Session session : sessionList) {
                if (session.getUserId().equals(currentSession.getUserId())) {
                    manager.getTransaction().begin();
                    sessionRepository.setManager(manager);
                    sessionRepository.delete(session);
                    manager.getTransaction().commit();
                    manager.close();
                    sessionRepository.setManager(manager);
                    return;
                }
            }
    }

    @Override
    public Session getSessionById(final String userId) {
        if (userId == null) { return null; }
        Session sessionByUserId = null;
        final EntityManager manager = getEntityManager();
        sessionRepository.setManager(manager);
        final List<Session> sessionList = sessionRepository.getSessionList();
            for (Session session: sessionList) {
                if (session.getUserId().equals(userId))
                    sessionByUserId = session;
            } return sessionByUserId;
    }
}
