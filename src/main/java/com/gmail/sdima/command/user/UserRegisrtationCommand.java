package com.gmail.sdima.command.user;

import com.gmail.sdima.bootstrap.Bootstrap;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.command.ReadFromConsole;
import com.gmail.sdima.entity.User;

import java.util.UUID;

public class UserRegisrtationCommand extends AbstractCommand {
    public UserRegisrtationCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }
    public final static String COMMAND = "user-reg";

    @Override
    public void execute() {
        System.out.println("[REGISTRATION]");
        System.out.println("[NEW USER CREATE]");
        final User newUser = new User();
        final String login = ReadFromConsole.readInputFromConsole("Input Login: ");
        final String password = ReadFromConsole.readInputFromConsole("Input Password: ");
        final int passwordHash = password.hashCode();
        final String userName = ReadFromConsole.readInputFromConsole("Input Name: ");
        final String userId = UUID.randomUUID().toString();

        newUser.setLogin(login);
        newUser.setPassword(passwordHash);
        newUser.setUserName(userName);
        newUser.setId(userId);

        bootstrap.getUserService().addUserByList(newUser);
        bootstrap.getUserService().setCurrentUser(newUser);
        System.out.println("[OK]");
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
