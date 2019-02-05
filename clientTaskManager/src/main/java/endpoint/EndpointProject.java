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
 * 2019-02-05T16:45:42.751+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint/", name = "EndpointProject")
@XmlSeeAlso({ObjectFactory.class})
public interface EndpointProject {

    @WebMethod
    @Action(input = "http://endpoint/EndpointProject/deleteProjectRequest", output = "http://endpoint/EndpointProject/deleteProjectResponse")
    @RequestWrapper(localName = "deleteProject", targetNamespace = "http://endpoint/", className = "endpoint.DeleteProject")
    @ResponseWrapper(localName = "deleteProjectResponse", targetNamespace = "http://endpoint/", className = "endpoint.DeleteProjectResponse")
    public void deleteProject(
        @WebParam(name = "arg0", targetNamespace = "")
        endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://endpoint/EndpointProject/checkProjectListIsEmptyRequest", output = "http://endpoint/EndpointProject/checkProjectListIsEmptyResponse")
    @RequestWrapper(localName = "checkProjectListIsEmpty", targetNamespace = "http://endpoint/", className = "endpoint.CheckProjectListIsEmpty")
    @ResponseWrapper(localName = "checkProjectListIsEmptyResponse", targetNamespace = "http://endpoint/", className = "endpoint.CheckProjectListIsEmptyResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean checkProjectListIsEmpty();

    @WebMethod
    @Action(input = "http://endpoint/EndpointProject/findAllProjectRequest", output = "http://endpoint/EndpointProject/findAllProjectResponse")
    @RequestWrapper(localName = "findAllProject", targetNamespace = "http://endpoint/", className = "endpoint.FindAllProject")
    @ResponseWrapper(localName = "findAllProjectResponse", targetNamespace = "http://endpoint/", className = "endpoint.FindAllProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<endpoint.Project> findAllProject(
        @WebParam(name = "arg0", targetNamespace = "")
        endpoint.Session arg0
    );

    @WebMethod
    @Action(input = "http://endpoint/EndpointProject/createProjectRequest", output = "http://endpoint/EndpointProject/createProjectResponse")
    @RequestWrapper(localName = "createProject", targetNamespace = "http://endpoint/", className = "endpoint.CreateProject")
    @ResponseWrapper(localName = "createProjectResponse", targetNamespace = "http://endpoint/", className = "endpoint.CreateProjectResponse")
    public void createProject(
        @WebParam(name = "arg0", targetNamespace = "")
        endpoint.Session arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        endpoint.Project arg1
    );
}
