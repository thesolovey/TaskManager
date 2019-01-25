package com.gmail.sdima.service;

import com.gmail.sdima.entity.User;
import com.gmail.sdima.repository.UserRepository;

import java.util.List;

public class UserService {
    public UserService(UserRepository usersRepository) { this.usersRepository = usersRepository; }

    private User currentUser = null;

    public User getCurrentUser() { return currentUser; }

    public void setCurrentUser(User currentUser) { this.currentUser = currentUser; }

    public boolean isAuth() {
        return currentUser != null;
    }

    public void logOut() {
        currentUser = null;
    }

    private UserRepository usersRepository;

    public Boolean checkUserListIsEmpty() {
        List<User> usersList = usersRepository.getUsersList();
        return usersList == null || usersList.isEmpty();
    }

    public void addUserByList(User user) {
        if (usersRepository.getUsersList() == null) return;
        usersRepository.addUser(user);
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

    public void clearUsersList() {
        if (usersRepository.getUsersList() == null) return;
        usersRepository.clearUsersList(); }
}
