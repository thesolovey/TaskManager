package com.gmail.sdima.command;

import com.gmail.sdima.entity.User;
import com.gmail.sdima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserAdminCreateCommand {

    @Autowired private UserService userService;

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
