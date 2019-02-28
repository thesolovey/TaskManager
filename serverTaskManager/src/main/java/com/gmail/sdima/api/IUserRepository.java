package com.gmail.sdima.api;

import com.gmail.sdima.entity.User;

import java.util.List;

public interface IUserRepository {
    void addUserByList(User user);
    List<User> getUsersList();
}
