package com.gmail.sdima.command;

import com.gmail.sdima.entity.User;
import com.gmail.sdima.service.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class UserAdminCreateCommand {

    @Inject private UserService userService;

    public void execute() {
        final User userAdmin = new User();
        final String login = "admin";
        final String password = "admin";
        final int passwordHash = password.hashCode();
        final String userName = "admin";
        final String userId = UUID.randomUUID().toString();

        userAdmin.setLogin(login);
        userAdmin.setPassword(passwordHash);
        userAdmin.setUserName(userName);
        userAdmin.setId(userId);

        userService.addUserByList(userAdmin);
    }
}
