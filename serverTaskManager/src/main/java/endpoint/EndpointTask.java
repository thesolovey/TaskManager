package endpoint;

import api.ServiceLocator;
import dto.TaskDTO;
import entity.Project;
import entity.Session;
import entity.Task;
import exception.AccessForbiddenException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class EndpointTask  {
    private ServiceLocator serviceLocator;
    public EndpointTask(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    @WebMethod
    public void createTask(@WebParam(name = "session") final Session session,
                           @WebParam(name = "task") final TaskDTO task) throws AccessForbiddenException {
        final Project project = serviceLocator.getiProjectService().getProjectById(task.getIdByProject());
        serviceLocator.getiSessionService().validateSession(session);
        serviceLocator.getiTaskService().addTask(task, project);
    }

    @WebMethod
    public void deleteTask(@WebParam(name = "session") final Session session,
                           @WebParam(name = "idTask") final String idTask) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        serviceLocator.getiTaskService().deleteTask(idTask);
    }

    @WebMethod
    public List<String> findAllTask(@WebParam(name = "session") final Session session) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        return serviceLocator.getiTaskService().getTaskByUserId(session);
    }

    @WebMethod
    public List<Task> openTaskByName(@WebParam(name = "session") final Session session,
                                     @WebParam(name = "nameTask") final String nameTask) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        return serviceLocator.getiTaskService().openTaskByName(nameTask);
    }

    @WebMethod
    public void deleteTaskByIdProjecr(@WebParam(name = "session") final Session session,
                                      @WebParam(name = "idProject") final String idProject) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        serviceLocator.getiTaskService().deleteTaskByProjectId(idProject); }

    @WebMethod
    public boolean checkTaskListIsEmpty() { return serviceLocator.getiTaskService().checkTaskListIsEmpty(); }

    @WebMethod
    public List<String> getTaskByProjectName(@WebParam(name = "session") final Session session,
                                           @WebParam(name = "projectName") final String projectName) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        return serviceLocator.getiTaskService().getTaskByProjectName(projectName); }
}
