package command.user;

import bootstrap.BootstrapClient;
import command.AbstractCommand;
import endpoint.User;

import java.util.UUID;

public class UserTestCreateCommand extends AbstractCommand {
    public UserTestCreateCommand(BootstrapClient bootstrapClient) {
        super(bootstrapClient);
    }

    @Override
    public void execute() {
        final User user = new User();
        final String login = "test";
        final String password = "test";
        final int passwordHash = password.hashCode();
        final String userName = "test";
        final String userId = UUID.randomUUID().toString();

        user.setLogin(login);
        user.setPassword(passwordHash);
        user.setUserName(userName);
        user.setId(userId);

        getBootstrap().getEndPointUser().create(user);
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
