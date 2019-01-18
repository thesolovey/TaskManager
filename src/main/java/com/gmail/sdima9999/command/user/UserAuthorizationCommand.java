package com.gmail.sdima9999.command.user;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.console.ReadFromConsole;
import com.gmail.sdima9999.entity.User;

import java.util.List;

public class UserAuthorizationCommand extends AbstractCommand {

    public UserAuthorizationCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println("[USER AUTHORIZATION]");
        List<User> userList = bootstrap.getUserService().getUsersList();

        String login = ReadFromConsole.readInputFromConsole("Input login: ");
        for (User user : userList) {
            if (user.getLogin().equals(login)) {
                String password = ReadFromConsole.readInputFromConsole("Input password: ");
                if (password.equals(user.getPassword()))
                    System.out.println("[OK]");

            }
        }
    }

    @Override
    public void secure() {

    }
}
