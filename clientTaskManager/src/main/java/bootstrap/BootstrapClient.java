package bootstrap;

import command.AbstractCommand;
import command.ReadFromConsole;
import command.project.*;
import command.service.ExitCommand;
import command.service.HelpCommand;
import command.service.LoadCommand;
import command.service.SaveCommand;
import command.task.*;
import command.user.UserAuthorizationCommand;
import command.user.UserListCommand;
import command.user.UserLogoutCommand;
import command.user.UserRegisrtationCommand;
import endpoint.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class BootstrapClient {

    private final EndpointUser endpointUser = new EndpointUserService().getEndpointUserPort();
    private final EndpointProject endpointProject = new EndpointProjectService().getEndpointProjectPort();
    private final EndpointTask endpointTask = new EndpointTaskService().getEndpointTaskPort();
    private final EndpointSession endpointSession = new EndpointSessionService().getEndpointSessionPort();

    public EndpointUser getEndpointUser() { return endpointUser; }
    public EndpointProject getEndpointProject() {return endpointProject; }
    public EndpointTask getEndpointTask() { return endpointTask; }
    public EndpointSession getEndpointSession() { return endpointSession; }

    private static Session sessionCurrentUser = null;
    public static Session getSessionCurrentUser() { return sessionCurrentUser; }
    public static void setSessionCurrentUser(Session sessionCurrentUser) {
        BootstrapClient.sessionCurrentUser = sessionCurrentUser; }

    private final Map<String, AbstractCommand> commands = new LinkedHashMap<>();
    {
        commands.put(HelpCommand.COMMAND, new HelpCommand(this));
        commands.put(ExitCommand.COMMAND, new ExitCommand(this));
        commands.put(SaveCommand.COMMAND, new SaveCommand(this));
        commands.put(LoadCommand.COMMAND, new LoadCommand(this));
        commands.put(UserRegisrtationCommand.COMMAND, new UserRegisrtationCommand(this));
        commands.put(UserAuthorizationCommand.COMMAND, new UserAuthorizationCommand(this));
        commands.put(UserLogoutCommand.COMMAND, new UserLogoutCommand(this));
        commands.put(UserListCommand.COMMAND, new UserListCommand(this));
        commands.put(ProjectCreateCommand.COMMAND, new ProjectCreateCommand(this));
        commands.put(ProjectListCommand.COMMAND, new ProjectListCommand(this));
        commands.put(ProjectOpenCommand.COMMAND, new ProjectOpenCommand(this));
        commands.put(ProjectDeleteCommand.COMMAND, new ProjectDeleteCommand(this));
        commands.put(ProjectUpdateCommand.COMMAND, new ProjectUpdateCommand(this));
        commands.put(TaskCreateCommand.COMMAND, new TaskCreateCommand(this));
        commands.put(TaskListCommand.COMMAND, new TaskListCommand(this));
        commands.put(TaskOpenCommand.COMMAND, new TaskOpenCommand(this));
        commands.put(TaskDeleteCommand.COMMAND, new TaskDeleteCommand(this));
        commands.put(TaskUpdateCommand.COMMAND, new TaskUpdateCommand(this));
    }

//    private void getCommands() throws IllegalAccessException, InstantiationException {
//        Reflections reflections = new Reflections("command");
//        final Set<Class<? extends AbstractCommand>> commandInput = reflections.getSubTypesOf(AbstractCommand.class);
//        for (final Class<? extends AbstractCommand> listCommand: commandInput) {
//            AbstractCommand currentCommand = listCommand.newInstance();
//            currentCommand.setBootstrap(this);
//            commands.put(currentCommand.getKeyWord(), currentCommand);
//        }
//    }

    public void start() {
            System.out.println("***WELLCOME TO TASK MANAGER***");

            do {
                final String commandFromConsole = ReadFromConsole.readInputFromConsole("Input command: ");

//                try {
//                 getCommands();
//                } catch (Exception e) {e.printStackTrace(); }
//             if (commands.containsKey(commandFromConsole)) {
                final AbstractCommand command = commands.get(commandFromConsole);
                if (command == null) continue;
                if (command.secure() || getSessionCurrentUser() != null)
                    command.execute();
//                       }
        } while (true);
    }
}
