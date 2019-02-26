package com.gmail.sdima.command;

import com.gmail.sdima.entity.User;
import com.gmail.sdima.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class UserTestCreateCommand {

    @Inject private UserService userService;

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
