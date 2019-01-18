package com.gmail.sdima9999.command.user;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.entity.User;

import java.util.List;

public class UserListCommand extends AbstractCommand {
    public UserListCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println("[USER LIST]");
        List<User> userList = bootstrap.getUserService().getUsersList();
        for (User user : userList)
            System.out.println(user.getUserName());
        System.out.println("[OK]");

    }

    @Override
    public void secure() {

    }
}
