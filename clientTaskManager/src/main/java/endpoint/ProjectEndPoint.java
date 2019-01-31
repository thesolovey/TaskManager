package endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-01-31T12:46:15.742+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint/", name = "ProjectEndPoint")
@XmlSeeAlso({ObjectFactory.class})
public interface ProjectEndPoint {

    @WebMethod
    @Action(input = "http://endpoint/ProjectEndPoint/deleteProjectRequest", output = "http://endpoint/ProjectEndPoint/deleteProjectResponse")
    @RequestWrapper(localName = "deleteProject", targetNamespace = "http://endpoint/", className = "endpoint.DeleteProject")
    @ResponseWrapper(localName = "deleteProjectResponse", targetNamespace = "http://endpoint/", className = "endpoint.DeleteProjectResponse")
    public void deleteProject(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://endpoint/ProjectEndPoint/getProjectListRequest", output = "http://endpoint/ProjectEndPoint/getProjectListResponse")
    @RequestWrapper(localName = "getProjectList", targetNamespace = "http://endpoint/", className = "endpoint.GetProjectList")
    @ResponseWrapper(localName = "getProjectListResponse", targetNamespace = "http://endpoint/", className = "endpoint.GetProjectListResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<endpoint.Project> getProjectList();

    @WebMethod
    @Action(input = "http://endpoint/ProjectEndPoint/runRequest", output = "http://endpoint/ProjectEndPoint/runResponse")
    @RequestWrapper(localName = "run", targetNamespace = "http://endpoint/", className = "endpoint.Run")
    @ResponseWrapper(localName = "runResponse", targetNamespace = "http://endpoint/", className = "endpoint.RunResponse")
    public void run();

    @WebMethod
    @Action(input = "http://endpoint/ProjectEndPoint/createProjectRequest", output = "http://endpoint/ProjectEndPoint/createProjectResponse")
    @RequestWrapper(localName = "createProject", targetNamespace = "http://endpoint/", className = "endpoint.CreateProject")
    @ResponseWrapper(localName = "createProjectResponse", targetNamespace = "http://endpoint/", className = "endpoint.CreateProjectResponse")
    public void createProject(
        @WebParam(name = "arg0", targetNamespace = "")
        endpoint.Project arg0
    );

    @WebMethod
    @Action(input = "http://endpoint/ProjectEndPoint/findAllProjectRequest", output = "http://endpoint/ProjectEndPoint/findAllProjectResponse")
    @RequestWrapper(localName = "findAllProject", targetNamespace = "http://endpoint/", className = "endpoint.FindAllProject")
    @ResponseWrapper(localName = "findAllProjectResponse", targetNamespace = "http://endpoint/", className = "endpoint.FindAllProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<endpoint.Project> findAllProject();
}
