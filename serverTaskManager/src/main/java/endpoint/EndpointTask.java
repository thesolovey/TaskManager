package endpoint;

import api.ServiceLocator;
import entity.Session;
import entity.Task;
import exception.AccessForbiddenException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class EndpointTask  {

    private ServiceLocator serviceLocator;
    public EndpointTask(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    @WebMethod
    public void createTask(final Session session, final Task task) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        serviceLocator.getiTaskService().addTask(task);
    }

    @WebMethod
    public void deleteTask(final Session session, final String idTask) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        serviceLocator.getiTaskService().deleteTask(idTask);
    }

    @WebMethod
    public List<Task> findAllTask(final Session session) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        return serviceLocator.getiTaskService().getTaskByUserId(session);
    }

    @WebMethod
    public List<Task> openTaskByName(final Session session, final String name) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        return serviceLocator.getiTaskService().openTaskByName(name);
    }

    @WebMethod
    public void deleteTaskByIdProjecr(final Session session, final String idProject) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        serviceLocator.getiTaskService().deleteTaskByProjectId(idProject); }

    @WebMethod
    public boolean checkTaskListIsEmpty() { return serviceLocator.getiTaskService().checkTaskListIsEmpty(); }

    @WebMethod
    public List<Task> getTaskByProjectName(final Session session, final String projectName) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        return serviceLocator.getiTaskService().getTaskByProjectName(projectName); }
}
