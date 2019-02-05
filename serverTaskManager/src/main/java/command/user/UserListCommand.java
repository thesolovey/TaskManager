package command.user;

import bootstrap.Bootstrap;
import command.AbstractCommand;
import entity.User;

import java.util.List;

public class UserListCommand extends AbstractCommand {
    public UserListCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "user-list";

    @Override
    public void execute() {
        System.out.println("[USER LIST]");
        List<User> userList = bootstrap.getiUserService().getUsersList();
        for (User user : userList)
            System.out.println(user.getUserName());
        System.out.println("[OK]");

    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return "user-list"; }

    @Override
    public String description() { return "Shows list users"; }
}
