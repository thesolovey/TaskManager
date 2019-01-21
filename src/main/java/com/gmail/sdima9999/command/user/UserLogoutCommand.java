package com.gmail.sdima9999.command.user;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;

public class UserLogoutCommand extends AbstractCommand {
    public UserLogoutCommand(Bootstrap bootstrap) { super(bootstrap); }

    public static final String COMMAND = "user-logout";

    @Override
    public void execute() {
        System.out.println("[LOGOUT]");
        bootstrap.getUserService().logOut();
        System.out.println("[OK]");
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}
