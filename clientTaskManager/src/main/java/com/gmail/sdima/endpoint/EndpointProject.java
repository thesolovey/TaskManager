package com.gmail.sdima.endpoint;

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
 * 2019-02-26T16:02:26.463+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.sdima.gmail.com/", name = "EndpointProject")
@XmlSeeAlso({ObjectFactory.class})
public interface EndpointProject {

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointProject/checkProjectListIsEmptyRequest", output = "http://endpoint.sdima.gmail.com/EndpointProject/checkProjectListIsEmptyResponse")
    @RequestWrapper(localName = "checkProjectListIsEmpty", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.CheckProjectListIsEmpty")
    @ResponseWrapper(localName = "checkProjectListIsEmptyResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.CheckProjectListIsEmptyResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean checkProjectListIsEmpty();

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointProject/createProjectRequest", output = "http://endpoint.sdima.gmail.com/EndpointProject/createProjectResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.sdima.gmail.com/EndpointProject/createProject/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "createProject", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.CreateProject")
    @ResponseWrapper(localName = "createProjectResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.CreateProjectResponse")
    public void createProject(
        @WebParam(name = "session", targetNamespace = "")
        com.gmail.sdima.endpoint.Session session,
        @WebParam(name = "project", targetNamespace = "")
        com.gmail.sdima.endpoint.Project project
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointProject/deleteProjectRequest", output = "http://endpoint.sdima.gmail.com/EndpointProject/deleteProjectResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.sdima.gmail.com/EndpointProject/deleteProject/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "deleteProject", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.DeleteProject")
    @ResponseWrapper(localName = "deleteProjectResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.DeleteProjectResponse")
    public void deleteProject(
        @WebParam(name = "session", targetNamespace = "")
        com.gmail.sdima.endpoint.Session session,
        @WebParam(name = "idProject", targetNamespace = "")
        java.lang.String idProject
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointProject/getProjectByUserIdRequest", output = "http://endpoint.sdima.gmail.com/EndpointProject/getProjectByUserIdResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.sdima.gmail.com/EndpointProject/getProjectByUserId/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "getProjectByUserId", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.GetProjectByUserId")
    @ResponseWrapper(localName = "getProjectByUserIdResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.GetProjectByUserIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.gmail.sdima.endpoint.Project> getProjectByUserId(
        @WebParam(name = "session", targetNamespace = "")
        com.gmail.sdima.endpoint.Session session
    ) throws AccessForbiddenException_Exception;
}
