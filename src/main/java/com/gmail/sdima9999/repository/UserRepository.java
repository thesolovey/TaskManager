package com.gmail.sdima9999.repository;

import com.gmail.sdima9999.entity.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Serializable {

    private final List<User> usersList = new ArrayList<>();

    public void addUserByList(User user) { usersList.add(user); }

    public List<User> getUsersList() { return usersList; }

    public void clearUsersList() { usersList.clear();}
}
