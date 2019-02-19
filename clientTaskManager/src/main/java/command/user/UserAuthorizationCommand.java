package command.user;

import bootstrap.BootstrapClient;
import command.AbstractCommand;
import command.ReadFromConsole;
import endpoint.Session;
import endpoint.User;

import java.util.List;

public class UserAuthorizationCommand extends AbstractCommand {
    public UserAuthorizationCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }
    public UserAuthorizationCommand() { }

    @Override
    public void execute() {
        System.out.println("[USER AUTHORIZATION]");

        final List<User> userList = bootstrap.getEndpointUser().getUserListForRegistration();
        if (BootstrapClient.getSessionCurrentUser() != null) {
            System.out.println("!!! You first need to log out !!!");
        } else {
            final String login = ReadFromConsole.readInputFromConsole("Input login: ");
            for (User user : userList) {
                if (user.getLogin().equals(login)) {
                    final String password = ReadFromConsole.readInputFromConsole("Input password: ");
                    int passwordHash = password.hashCode();
                    if (passwordHash == (user.getPassword())) {
                        final String userId = user.getId();
                        final Session session = bootstrap.getEndpointSession().getNewSession(userId);
                        BootstrapClient.setSessionCurrentUser(session);
                        System.out.println("[OK]");
                        break;
                    }
                }
            }
        }
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return "user-login"; }

    @Override
    public String description() { return "Authorization"; }
}
