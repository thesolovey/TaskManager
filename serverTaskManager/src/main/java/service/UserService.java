package service;

import api.IUserHibernate;
import api.IUserService;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static domain.HibernateUtil.getEntityManager;

public class UserService implements IUserService, IUserHibernate {

    public Boolean checkUserListIsEmpty() {
        final EntityManager manager = getEntityManager();
        try {
            TypedQuery<User> namedQuery = manager.createNamedQuery("User.getAll", User.class);
            final List<User> userList = namedQuery.getResultList();
            return userList == null || userList.isEmpty();
        } finally { manager.close(); }
    }

    @Override
    public void addUserByList(final User user) {
        if (user == null) return;
        final EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
        manager.close();
    }

    public List<User> getUsersList() {
        final EntityManager manager = getEntityManager();
        try {
            TypedQuery<User> namedQuery = manager.createNamedQuery("User.getAll", User.class);
            return namedQuery.getResultList();
        } finally { manager.close(); }
    }

    @Override
    public void delete(User user) { }

    public User getUserById (final String userId) {
        final EntityManager manager = getEntityManager();
        try {
            User userById = new User();
            TypedQuery<User> namedQuery = manager.createNamedQuery("User.getAll", User.class);
            final List<User> usersList = namedQuery.getResultList();
            for (User users : usersList)
                if (users.getId().equals(userId))
                    userById = users;
            return userById;
        } finally { manager.close(); }
    }
}

