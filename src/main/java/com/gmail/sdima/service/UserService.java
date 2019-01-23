package com.gmail.sdima.service;

import com.gmail.sdima.entity.User;
import com.gmail.sdima.repository.UserRepository;

import java.io.*;
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

    public void writeObject() {
        try {
            FileOutputStream fos = null;
            fos = new FileOutputStream("temp.txt");
            ObjectOutputStream oos = null;
            oos = new ObjectOutputStream(fos);
            oos.writeObject(usersRepository.getUsersList());
            oos.flush();
            oos.close();
        } catch (IOException e) {e.printStackTrace();}
    }

    public List<User>  readObject () {
        List<User> userList = null;
        try {
            FileInputStream fis = null;
            fis = new FileInputStream("temp.txt");
            ObjectInputStream ois = null;
            ois = new ObjectInputStream(fis);
            userList = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) { e.printStackTrace();}
        return userList;
    }
}
