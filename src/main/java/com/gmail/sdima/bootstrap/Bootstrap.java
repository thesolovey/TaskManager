package com.gmail.sdima.bootstrap;

import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.command.service.ExitCommand;
import com.gmail.sdima.command.service.HelpCommand;
import com.gmail.sdima.command.project.*;
import com.gmail.sdima.command.task.*;
import com.gmail.sdima.command.user.*;
import com.gmail.sdima.command.ReadFromConsole;
import com.gmail.sdima.repository.ProjectRepository;
import com.gmail.sdima.repository.TaskRepository;
import com.gmail.sdima.repository.UserRepository;
import com.gmail.sdima.service.ProjectService;
import com.gmail.sdima.service.TaskService;
import com.gmail.sdima.service.UserService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Bootstrap {

    private final Map<String, AbstractCommand> commands = new LinkedHashMap<>();

    {
        commands.put(HelpCommand.COMMAND, new HelpCommand(this));
        commands.put(ExitCommand.COMMAND, new ExitCommand(this));
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

    public Set<String> getCommands() { return commands.keySet(); }

    private final TaskRepository taskRepository = new TaskRepository();

    private final ProjectRepository projectRepository = new ProjectRepository();

    private final ProjectService projectService = new ProjectService(projectRepository, taskRepository);

    private final TaskService taskService = new TaskService(taskRepository);

    private final UserRepository usersRepository = new UserRepository();

    private final UserService userService = new UserService(usersRepository);

    public UserRepository getUsersRepository() { return usersRepository; }

    public UserService getUserService() { return userService; }

    public TaskRepository getTaskRepository() { return taskRepository; }

    public ProjectRepository getProjectRepository() { return projectRepository; }

    public ProjectService getProjectService() { return projectService; }

    public TaskService getTaskService() { return taskService; }

    public void start() {
        System.out.println("***WELLCOME TO TASK MANAGER***");

        AbstractCommand userAdminCreateCommand = new UserAdminCreateCommand(this);
        userAdminCreateCommand.execute();

        AbstractCommand userTestCreateCommand = new UserTestCreateCommand(this);
        userTestCreateCommand.execute();

        do {
                String commandFromConsole = ReadFromConsole.readInputFromConsole("Input command: ");
                AbstractCommand command = commands.get(commandFromConsole);
                if (command == null) continue;
                if (command.secure() && !this.getUserService().isAuth()) continue;
                command.execute();

        } while (true);
    }
}
