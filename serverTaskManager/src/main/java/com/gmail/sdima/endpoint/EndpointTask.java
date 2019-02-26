package com.gmail.sdima.endpoint;

import com.gmail.sdima.dto.TaskDTO;
import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.Session;
import com.gmail.sdima.entity.Task;
import com.gmail.sdima.exception.AccessForbiddenException;
import com.gmail.sdima.service.ProjectService;
import com.gmail.sdima.service.SessionService;
import com.gmail.sdima.service.TaskService;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class EndpointTask  {

    @Inject private TaskService taskService;
    @Inject private ProjectService projectService;
    @Inject private SessionService sessionService;

    @WebMethod
    public void createTask(@WebParam(name = "session") final Session session,
                           @WebParam(name = "task") final TaskDTO task) throws AccessForbiddenException {
        final Project project = projectService.getProjectById(task.getIdByProject());
        sessionService.validateSession(session);
        taskService.addTask(task, project);
    }

    @WebMethod
    public void deleteTask(@WebParam(name = "session") final Session session,
                           @WebParam(name = "idTask") final String idTask) throws AccessForbiddenException {
        sessionService.validateSession(session);
        taskService.deleteTask(idTask);
    }

    @WebMethod
    public List<String> findAllTask(@WebParam(name = "session") final Session session) throws AccessForbiddenException {
        sessionService.validateSession(session);
        return taskService.getTaskByUserId(session);
    }

    @WebMethod
    public List<Task> openTaskByName(@WebParam(name = "session") final Session session,
                                     @WebParam(name = "nameTask") final String nameTask) throws AccessForbiddenException {
        sessionService.validateSession(session);
        return taskService.openTaskByName(nameTask);
    }

    @WebMethod
    public void deleteTaskByIdProjecr(@WebParam(name = "session") final Session session,
                                      @WebParam(name = "idProject") final String idProject) throws AccessForbiddenException {
        sessionService.validateSession(session);
        taskService.deleteTaskByProjectId(idProject); }

    @WebMethod
    public boolean checkTaskListIsEmpty() { return taskService.checkTaskListIsEmpty(); }

    @WebMethod
    public List<String> getTaskByProjectName(@WebParam(name = "session") final Session session,
                                           @WebParam(name = "projectName") final String projectName) throws AccessForbiddenException {
        sessionService.validateSession(session);
        return taskService.getTaskByProjectName(projectName); }
}
