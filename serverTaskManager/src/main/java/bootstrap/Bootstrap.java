package bootstrap;

import command.AbstractCommand;
import command.ReadFromConsole;
import endpoint.EndPointProject;
import endpoint.EndPointTask;
import endpoint.EndPointUser;
import repository.ProjectRepository;
import repository.TaskRepository;
import repository.UserRepository;
import service.ProjectService;
import service.TaskService;
import service.UserService;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bootstrap {

    private final Map<String, AbstractCommand> commands = new LinkedHashMap<>();
//
//    {
//        commands.put(HelpCommand.COMMAND, new HelpCommand(this));
//        commands.put(ExitCommand.COMMAND, new ExitCommand(this));
//        commands.put(SaveCommand.COMMAND, new SaveCommand(this));
//        commands.put(LoadCommand.COMMAND, new LoadCommand(this));
//        commands.put(UserRegisrtationCommand.COMMAND, new UserRegisrtationCommand(this));
//        commands.put(UserAuthorizationCommand.COMMAND, new UserAuthorizationCommand(this));
//        commands.put(UserLogoutCommand.COMMAND, new UserLogoutCommand(this));
//        commands.put(UserListCommand.COMMAND, new UserListCommand(this));
//        commands.put(ProjectCreateCommand.COMMAND, new ProjectCreateCommand(this));
//        commands.put(ProjectListCommand.COMMAND, new ProjectListCommand(this));
//        commands.put(ProjectOpenCommand.COMMAND, new ProjectOpenCommand(this));
//        commands.put(ProjectDeleteCommand.COMMAND, new ProjectDeleteCommand(this));
//        commands.put(ProjectClearCommand.COMMAND, new ProjectClearCommand(this));
//        commands.put(ProjectUpdateCommand.COMMAND, new ProjectUpdateCommand(this));
//        commands.put(TaskCreateCommand.COMMAND, new TaskCreateCommand(this));
//        commands.put(TaskListCommand.COMMAND, new TaskListCommand(this));
//        commands.put(TaskOpenCommand.COMMAND, new TaskOpenCommand(this));
//        commands.put(TaskDeleteCommand.COMMAND, new TaskDeleteCommand(this));
//        commands.put(TaskClearCommand.COMMAND, new TaskClearCommand(this));
//        commands.put(TaskUpdateCommand.COMMAND, new TaskUpdateCommand(this));
//    }

    private EndPointUser endPointUser = new EndPointUser();
    private EndPointProject endPointProject = new EndPointProject();
    private EndPointTask endPointTask = new EndPointTask();

    private final TaskRepository taskRepository = new TaskRepository();

    private final ProjectRepository projectRepository = new ProjectRepository();

    private final ProjectService projectService = new ProjectService(projectRepository, taskRepository);

    private final TaskService taskService = new TaskService(taskRepository, projectRepository);

    private final UserRepository usersRepository = new UserRepository();

    private final UserService userService = new UserService(usersRepository);

    public UserRepository getUsersRepository() {
        return usersRepository;
    }

    public UserService getUserService() {
        return userService;
    }

    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

    public ProjectRepository getProjectRepository() {
        return projectRepository;
    }

    public ProjectService getProjectService() {
        return projectService;
    }

    public TaskService getTaskService() {
        return taskService;
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

//        try {
//            getCommands();
//        } catch (Exception e) {e.printStackTrace(); }

        System.out.println("***WELLCOME TO TASK MANAGER***");

        do {
            String commandFromConsole = ReadFromConsole.readInputFromConsole("Input command: ");
            AbstractCommand command = commands.get(commandFromConsole);

            if (command == null) continue;
            if (command.secure() && !this.getUserService().isAuth()) continue;
 //           if (commands.containsKey(commandFromConsole)) {
                command.execute();
 //           }
        } while (true);
    }
}
