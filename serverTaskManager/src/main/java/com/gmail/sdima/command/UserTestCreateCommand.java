package com.gmail.sdima.command;

import com.gmail.sdima.entity.User;
import com.gmail.sdima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserTestCreateCommand {

    @Autowired private UserService userService;

    public void execute() {
        final User userTest = new User();
        final String login = "test";
        final String password = "test";
        final int passwordHash = password.hashCode();
        final String userName = "test";
        final String userId = UUID.randomUUID().toString();

        userTest.setLogin(login);
        userTest.setPassword(passwordHash);
        userTest.setUserName(userName);
        userTest.setId(userId);

        userService.addUserByList(userTest);
    }
}
