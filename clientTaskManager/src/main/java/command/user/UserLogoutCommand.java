package command.user;

import bootstrap.BootstrapClient;
import command.AbstractCommand;

public class UserLogoutCommand extends AbstractCommand {
    public UserLogoutCommand(BootstrapClient bootstrap) { super(bootstrap); }

    public static final String COMMAND = "user-logout";

    @Override
    public void execute() {
        System.out.println("[LOGOUT]");
        getBootstrap().getEndpointUser().logOutUser();
//        bootstrap.getEndpointUser().logOut();
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
