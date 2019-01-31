package endpoint;

import entity.Project;
import repository.ProjectRepository;
import repository.TaskRepository;
import service.ProjectService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService
public class ProjectEndPoint {

    private ProjectRepository projectRepository = new ProjectRepository();
    private TaskRepository taskRepository = new TaskRepository();
    private ProjectService projectService = new ProjectService(projectRepository, taskRepository);

    @WebMethod
    public void run() {
        Endpoint.publish("http://localhost:8080/project?wsdl", new ProjectEndPoint());
    }

    @WebMethod
    public void createProject(Project project) {
        projectService.addProjectByList(project);
    }

    @WebMethod
    public void deleteProject(String idProject) {
        projectService.deleteProject(idProject);
    }

    @WebMethod
    public List<Project> findAllProject() {
         return projectService.getAllProjectFromList();
    }

    @WebMethod
    public List<Project> getProjectList() { return projectService.getAllProjectFromList(); }
}
