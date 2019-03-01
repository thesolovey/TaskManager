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
 * 2019-03-01T11:40:32.070+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint.sdima.gmail.com/", name = "EndpointTask")
@XmlSeeAlso({ObjectFactory.class})
public interface EndpointTask {

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointTask/getTaskByProjectNameRequest", output = "http://endpoint.sdima.gmail.com/EndpointTask/getTaskByProjectNameResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.sdima.gmail.com/EndpointTask/getTaskByProjectName/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "getTaskByProjectName", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.GetTaskByProjectName")
    @ResponseWrapper(localName = "getTaskByProjectNameResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.GetTaskByProjectNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<java.lang.String> getTaskByProjectName(
        @WebParam(name = "session", targetNamespace = "")
        com.gmail.sdima.endpoint.Session session,
        @WebParam(name = "projectName", targetNamespace = "")
        java.lang.String projectName
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointTask/deleteTaskByIdProjecrRequest", output = "http://endpoint.sdima.gmail.com/EndpointTask/deleteTaskByIdProjecrResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.sdima.gmail.com/EndpointTask/deleteTaskByIdProjecr/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "deleteTaskByIdProjecr", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.DeleteTaskByIdProjecr")
    @ResponseWrapper(localName = "deleteTaskByIdProjecrResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.DeleteTaskByIdProjecrResponse")
    public void deleteTaskByIdProjecr(
        @WebParam(name = "session", targetNamespace = "")
        com.gmail.sdima.endpoint.Session session,
        @WebParam(name = "idProject", targetNamespace = "")
        java.lang.String idProject
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointTask/findAllTaskRequest", output = "http://endpoint.sdima.gmail.com/EndpointTask/findAllTaskResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.sdima.gmail.com/EndpointTask/findAllTask/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "findAllTask", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.FindAllTask")
    @ResponseWrapper(localName = "findAllTaskResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.FindAllTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<java.lang.String> findAllTask(
        @WebParam(name = "session", targetNamespace = "")
        com.gmail.sdima.endpoint.Session session
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointTask/createTaskRequest", output = "http://endpoint.sdima.gmail.com/EndpointTask/createTaskResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.sdima.gmail.com/EndpointTask/createTask/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "createTask", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.CreateTask")
    @ResponseWrapper(localName = "createTaskResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.CreateTaskResponse")
    public void createTask(
        @WebParam(name = "session", targetNamespace = "")
        com.gmail.sdima.endpoint.Session session,
        @WebParam(name = "task", targetNamespace = "")
        com.gmail.sdima.endpoint.TaskDTO task
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointTask/deleteTaskRequest", output = "http://endpoint.sdima.gmail.com/EndpointTask/deleteTaskResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.sdima.gmail.com/EndpointTask/deleteTask/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "deleteTask", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.DeleteTask")
    @ResponseWrapper(localName = "deleteTaskResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.DeleteTaskResponse")
    public void deleteTask(
        @WebParam(name = "session", targetNamespace = "")
        com.gmail.sdima.endpoint.Session session,
        @WebParam(name = "idTask", targetNamespace = "")
        java.lang.String idTask
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointTask/openTaskByNameRequest", output = "http://endpoint.sdima.gmail.com/EndpointTask/openTaskByNameResponse", fault = {@FaultAction(className = AccessForbiddenException_Exception.class, value = "http://endpoint.sdima.gmail.com/EndpointTask/openTaskByName/Fault/AccessForbiddenException")})
    @RequestWrapper(localName = "openTaskByName", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.OpenTaskByName")
    @ResponseWrapper(localName = "openTaskByNameResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.OpenTaskByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.gmail.sdima.endpoint.Task> openTaskByName(
        @WebParam(name = "session", targetNamespace = "")
        com.gmail.sdima.endpoint.Session session,
        @WebParam(name = "nameTask", targetNamespace = "")
        java.lang.String nameTask
    ) throws AccessForbiddenException_Exception;

    @WebMethod
    @Action(input = "http://endpoint.sdima.gmail.com/EndpointTask/checkTaskListIsEmptyRequest", output = "http://endpoint.sdima.gmail.com/EndpointTask/checkTaskListIsEmptyResponse")
    @RequestWrapper(localName = "checkTaskListIsEmpty", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.CheckTaskListIsEmpty")
    @ResponseWrapper(localName = "checkTaskListIsEmptyResponse", targetNamespace = "http://endpoint.sdima.gmail.com/", className = "com.gmail.sdima.endpoint.CheckTaskListIsEmptyResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean checkTaskListIsEmpty();
}
