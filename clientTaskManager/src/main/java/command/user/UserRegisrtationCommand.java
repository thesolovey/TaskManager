package command.user;

import bootstrap.BootstrapClient;
import command.AbstractCommand;
import command.ReadFromConsole;
import endpoint.User;

import java.util.UUID;

public class UserRegisrtationCommand extends AbstractCommand {
    public UserRegisrtationCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }
    public final static String COMMAND = "user-reg";

    @Override
    public void execute() {
        System.out.println("[REGISTRATION]");
        System.out.println("[NEW USER CREATE]");
        final User newUser = new User();
        final String login = ReadFromConsole.readInputFromConsole("Input Login: ");
        final String password = ReadFromConsole.readInputFromConsole("Input Password: ");
        final int passwordHash = password.hashCode();
        final String userName = ReadFromConsole.readInputFromConsole("Input Name: ");
        final String userId = UUID.randomUUID().toString();

        newUser.setLogin(login);
        newUser.setPassword(passwordHash);
        newUser.setUserName(userName);
        newUser.setId(userId);

        bootstrap.getEndpointUser().createUser(newUser);
        System.out.println("[OK]");
    }

    @Override
    public boolean secure() {
        return false;
    }

    @Override
    public String getKeyWord() { return "user-reg"; }

    @Override
    public String description() { return "Registration new User"; }
}
