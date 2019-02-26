package com.gmail.sdima.repository;
import com.gmail.sdima.api.ISessionHibernate;
import com.gmail.sdima.entity.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class SessionRepository implements ISessionHibernate {

    private EntityManager manager;
    public EntityManager getManager() { return manager; }
    public void setManager(EntityManager manager) { this.manager = manager; }

    @Override
    public void addSession(final Session session) {
        getManager().persist(session);
    }

    @Override
    public void delete(Session session) {
        session = getManager().merge(session);
        getManager().remove(session);
    }

    @Override
    public List<Session> getSessionList() {
        TypedQuery<Session> query = getManager().createNamedQuery("Session.getAll", Session.class);
        return query.getResultList();
    }
}
