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

    public final static String COMMAND = "user-login";

    @Override
    public void execute() {
        System.out.println("[USER AUTHORIZATION]");

        final List<User> userList = bootstrap.getEndpointUser().findAllUser();
        if (bootstrap.getEndpointUser().getCurrentUser() != null) {
            System.out.println("!!! You first need to log out !!!");
        } else {

            String login = ReadFromConsole.readInputFromConsole("Input login: ");
            for (User user : userList) {
                if (user.getLogin().equals(login)) {
                    String password = ReadFromConsole.readInputFromConsole("Input password: ");
                    int passwordHash = password.hashCode();
                    if (passwordHash == (user.getPassword())) {
//                        bootstrap.getEndpointUser().setCurrentUser(user);

                        final String userId = user.getId();
                        final Session session = bootstrap.getEndpointSession().getNewSession(userId);
                        BootstrapClient.setSessionCurrentUser(session);

                        bootstrap.getEndpointUser().setCurrentUser(session);

                        System.out.println("[OK]");
                    } else {
                        System.out.println("Invalid Password");
                    }
                } //else {System.out.println("Invalid Login"); }
            }
        }
    }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return "user-login"; }

    @Override
    public String description() { return "Authorization"; }
}
