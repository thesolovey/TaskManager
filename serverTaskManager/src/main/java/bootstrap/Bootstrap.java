package bootstrap;

import api.*;
import domain.DataBaseConnection;
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
import java.sql.Connection;

public class Bootstrap implements ServiceLocator {

    private Connection connection = new DataBaseConnection().getConnection();

    private ISessionService iSessionService;
    private IUserService iUserService;
    private IProjectService iProjectService;
    private ITaskService iTaskService;

    public IUserService getiUserService() { return userService; }
    public IProjectService getiProjectService() { return projectService; }
    public ITaskService getiTaskService() { return taskService; }
    public ISessionService getiSessionService() { return sessionService; }

    private final UserRepository usersRepository = new UserRepository(connection);
    private final TaskRepository taskRepository = new TaskRepository(connection);
    private final ProjectRepository projectRepository = new ProjectRepository(connection);
    private final SessionRepository sessionRepository = new SessionRepository(connection);

    private final UserService userService = new UserService(usersRepository);
    private final ProjectService projectService = new ProjectService(projectRepository, taskRepository);
    private final TaskService taskService = new TaskService(taskRepository, projectRepository);
    private final SessionService sessionService = new SessionService(sessionRepository);

    private void publishEndpoint() {

        Endpoint.publish("http://localhost:8080/user?wsdl", new EndpointUser(this));
        Endpoint.publish("http://localhost:8080/session?wsdl", new EndpointSession(this));
        Endpoint.publish("http://localhost:8080/project?wsdl", new EndpointProject(this));
        Endpoint.publish("http://localhost:8080/task?wsdl", new EndpointTask(this));
    }

    public void start() {

        publishEndpoint();
        System.out.println("***SERVER RUN***");

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