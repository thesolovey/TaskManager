package endpoint;

import api.ServiceLocator;
import entity.Project;
import entity.Session;
import repository.ProjectRepository;
import repository.TaskRepository;
import service.ProjectService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class EndpointProject {

    private ServiceLocator serviceLocator;
    public EndpointProject(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    private ProjectRepository projectRepository = new ProjectRepository();
    private TaskRepository taskRepository = new TaskRepository();
    private ProjectService projectService = new ProjectService(projectRepository, taskRepository);

    @WebMethod
    public void createProject (Session session,Project project) {
        serviceLocator.getSessionService().invalidSession(session);
        projectService.addProjectByList(project);
    }

    @WebMethod
    public void deleteProject(String idProject) {
        projectService.deleteProject(idProject);
    }

    @WebMethod
    public List<Project> findAllProject(Session session) {
        if (serviceLocator.getSessionService().invalidSession(session)) { return null; }
        return projectService.getAllProjectFromList();
    }

    @WebMethod
    public boolean checkProjectListIsEmpty() { return projectService.checkProjectListIsEmty(); }

    @WebMethod
    public void clearAllProjectList() { projectService.clearAllProject(); }
}
