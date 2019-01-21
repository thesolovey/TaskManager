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
        final User user = new User();
        final String login = "test";
        final String password = "test";
        final int passwordHash = password.hashCode();
        final String userName = "test";
        final String userId = UUID.randomUUID().toString();

        user.setLogin(login);
        user.setPassword(passwordHash);
        user.setUserName(userName);
        user.setId(userId);

        bootstrap.getUserService().addUserByList(user);
    }

    @Override
    public boolean secure() {
        return false;
    }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}
