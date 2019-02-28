package com.gmail.sdima.repository;

import com.gmail.sdima.api.IUserRepository;
import com.gmail.sdima.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    @PersistenceContext private EntityManager manager;

    @Override
    @Transactional
    public void addUserByList(final User user) {
        manager.persist(user);
    }

    @Override
    public List<User> getUsersList() {
        TypedQuery<User> query = manager.createNamedQuery("User.getAll", User.class);
        return query.getResultList();
    }
}
