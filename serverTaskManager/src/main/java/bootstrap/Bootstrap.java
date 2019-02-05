package bootstrap;

import api.*;
import endpoint.EndpointProject;
import endpoint.EndpointSession;
import endpoint.EndpointTask;
import endpoint.EndpointUser;
import repository.ProjectRepository;
import repository.SessionRepository;
import repository.TaskRepository;
import repository.UserRepository;
import service.ProjectService;
import service.SessionService;
import service.TaskService;
import service.UserService;

import javax.xml.ws.Endpoint;

public class Bootstrap implements ServiceLocator {

    private ISessionService iSessionService;
    private IUserService iUserService;
    private IProjectService iProjectService;
    private ITaskService iTaskService;

    public IUserService getiUserService() { return userService; }
    public IProjectService getiProjectService() { return projectService; }
    public ITaskService getiTaskService() { return taskService; }
    public ISessionService getiSessionService() { return sessionService; }

    final private UserRepository usersRepository = new UserRepository();
    final private TaskRepository taskRepository = new TaskRepository();
    final private ProjectRepository projectRepository = new ProjectRepository();
    final private SessionRepository sessionRepository = new SessionRepository();

    private UserService userService = new UserService(usersRepository);
    private ProjectService projectService = new ProjectService(projectRepository, taskRepository);
    private TaskService taskService = new TaskService(taskRepository, projectRepository);
    private SessionService sessionService = new SessionService(sessionRepository);

    private void publishEndpoint() {

        Endpoint.publish("http://localhost:8080/user?wsdl", new EndpointUser(this));
        Endpoint.publish("http://localhost:8080/session?wsdl", new EndpointSession());
        Endpoint.publish("http://localhost:8080/project?wsdl", new EndpointProject(this));
        Endpoint.publish("http://localhost:8080/task?wsdl", new EndpointTask(this));
    }

    public void start() {

        publishEndpoint();
        System.out.println("***WELLCOME TO TASK MANAGER***");

        do {
//            String commandFromConsole = ReadFromConsole.readInputFromConsole("Input command: ");
//            AbstractCommand command = commands.get(commandFromConsole);
//
//            if (command == null) continue;
//            if (command.secure() && !this.getiUserService().isAuth()) continue;
//                command.execute();
        } while (true);
    }
}