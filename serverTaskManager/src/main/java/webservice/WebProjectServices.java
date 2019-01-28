package webservice;

import entity.Project;
import service.ProjectService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "com.gmail.sdima.webservice.WebProjectServices")
public class WebProjectServices {

    @WebMethod
    public void createProject(Project project) {
        ProjectService projectService = null;
        try {
            projectService.addProjectByList(project);
        } catch (NullPointerException e) {e.printStackTrace();}
    }

    @WebMethod
    public void deleteProject(Project project) {

    }

    @WebMethod
    public void openProject(Project project) {

    }

    @WebMethod
    public void findAll() {

    }
}
