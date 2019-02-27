package com.gmail.sdima.service;

import com.gmail.sdima.api.IUserService;
import com.gmail.sdima.entity.User;
import com.gmail.sdima.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

import static com.gmail.sdima.domain.HibernateUtil.getEntityManager;

@ApplicationScoped
public class UserService implements IUserService {

    @Inject private UserRepository userRepository;

    public Boolean checkUserListIsEmpty() {
        final List<User> userList = userRepository.getUsersList();
        return userList == null || userList.isEmpty();
    }

    @Override
    public void addUserByList(final User user) {
        if (user == null) return;
        userRepository.addUserByList(user);
    }

    @Override
    public List<User> getUsersList() {
        return userRepository.getUsersList();
    }

    @Override
    public User getUserById (final String userId) {
        if (userId == null) return null;
            User userById = new User();
            final EntityManager manager = getEntityManager();
            final List<User> usersList = userRepository.getUsersList();
            for (User users : usersList)
                if (users.getId().equals(userId))
                    userById = users;
            return userById;
    }
}

