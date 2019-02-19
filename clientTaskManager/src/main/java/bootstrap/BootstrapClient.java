package bootstrap;

import command.AbstractCommand;
import command.ReadFromConsole;
import endpoint.*;
import org.reflections.Reflections;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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
    public Set<String> getCommand() { return commands.keySet(); }

    private void getCommands() throws IllegalAccessException, InstantiationException {
        Reflections reflections = new Reflections("command");
        final Set<Class<? extends AbstractCommand>> commandInput = reflections.getSubTypesOf(AbstractCommand.class);
        for (final Class<? extends AbstractCommand> listCommand: commandInput) {
            AbstractCommand currentCommand = listCommand.newInstance();
            currentCommand.setBootstrap(this);
            commands.put(currentCommand.getKeyWord(), currentCommand);
        }
    }

    public void start() {
            System.out.println("***WELLCOME TO TASK MANAGER***");
            do {
                final String commandFromConsole = ReadFromConsole.readInputFromConsole("Input command: ");
                try {
                 getCommands();
                } catch (Exception e) {e.printStackTrace(); }
             if (commands.containsKey(commandFromConsole)) {
                final AbstractCommand command = commands.get(commandFromConsole);
                if (command == null) continue;
                if (command.secure() || getSessionCurrentUser() != null)
                    command.execute();
                       }
        } while (true);
    }
}
