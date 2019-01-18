package com.gmail.sdima9999.command.user;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.console.ReadFromConsole;
import com.gmail.sdima9999.entity.User;

import java.util.UUID;

public class UserRegisrtationCommand extends AbstractCommand {
    public UserRegisrtationCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println("[REGISTRATION]");
        System.out.println("[NEW USER CREATE]");
        User newUser = new User();
        String login = ReadFromConsole.readInputFromConsole("Input login: ");
        String password = ReadFromConsole.readInputFromConsole("Input Pasword: ");
        String userName = ReadFromConsole.readInputFromConsole("Input name: ");
        String userId = UUID.randomUUID().toString();

        newUser.setLogin(login);
        newUser.setPassword(password);
        newUser.setUserName(userName);
        newUser.setUserId(userId);

        bootstrap.getUserService().addUserByList(newUser);
        System.out.println("[OK]");
    }

    @Override
    public void secure() {

    }
}
