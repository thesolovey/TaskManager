package com.gmail.sdima.bootstrap;

import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.command.ReadFromConsole;
import com.gmail.sdima.endpoint.*;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Component
public class BootstrapClient {

    private EndpointUser endpointUser = new EndpointUserService().getEndpointUserPort();
    private EndpointProject endpointProject = new EndpointProjectService().getEndpointProjectPort();
    private EndpointTask endpointTask = new EndpointTaskService().getEndpointTaskPort();
    private EndpointSession endpointSession = new EndpointSessionService().getEndpointSessionPort();

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
        Reflections reflections = new Reflections("com/gmail/sdima/command");
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
