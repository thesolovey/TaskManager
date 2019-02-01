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

    private ISessionService sessionService;
    private IUserService userService;
    private IProjectServise projectServise;
    private ITaskService taskService;

    private final EndpointUser endpointUser = new EndpointUser(this);
    private final EndpointProject endpointProject = new EndpointProject(this);
    private final EndpointTask endpointTask = new EndpointTask(this);
    private final EndpointSession endpointSession = new EndpointSession();

//    private final UserRepository usersRepository = new UserRepository();
//    private final TaskRepository taskRepository = new TaskRepository();
//    private final ProjectRepository projectRepository = new ProjectRepository();
//    private final SessionRepository sessionRepository = new SessionRepository();

//    private final UserService userService = new UserService(usersRepository);
//    private final ProjectService projectService = new ProjectService(projectRepository, taskRepository);
//    private final TaskService taskService = new TaskService(taskRepository, projectRepository);
//    private final SessionService sessionService = new SessionService(sessionRepository);

    public IUserService getUserService() { return userService; }

    public IProjectServise getProjectService() { return projectServise; }

    public ITaskService getTaskService() { return taskService; }

    public ISessionService getSessionService() { return sessionService; }

    private void publishEndpoint() {
        Endpoint.publish("http://localhost:8080/user?wsdl", new EndpointUser(this));
        Endpoint.publish("http://localhost:8080/session?wsdl", new EndpointSession());
        Endpoint.publish("http://localhost:8080/project?wsdl", new EndpointProject(this));
        Endpoint.publish("http://localhost:8080/task?wsdl", new EndpointTask(this));

    }

    public void start() {

        final UserRepository usersRepository = new UserRepository();
        final TaskRepository taskRepository = new TaskRepository();
        final ProjectRepository projectRepository = new ProjectRepository();
        final SessionRepository sessionRepository = new SessionRepository();

        UserService userService = new UserService(usersRepository);
        ProjectService projectService = new ProjectService(projectRepository, taskRepository);
        TaskService taskService = new TaskService(taskRepository, projectRepository);
        SessionService sessionService = new SessionService(sessionRepository);

        publishEndpoint();
//        Session session = getSessionService().getCurrentSession();
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