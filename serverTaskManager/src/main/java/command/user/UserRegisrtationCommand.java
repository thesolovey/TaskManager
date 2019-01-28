package command.user;

import bootstrap.Bootstrap;
import command.AbstractCommand;
import command.ReadFromConsole;
import entity.User;

import java.util.UUID;

public class UserRegisrtationCommand extends AbstractCommand {
    public static final String COMMAND = "user-reg";

    public UserRegisrtationCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }


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

        bootstrap.getUserService().addUserByList(newUser);
        bootstrap.getUserService().setCurrentUser(newUser);
        System.out.println("[OK]");
    }

    @Override
    public boolean secure() {
        return false;
    }

    @Override
    public String getKeyWord() { return "user-reg"; }

    @Override
    public String description() { return "Registration user"; }
}
