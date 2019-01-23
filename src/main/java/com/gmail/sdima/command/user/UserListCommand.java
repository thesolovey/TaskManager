package com.gmail.sdima.command.user;

import com.gmail.sdima.bootstrap.Bootstrap;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.entity.User;

import java.util.List;

public class UserListCommand extends AbstractCommand {
    public UserListCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "user-list";

    @Override
    public void execute() {
        System.out.println("[USER LIST]");
        List<User> userList = bootstrap.getUserService().getUsersList();
        for (User user : userList)
            System.out.println(user.getUserName());
        System.out.println("[OK]");

    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}