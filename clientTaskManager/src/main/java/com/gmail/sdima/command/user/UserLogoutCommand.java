package com.gmail.sdima.command.user;

import com.gmail.sdima.bootstrap.BootstrapClient;
import com.gmail.sdima.command.AbstractCommand;

public class UserLogoutCommand extends AbstractCommand {
    public UserLogoutCommand(BootstrapClient bootstrap) { super(bootstrap); }
    public UserLogoutCommand() { }

    @Override
    public void execute() {
        System.out.println("[LOGOUT]");
        getBootstrap().getEndpointSession().logOut(BootstrapClient.getSessionCurrentUser());
        BootstrapClient.setSessionCurrentUser(null);
        System.out.println("[OK]");
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public String getKeyWord() { return "user-logout"; }

    @Override
    public String description() { return "Logout currently user"; }
}
