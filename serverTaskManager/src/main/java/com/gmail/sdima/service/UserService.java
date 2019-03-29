package com.gmail.sdima.service;

import com.gmail.sdima.api.IUserRepository;
import com.gmail.sdima.api.IUserService;
import com.gmail.sdima.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired private IUserRepository userRepository;

    public boolean checkUserListIsEmpty() throws SQLException {
        final List<User> userList = userRepository.getUsersList();
        for (User user: userList)
            if(user.getUserName().equals("admin") && user.getUserName().equals("test")) { return true; }
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
        final List<User> usersList = userRepository.getUsersList();
        for (User users : usersList)
            if (users.getId().equals(userId))
                userById = users;
            return userById;
    }

    public User getUserByLogin (final String login) {
        if (login == null) return null;
        User userByLogin = new User();
        final List<User> userList = userRepository.getUsersList();
        for (User user: userList)
            if (user.getLogin().equals(login))
                userByLogin = user;
            return userByLogin;
    }
}

