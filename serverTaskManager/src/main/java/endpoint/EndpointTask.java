package endpoint;

import api.ServiceLocator;
import entity.Session;
import entity.Task;
import exception.AccessForbiddenException;
import repository.ProjectRepository;
import repository.TaskRepository;
import service.TaskService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class EndpointTask  {

    private ServiceLocator serviceLocator;
    public EndpointTask(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    @WebMethod
    public void createTask(Session session, Task task) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        taskService.addTask(task);
    }

    @WebMethod
    public void deleteTask(Session session, String idTask) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        taskService.deleteTask(idTask);
    }

    @WebMethod
    public List<Task> findAllTask(Session session) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        return taskService.getAllTaskFromList();
    }

    @WebMethod
    public List<Task> openTask(Session session, String name) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        return taskService.openTaskByName(name);
    }

    @WebMethod
    public void deleteTaskByIdProjecr(Session session, String idProject) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        taskService.deleteTaskByProjectId(idProject); }

    @WebMethod
    public boolean checkTaskListIsEmpty() { return taskService.checkTaskListIsEmpty(); }

    @WebMethod
    public List<Task> getTaskByProjectName(Session session, String nameProject) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        return taskService.getTaskByProjectName(nameProject); }
}
