package repository;

import api.IUserHibernate;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static domain.HibernateUtil.getEntityManager;

public class UserRepository implements IUserHibernate {

    @Override
    public void addUserByList(final User user) {
        final EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public List<User> getUsersList() {
        final EntityManager manager = getEntityManager();
        TypedQuery<User> query = manager.createNamedQuery("User.getAll", User.class);
        return query.getResultList();
    }
}
