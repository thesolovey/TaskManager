package com.gmail.sdima.repository;
import com.gmail.sdima.api.ISessionRepository;
import com.gmail.sdima.entity.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SessionRepository implements ISessionRepository {

    @PersistenceContext private EntityManager manager;

    @Override
    @Transactional
    public void addSession(final Session session) {
        manager.persist(session);
    }

    @Override
    @Transactional
    public void delete(Session session) {
        session = manager.merge(session);
        manager.remove(session);
    }

    @Override
    public List<Session> getSessionList() {
        TypedQuery<Session> query = manager.createNamedQuery("Session.getAll", Session.class);
        return query.getResultList();
    }
}
