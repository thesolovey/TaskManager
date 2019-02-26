package com.gmail.sdima.repository;

import com.gmail.sdima.api.IUserHibernate;
import com.gmail.sdima.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class UserRepository implements IUserHibernate {

    private EntityManager manager;
    public EntityManager getManager() { return manager; }
    public void setManager(EntityManager manager) { this.manager = manager; }

    @Override
    public void addUserByList(final User user) {
        getManager().persist(user);
    }

    @Override
    public List<User> getUsersList() {
        TypedQuery<User> query = getManager().createNamedQuery("User.getAll", User.class);
        return query.getResultList();
    }
}
