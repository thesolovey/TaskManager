package com.gmail.sdima9999.command.user;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.command.ReadFromConsole;
import com.gmail.sdima9999.entity.User;

import java.util.List;

public class UserAuthorizationCommand extends AbstractCommand {

    public UserAuthorizationCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public final static String COMMAND = "user-login";

    @Override
    public void execute() {
        System.out.println("[USER AUTHORIZATION]");
        List<User> userList = bootstrap.getUserService().getUsersList();
        if (bootstrap.getUserService().getCurrentUser() != null) {
            System.out.println("!!! You first need to log out !!!");
        } else {

            String login = ReadFromConsole.readInputFromConsole("Input login: ");
            for (User user : userList) {
                if (user.getLogin().equals(login)) {
                    String password = ReadFromConsole.readInputFromConsole("Input password: ");
                    int passwordHash = password.hashCode();
                    if (passwordHash == (user.getPassword())) {
                        bootstrap.getUserService().setCurrentUser(user);
                        System.out.println("[OK]");
                    } else {
                        System.out.println("Invalid Password");
                    }
                } //else {System.out.println("Invalid Login"); }
            }
        }
    }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}
