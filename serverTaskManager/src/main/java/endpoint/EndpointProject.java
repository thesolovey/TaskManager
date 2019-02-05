package endpoint;

import api.ServiceLocator;
import entity.Project;
import entity.Session;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class EndpointProject {

    private ServiceLocator serviceLocator;
    public EndpointProject(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    @WebMethod
    public void createProject (Session session,Project project) {
        serviceLocator.getiSessionService().validateSession(session);
        serviceLocator.getiProjectService().addProjectByList(project);
    }

    @WebMethod
    public void deleteProject(Session session, String idProject) {
        serviceLocator.getiSessionService().validateSession(session);
        serviceLocator.getiProjectService().deleteProject(idProject);
    }

    @WebMethod
    public List<Project> findAllProject(Session session) {
        serviceLocator.getiSessionService().validateSession(session);
        return serviceLocator.getiProjectService().getAllProjectFromList();
    }

    @WebMethod
    public boolean checkProjectListIsEmpty() { return serviceLocator.getiProjectService().checkProjectListIsEmpty(); }

//    @WebMethod
//    public void clearAllProjectList() { projectService.clearAllProject(); }
}
