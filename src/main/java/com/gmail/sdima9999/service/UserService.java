package com.gmail.sdima9999.service;

import com.gmail.sdima9999.entity.User;
import com.gmail.sdima9999.repository.UserRepository;

import java.util.List;

public class UserService {
    public UserService(UserRepository usersRepository) { this.usersRepository = usersRepository; }

    private User currentUser = null;

    public User getCurrentUser() { return currentUser; }

    public void setCurrentUser(User currentUser) { this.currentUser = currentUser; }

    private UserRepository usersRepository;

    public boolean isAuth() {
        return currentUser != null;
    }

    public void logOut() {
        currentUser = null;
    }

    public Boolean checkUserListIsEmpty() {
        List<User> usersList = usersRepository.getUsersList();
        return usersList == null || usersList.isEmpty();
    }

    public void addUserByList(User user) {
        usersRepository.addUserByList(user);
    }

    public List<User> getUsersList() { return usersRepository.getUsersList(); }

    public User getUserByLogin(String login) {
        User userByLogin = new User();
        List<User> usersList = usersRepository.getUsersList();
        for (User users : usersList)
            if (users.getLogin().equals(login))
                userByLogin = users;
                return userByLogin;
    }

    public void clearUsersList() { usersRepository.clearUsersList(); }
}
