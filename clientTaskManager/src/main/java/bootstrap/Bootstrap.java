package bootstrap;

import command.AbstractCommand;
import command.ReadFromConsole;
import command.project.*;
import command.service.ExitCommand;
import command.service.HelpCommand;
import command.service.LoadCommand;
import command.service.SaveCommand;
import command.task.*;
import command.user.*;
import endpoint.EndPointProject;
import endpoint.EndPointTask;
import endpoint.EndPointUser;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bootstrap {

    private final EndPointUser endPointUser = new EndPointUser();

    private final EndPointProject endPointProject = new EndPointProject();

    private final EndPointTask endPointTask = new EndPointTask();

    public EndPointUser getEndPointUser() { return endPointUser; }

    public EndPointProject getEndPointProject() { return endPointProject; }

    public EndPointTask getEndPointTask() { return endPointTask; }

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
        commands.put(ProjectClearCommand.COMMAND, new ProjectClearCommand(this));
        commands.put(ProjectUpdateCommand.COMMAND, new ProjectUpdateCommand(this));
        commands.put(TaskCreateCommand.COMMAND, new TaskCreateCommand(this));
        commands.put(TaskListCommand.COMMAND, new TaskListCommand(this));
        commands.put(TaskOpenCommand.COMMAND, new TaskOpenCommand(this));
        commands.put(TaskDeleteCommand.COMMAND, new TaskDeleteCommand(this));
        commands.put(TaskClearCommand.COMMAND, new TaskClearCommand(this));
        commands.put(TaskUpdateCommand.COMMAND, new TaskUpdateCommand(this));
    }

//    private void getCommands() throws IllegalAccessException, InstantiationException {
//
//        Reflections reflections = new Reflections("serverTaskManager.command");
//        final Set<Class<? extends AbstractCommand>> commandInput = reflections.getSubTypesOf(AbstractCommand.class);
//        for (final Class<? extends AbstractCommand> commandIn : commandInput) {
//            AbstractCommand command = commandIn.newInstance();
//            command.setBootstrap(this);
//            commands.put(command.getKeyWord(), command);
//        }
//    }

    public void start() {

        endPointUser.run();
        endPointProject.run();
        endPointTask.run();

        AbstractCommand userAdminCreateCommand = new UserAdminCreateCommand(this);
        userAdminCreateCommand.execute();

        AbstractCommand userTestCreateCommand = new UserTestCreateCommand(this);
        userTestCreateCommand.execute();

//        try {
//            getCommands();
//        } catch (Exception e) {e.printStackTrace(); }

        System.out.println("***WELLCOME TO TASK MANAGER***");

        do {
            String commandFromConsole = ReadFromConsole.readInputFromConsole("Input command: ");
            AbstractCommand command = commands.get(commandFromConsole);

            if (command == null) continue;
            if (command.secure() && !this.endPointUser.auth()) continue;

            //           if (commands.containsKey(commandFromConsole)) {
            command.execute();
            //           }
        } while (true);
    }
}
