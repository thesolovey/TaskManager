package endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-02-20T16:07:37.398+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint/", name = "EndpointProject")
@XmlSeeAlso({ObjectFactory.class})
public interface EndpointProject {

    @WebMethod
    @Action(input = "http://endpoint/EndpointProject/getProjectByUserIdRequest", output = "http://endpoint/EndpointProject/getProjectByUserIdResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint/EndpointProject/getProjectByUserId/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "getProjectByUserId", targetNamespace = "http://endpoint/", className = "endpoint.GetProjectByUserId")
    @ResponseWrapper(localName = "getProjectByUserIdResponse", targetNamespace = "http://endpoint/", className = "endpoint.GetProjectByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<endpoint.Project> getProjectByUserId(
        @WebParam(name = "session", targetNamespace = "")
        endpoint.Session session
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint/EndpointProject/deleteProjectRequest", output = "http://endpoint/EndpointProject/deleteProjectResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint/EndpointProject/deleteProject/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "deleteProject", targetNamespace = "http://endpoint/", className = "endpoint.DeleteProject")
    @ResponseWrapper(localName = "deleteProjectResponse", targetNamespace = "http://endpoint/", className = "endpoint.DeleteProjectResponse")
    public void deleteProject(
        @WebParam(name = "session", targetNamespace = "")
        endpoint.Session session,
        @WebParam(name = "idProject", targetNamespace = "")
        java.lang.String idProject
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint/EndpointProject/checkProjectListIsEmptyRequest", output = "http://endpoint/EndpointProject/checkProjectListIsEmptyResponse")
    @RequestWrapper(localName = "checkProjectListIsEmpty", targetNamespace = "http://endpoint/", className = "endpoint.CheckProjectListIsEmpty")
    @ResponseWrapper(localName = "checkProjectListIsEmptyResponse", targetNamespace = "http://endpoint/", className = "endpoint.CheckProjectListIsEmptyResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean checkProjectListIsEmpty();

    @WebMethod
    @Action(input = "http://endpoint/EndpointProject/createProjectRequest", output = "http://endpoint/EndpointProject/createProjectResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint/EndpointProject/createProject/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "createProject", targetNamespace = "http://endpoint/", className = "endpoint.CreateProject")
    @ResponseWrapper(localName = "createProjectResponse", targetNamespace = "http://endpoint/", className = "endpoint.CreateProjectResponse")
    public void createProject(
        @WebParam(name = "session", targetNamespace = "")
        endpoint.Session session,
        @WebParam(name = "project", targetNamespace = "")
        endpoint.Project project
    ) throws AccessForbiddenException_Exception;
}
