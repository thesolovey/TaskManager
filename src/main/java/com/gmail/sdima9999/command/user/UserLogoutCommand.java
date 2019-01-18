package com.gmail.sdima9999.command.user;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;

public class UserLogoutCommand extends AbstractCommand {
    public UserLogoutCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        System.out.println("[LOGOUT]");
        System.out.println("[OK]");
    }

    @Override
    public void secure() {

    }
}
