package com.gmail.sdima9999.bootstrap;

import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.command.servises.ExitCommand;
import com.gmail.sdima9999.command.servises.HelpCommand;
import com.gmail.sdima9999.command.project.*;
import com.gmail.sdima9999.command.task.*;
import com.gmail.sdima9999.command.user.*;
import com.gmail.sdima9999.console.ReadFromConsole;
import com.gmail.sdima9999.repository.ProjectRepository;
import com.gmail.sdima9999.repository.TaskRepository;
import com.gmail.sdima9999.repository.UserRepository;
import com.gmail.sdima9999.service.ProjectService;
import com.gmail.sdima9999.service.TaskService;
import com.gmail.sdima9999.service.UserService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Bootstrap {

    private final Map<String, AbstractCommand> commands = new LinkedHashMap<>();

    {
        commands.put("help", new HelpCommand(this));
//        commands.put("user-login", new UserAuthorizationCommand(this));
//        commands.put("user-reg", new UserRegisrtationCommand(this));
        commands.put("user-list", new UserListCommand(this));
        commands.put("project-create", new ProjectCreateCommand(this));
        commands.put("task-create", new TaskCreateCommand(this));
        commands.put("project-list", new ProjectListCommand(this));
        commands.put("task-list", new TaskListCommand(this));
        commands.put("project-open", new ProjectOpenCommand(this));
        commands.put("task-open", new TaskOpenCommand(this));
        commands.put("project-delete", new ProjectDeleteCommand(this));
        commands.put("task-delete", new TaskDeleteCommand(this));
        commands.put("project-clear", new ProjectClearCommand(this));
        commands.put("task-clear", new TaskClearCommand(this));
        commands.put("project-update", new ProjectUpdateCommand(this));
        commands.put("task-update", new TaskUpdateCommand(this));
        commands.put("exit", new ExitCommand(this));
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
                String commandFromConcole = ReadFromConsole.readInputFromConsole("Input command: ");
                AbstractCommand command = commands.get(commandFromConcole);
                if (command != null) command.execute();
                if (this.getUserService().getCurrentUser() != null) command.secure();

        } while (true);
    }
}
