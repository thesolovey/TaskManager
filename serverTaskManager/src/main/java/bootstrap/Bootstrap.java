package bootstrap;

import api.*;
import command.AbstractCommand;
import command.user.UserAdminCreateCommand;
import command.user.UserTestCreateCommand;
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

    private final UserRepository usersRepository = new UserRepository();
    private final TaskRepository taskRepository = new TaskRepository();
    private final ProjectRepository projectRepository = new ProjectRepository();
    private final SessionRepository sessionRepository = new SessionRepository();

    private final UserService userService = new UserService(usersRepository);
    private final ProjectService projectService = new ProjectService(projectRepository, taskRepository);
    private final TaskService taskService = new TaskService(taskRepository);
    private final SessionService sessionService = new SessionService(sessionRepository);

    private void publishEndpoint() {
        Endpoint.publish("http://localhost:8080/user?wsdl", new EndpointUser(this));
        Endpoint.publish("http://localhost:8080/session?wsdl", new EndpointSession(this));
        Endpoint.publish("http://localhost:8080/project?wsdl", new EndpointProject(this));
        Endpoint.publish("http://localhost:8080/task?wsdl", new EndpointTask(this));
    }

    public void start() {
        publishEndpoint();
        final AbstractCommand adminCreate = new UserAdminCreateCommand(this);
        adminCreate.execute();
        final AbstractCommand testCreate = new UserTestCreateCommand(this);
        testCreate.execute();
        System.out.println("***SERVER RUN***");
        do { } while (true);
    }
 }