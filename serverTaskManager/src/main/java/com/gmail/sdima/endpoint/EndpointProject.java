package com.gmail.sdima.endpoint;

import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.Session;
import com.gmail.sdima.exception.AccessForbiddenException;
import com.gmail.sdima.service.ProjectService;
import com.gmail.sdima.service.SessionService;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class EndpointProject {

    @Inject private ProjectService projectService;
    @Inject private SessionService sessionService;

    @WebMethod
    public void createProject (@WebParam(name = "session") final Session session,
                               @WebParam(name = "project") final Project project) throws AccessForbiddenException {
        sessionService.validateSession(session);
        projectService.addProjectByList(project);
    }

    @WebMethod
    public void deleteProject(@WebParam(name = "session") final Session session,
                              @WebParam(name = "idProject") final String idProject) throws AccessForbiddenException {
        sessionService.validateSession(session);
        projectService.deleteProject(idProject);
    }

    @WebMethod
    public List<Project> getProjectByUserId(@WebParam(name = "session") final Session session) throws AccessForbiddenException {
        sessionService.validateSession(session);
        return projectService.getProjectByUserId(session);
    }

    @WebMethod
    public boolean checkProjectListIsEmpty() { return projectService.checkProjectListIsEmpty(); }
}
