package command.user;

import bootstrap.Bootstrap;
import command.AbstractCommand;
import entity.User;

import java.util.UUID;

public class UserTestCreateCommand extends AbstractCommand {
    public UserTestCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public void execute() {
        final User userTest = new User();
        final String login = "test";
        final String password = "test";
        final int passwordHash = password.hashCode();
        final String userName = "test";
        final String userId = UUID.randomUUID().toString();

        userTest.setLogin(login);
        userTest.setPassword(passwordHash);
        userTest.setUserName(userName);
        userTest.setId(userId);

        bootstrap.getiUserService().addUserByList(userTest);
    }

    @Override
    public boolean secure() {
        return false;
    }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return "Create user Test"; }
}
