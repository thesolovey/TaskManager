package com.gmail.sdima9999.command.user;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.entity.User;

import java.util.UUID;

public class UserAdminCreateCommand extends AbstractCommand {
    public UserAdminCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        User newUser = new User();
        String login = "admin";
        String password = "admin";
        String userName = "admin";
        String userId = UUID.randomUUID().toString();

        newUser.setLogin(login);
        newUser.setPassword(password);
        newUser.setUserName(userName);
        newUser.setUserId(userId);

        bootstrap.getUserService().addUserByList(newUser);

    }

    @Override
    public void secure() {

    }
}
