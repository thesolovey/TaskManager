package com.gmail.sdima.repository;

import com.gmail.sdima.api.IUserHibernate;
import com.gmail.sdima.entity.User;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
@Transactional
public class UserRepository implements IUserHibernate {

    @Inject private EntityManager manager;

    @Override
    public void addUserByList(final User user) {
        manager.persist(user);
    }

    @Override
    public List<User> getUsersList() {
        TypedQuery<User> query = manager.createNamedQuery("User.getAll", User.class);
        return query.getResultList();
    }
}
