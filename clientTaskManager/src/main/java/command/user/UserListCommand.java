package command.user;

import bootstrap.BootstrapClient;
import command.AbstractCommand;
import endpoint.User;

import java.util.List;

public class UserListCommand extends AbstractCommand {
    public UserListCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "user-list";

    @Override
    public void execute() {
        System.out.println("[USER LIST]");
        final List<User> userList = getBootstrap().getEndpointUser().findAllUser();
        for (User user : userList)
            System.out.println(user.getUserName());
        System.out.println("[OK]");

    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return "user-list"; }

    @Override
    public String description() { return "Shows list Users"; }
}