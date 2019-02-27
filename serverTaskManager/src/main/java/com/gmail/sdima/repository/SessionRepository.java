package com.gmail.sdima.repository;
import com.gmail.sdima.api.ISessionHibernate;
import com.gmail.sdima.entity.Session;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
@Transactional
public class SessionRepository implements ISessionHibernate {

    @Inject private EntityManager manager;

    @Override
    public void addSession(final Session session) {
        manager.persist(session);
    }

    @Override
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
