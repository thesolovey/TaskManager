package com.gmail.sdima9999.command.user;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.entity.User;

import java.util.UUID;

public class UserTestCreateCommand extends AbstractCommand {
    public UserTestCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        User user = new User();
        String login = "test";
        String password = "test";
        String userName = "test";
        String userId = UUID.randomUUID().toString();

        user.setLogin(login);
        user.setPassword(password);
        user.setUserName(userName);
        user.setUserId(userId);

        bootstrap.getUserService().addUserByList(user);
    }

    @Override
    public void secure() {

    }
}
