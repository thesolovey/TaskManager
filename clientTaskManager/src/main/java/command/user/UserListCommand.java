package command.user;

import bootstrap.BootstrapClient;
import command.AbstractCommand;
import endpoint.AccessForbiddenException_Exception;
import endpoint.User;

import java.util.ArrayList;
import java.util.List;

public class UserListCommand extends AbstractCommand {
    public UserListCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "user-list";

    @Override
    public void execute() {
        System.out.println("[USER LIST]");
        List<User> userList = new ArrayList<>();
        try {
            userList = getBootstrap().getEndpointUser().getUserList(BootstrapClient.getSessionCurrentUser());
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
        }
        for (User user : userList)
            System.out.println(user.getUserName());
        System.out.println("[OK]");

    }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return "user-list"; }

    @Override
    public String description() { return "Shows list Users"; }
}
