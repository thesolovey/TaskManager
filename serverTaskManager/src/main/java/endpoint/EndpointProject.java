package endpoint;

import api.ServiceLocator;
import entity.Project;
import entity.Session;
import exception.AccessForbiddenException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class EndpointProject {

    private ServiceLocator serviceLocator;
    public EndpointProject(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    @WebMethod
    public void createProject (Session session,Project project) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        serviceLocator.getiProjectService().addProjectByList(project);
    }

    @WebMethod
    public void deleteProject(Session session, String idProject) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        serviceLocator.getiProjectService().deleteProject(idProject);
    }

    @WebMethod
    public List<Project> getProjectByUserId(Session session) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        return serviceLocator.getiProjectService().getProjectByUserId(session);
    }

    @WebMethod
    public boolean checkProjectListIsEmpty() { return serviceLocator.getiProjectService().checkProjectListIsEmpty(); }

    @WebMethod
    public void clearAllProjectList(Session session) throws AccessForbiddenException {
        serviceLocator.getiSessionService().validateSession(session);
        serviceLocator.getiProjectService().clearAllProject(session); }
}
