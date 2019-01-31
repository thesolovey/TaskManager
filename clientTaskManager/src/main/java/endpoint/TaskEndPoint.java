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
 * 2019-01-31T12:46:16.036+03:00
 * Generated source version: 3.2.7
 *
 */
@WebService(targetNamespace = "http://endpoint/", name = "TaskEndPoint")
@XmlSeeAlso({ObjectFactory.class})
public interface TaskEndPoint {

    @WebMethod
    @Action(input = "http://endpoint/TaskEndPoint/createTaskRequest", output = "http://endpoint/TaskEndPoint/createTaskResponse")
    @RequestWrapper(localName = "createTask", targetNamespace = "http://endpoint/", className = "endpoint.CreateTask")
    @ResponseWrapper(localName = "createTaskResponse", targetNamespace = "http://endpoint/", className = "endpoint.CreateTaskResponse")
    public void createTask(
        @WebParam(name = "arg0", targetNamespace = "")
        endpoint.Task arg0
    );

    @WebMethod
    @Action(input = "http://endpoint/TaskEndPoint/deleteTaskRequest", output = "http://endpoint/TaskEndPoint/deleteTaskResponse")
    @RequestWrapper(localName = "deleteTask", targetNamespace = "http://endpoint/", className = "endpoint.DeleteTask")
    @ResponseWrapper(localName = "deleteTaskResponse", targetNamespace = "http://endpoint/", className = "endpoint.DeleteTaskResponse")
    public void deleteTask(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://endpoint/TaskEndPoint/openTaskRequest", output = "http://endpoint/TaskEndPoint/openTaskResponse")
    @RequestWrapper(localName = "openTask", targetNamespace = "http://endpoint/", className = "endpoint.OpenTask")
    @ResponseWrapper(localName = "openTaskResponse", targetNamespace = "http://endpoint/", className = "endpoint.OpenTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<endpoint.Task> openTask(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://endpoint/TaskEndPoint/findAllTaskRequest", output = "http://endpoint/TaskEndPoint/findAllTaskResponse")
    @RequestWrapper(localName = "findAllTask", targetNamespace = "http://endpoint/", className = "endpoint.FindAllTask")
    @ResponseWrapper(localName = "findAllTaskResponse", targetNamespace = "http://endpoint/", className = "endpoint.FindAllTaskResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<endpoint.Task> findAllTask();

    @WebMethod
    @Action(input = "http://endpoint/TaskEndPoint/runRequest", output = "http://endpoint/TaskEndPoint/runResponse")
    @RequestWrapper(localName = "run", targetNamespace = "http://endpoint/", className = "endpoint.Run")
    @ResponseWrapper(localName = "runResponse", targetNamespace = "http://endpoint/", className = "endpoint.RunResponse")
    public void run();
}
