package command.user;

import bootstrap.Bootstrap;
import command.AbstractCommand;
import entity.User;

import java.util.UUID;

public class UserAdminCreateCommand extends AbstractCommand {
    public UserAdminCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        final User newUser = new User();
        final String login = "admin";
        final String password = "admin";
        final int passwordHash = password.hashCode();
        final String userName = "admin";
        final String userId = UUID.randomUUID().toString();

        newUser.setLogin(login);
        newUser.setPassword(passwordHash);
        newUser.setUserName(userName);
        newUser.setId(userId);

        bootstrap.getUserService().addUserByList(newUser);

    }

    @Override
    public boolean secure() {
        return false;
    }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}
