package com.gmail.sdima9999.bootstrap;

import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.command.project.*;
import com.gmail.sdima9999.command.task.*;
import com.gmail.sdima9999.console.ReadFromConsole;
import com.gmail.sdima9999.repository.ProjectRepository;
import com.gmail.sdima9999.repository.TaskRepository;
import com.gmail.sdima9999.service.ProjectService;
import com.gmail.sdima9999.service.TaskService;

public class Bootstrap {
    private final TaskRepository taskRepository = new TaskRepository();

    private final ProjectRepository projectRepository = new ProjectRepository();

    private final ProjectService projectService = new ProjectService(projectRepository, taskRepository);

    private final TaskService taskService = new TaskService(taskRepository);

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

    public void start() {
        System.out.println("***WELLCOME TO TASK MANAGER***");
        Boolean isCorrect = true;
        do {
            String command = ReadFromConsole.readInputFromConsole("Input command: ");
            switch (command) {
                case "project-create":
                    AbstractCommand projectCreateCommand = new ProjectCreateCommand(this);
                    projectCreateCommand.execute();
                    break;
                case "task-create":
                    AbstractCommand taskCreateCommand = new TaskCreateCommand(this);
                    taskCreateCommand.execute();
                    break;
                case "project-list":
                    AbstractCommand projectListCommand = new ProjectListCommand(this);
                    projectListCommand.execute();
                    break;
                case "task-list":
                    AbstractCommand taskListCommand = new TaskListCommand(this);
                    taskListCommand.execute();
                    break;
                case "project-delete":
                    AbstractCommand projectDeleteCommand = new ProjectDeleteCommand(this);
                    projectDeleteCommand.execute();
                    break;
                case "task-delete":
                    AbstractCommand taskDeleteCommand = new TaskDeleteCommand(this);
                    taskDeleteCommand.execute();
                    break;
                case "project-update":
                    ProjectUpdateCommand projectUpdateCommand = new ProjectUpdateCommand(this);
                    projectUpdateCommand.execute();
                    break;
                case "task-update":
                    TaskUpdateCommand taskUpdateCommand = new TaskUpdateCommand();
                    taskUpdateCommand.execute();
                    break;
                case "project-open":
                    AbstractCommand projectOpenCommand = new ProjectOpenCommand(this);
                    projectOpenCommand.execute();
                    break;
                case "task-open":
                    AbstractCommand taskOpenCommand = new TaskOpenCommand(this);
                    taskOpenCommand.execute();
                    break;
                case "project-clear":
                    AbstractCommand projectClearCommand = new ProjectClearCommand(this);
                    projectClearCommand.execute();
                    break;
                case "task-clear":
                    AbstractCommand taskClearCommand = new TaskClearCommand(this);
                    taskClearCommand.execute();
                    break;
                case "exit":
                    isCorrect = false;
                    System.out.println("Good bye");
                    break;
                default:
                    System.out.println("!!!Invalid command!!!");
            }
        } while (isCorrect);
    }
}
