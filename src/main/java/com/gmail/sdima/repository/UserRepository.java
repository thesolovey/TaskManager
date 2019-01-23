package com.gmail.sdima.repository;

import com.gmail.sdima.entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Serializable {

    private final List<User> usersList = new ArrayList<>();

    public void addUser(User user) { usersList.add(user); }

    public List<User> getUsersList() { return usersList; }

    public void clearUsersList() { usersList.clear();}

    public void deleteUser(User user) { usersList.remove(user); }
}
