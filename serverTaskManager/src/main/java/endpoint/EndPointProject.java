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
public class EndPointProject {

    private ProjectRepository projectRepository = new ProjectRepository();
    private TaskRepository taskRepository = new TaskRepository();
    private ProjectService projectService = new ProjectService(projectRepository, taskRepository);

    @WebMethod
    public void run() {
        Endpoint.publish("http://localhost:8080/project?wsdl", new EndPointProject());
    }

    @WebMethod
    public void create(Project project) {
        projectService.addProjectByList(project);
    }

    @WebMethod
    public void delete(String idProject) {
        projectService.deleteProject(idProject);
    }

    @WebMethod
    public List<Project> findAll() {
         return projectService.getAllProjectFromList();
    }
}
