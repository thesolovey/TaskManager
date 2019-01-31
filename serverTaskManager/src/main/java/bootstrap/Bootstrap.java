package bootstrap;

import api.ServiceLocator;
import endpoint.ProjectEndPoint;
import endpoint.SessionEndPoint;
import endpoint.TaskEndPoint;
import endpoint.UserEndPoint;
import repository.ProjectRepository;
import repository.SessionRepository;
import repository.TaskRepository;
import repository.UserRepository;
import service.ProjectService;
import service.SessionService;
import service.TaskService;
import service.UserService;

public class Bootstrap implements ServiceLocator {

    private final UserEndPoint userEndPoint = new UserEndPoint();
    private final ProjectEndPoint projectEndPoint = new ProjectEndPoint();
    private final TaskEndPoint taskEndPoint = new TaskEndPoint();
    private final SessionEndPoint sessionEndPoint = new SessionEndPoint();

    private final UserRepository usersRepository = new UserRepository();
    private final TaskRepository taskRepository = new TaskRepository();
    private final ProjectRepository projectRepository = new ProjectRepository();
    private final SessionRepository sessionRepository = new SessionRepository();

    private final UserService userService = new UserService(usersRepository);
    private final ProjectService projectService = new ProjectService(projectRepository, taskRepository);
    private final TaskService taskService = new TaskService(taskRepository, projectRepository);
    private final SessionService sessionService = new SessionService(sessionRepository);

    public UserService getUserService() { return userService; }

    public ProjectService getProjectService() { return projectService; }

    public TaskService getTaskService() { return taskService; }

    public SessionService getSessionService() { return sessionService; }

    public void start() {

        userEndPoint.run();
        projectEndPoint.run();
        taskEndPoint.run();
        sessionEndPoint.run();

        System.out.println("***WELLCOME TO TASK MANAGER***");

        do {
//            String commandFromConsole = ReadFromConsole.readInputFromConsole("Input command: ");
//            AbstractCommand command = commands.get(commandFromConsole);
//
//            if (command == null) continue;
//            if (command.secure() && !this.getUserService().isAuth()) continue;
//                command.execute();
        } while (true);
    }
}