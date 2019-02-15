package repository;
import api.ISessionHibernate;
import entity.Session;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import static domain.HibernateUtil.getEntityManager;

public class SessionRepository implements ISessionHibernate {

    @Override
    public void addSession(final Session session) {
        final EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.persist(session);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(final Session session) {
        final EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.remove(session);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public List<Session> getSessionList() {
        final EntityManager manager = getEntityManager();
        TypedQuery<Session> query = manager.createNamedQuery("Session.getAll", Session.class);
        return query.getResultList();
    }
}
