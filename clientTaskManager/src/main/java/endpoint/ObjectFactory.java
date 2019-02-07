
package endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the endpoint package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AccessForbiddenException_QNAME = new QName("http://endpoint/", "AccessForbiddenException");
    private final static QName _CheckTaskListIsEmpty_QNAME = new QName("http://endpoint/", "checkTaskListIsEmpty");
    private final static QName _CheckTaskListIsEmptyResponse_QNAME = new QName("http://endpoint/", "checkTaskListIsEmptyResponse");
    private final static QName _CreateTask_QNAME = new QName("http://endpoint/", "createTask");
    private final static QName _CreateTaskResponse_QNAME = new QName("http://endpoint/", "createTaskResponse");
    private final static QName _DeleteTask_QNAME = new QName("http://endpoint/", "deleteTask");
    private final static QName _DeleteTaskByIdProjecr_QNAME = new QName("http://endpoint/", "deleteTaskByIdProjecr");
    private final static QName _DeleteTaskByIdProjecrResponse_QNAME = new QName("http://endpoint/", "deleteTaskByIdProjecrResponse");
    private final static QName _DeleteTaskResponse_QNAME = new QName("http://endpoint/", "deleteTaskResponse");
    private final static QName _FindAllTask_QNAME = new QName("http://endpoint/", "findAllTask");
    private final static QName _FindAllTaskResponse_QNAME = new QName("http://endpoint/", "findAllTaskResponse");
    private final static QName _GetTaskByProjectName_QNAME = new QName("http://endpoint/", "getTaskByProjectName");
    private final static QName _GetTaskByProjectNameResponse_QNAME = new QName("http://endpoint/", "getTaskByProjectNameResponse");
    private final static QName _OpenTaskByName_QNAME = new QName("http://endpoint/", "openTaskByName");
    private final static QName _OpenTaskByNameResponse_QNAME = new QName("http://endpoint/", "openTaskByNameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: endpoint
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AccessForbiddenException }
     * 
     */
    public AccessForbiddenException createAccessForbiddenException() {
        return new AccessForbiddenException();
    }

    /**
     * Create an instance of {@link CheckTaskListIsEmpty }
     * 
     */
    public CheckTaskListIsEmpty createCheckTaskListIsEmpty() {
        return new CheckTaskListIsEmpty();
    }

    /**
     * Create an instance of {@link CheckTaskListIsEmptyResponse }
     * 
     */
    public CheckTaskListIsEmptyResponse createCheckTaskListIsEmptyResponse() {
        return new CheckTaskListIsEmptyResponse();
    }

    /**
     * Create an instance of {@link CreateTask }
     * 
     */
    public CreateTask createCreateTask() {
        return new CreateTask();
    }

    /**
     * Create an instance of {@link CreateTaskResponse }
     * 
     */
    public CreateTaskResponse createCreateTaskResponse() {
        return new CreateTaskResponse();
    }

    /**
     * Create an instance of {@link DeleteTask }
     * 
     */
    public DeleteTask createDeleteTask() {
        return new DeleteTask();
    }

    /**
     * Create an instance of {@link DeleteTaskByIdProjecr }
     * 
     */
    public DeleteTaskByIdProjecr createDeleteTaskByIdProjecr() {
        return new DeleteTaskByIdProjecr();
    }

    /**
     * Create an instance of {@link DeleteTaskByIdProjecrResponse }
     * 
     */
    public DeleteTaskByIdProjecrResponse createDeleteTaskByIdProjecrResponse() {
        return new DeleteTaskByIdProjecrResponse();
    }

    /**
     * Create an instance of {@link DeleteTaskResponse }
     * 
     */
    public DeleteTaskResponse createDeleteTaskResponse() {
        return new DeleteTaskResponse();
    }

    /**
     * Create an instance of {@link FindAllTask }
     * 
     */
    public FindAllTask createFindAllTask() {
        return new FindAllTask();
    }

    /**
     * Create an instance of {@link FindAllTaskResponse }
     * 
     */
    public FindAllTaskResponse createFindAllTaskResponse() {
        return new FindAllTaskResponse();
    }

    /**
     * Create an instance of {@link GetTaskByProjectName }
     * 
     */
    public GetTaskByProjectName createGetTaskByProjectName() {
        return new GetTaskByProjectName();
    }

    /**
     * Create an instance of {@link GetTaskByProjectNameResponse }
     * 
     */
    public GetTaskByProjectNameResponse createGetTaskByProjectNameResponse() {
        return new GetTaskByProjectNameResponse();
    }

    /**
     * Create an instance of {@link OpenTaskByName }
     * 
     */
    public OpenTaskByName createOpenTaskByName() {
        return new OpenTaskByName();
    }

    /**
     * Create an instance of {@link OpenTaskByNameResponse }
     * 
     */
    public OpenTaskByNameResponse createOpenTaskByNameResponse() {
        return new OpenTaskByNameResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link Task }
     * 
     */
    public Task createTask() {
        return new Task();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccessForbiddenException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "AccessForbiddenException")
    public JAXBElement<AccessForbiddenException> createAccessForbiddenException(AccessForbiddenException value) {
        return new JAXBElement<AccessForbiddenException>(_AccessForbiddenException_QNAME, AccessForbiddenException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckTaskListIsEmpty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "checkTaskListIsEmpty")
    public JAXBElement<CheckTaskListIsEmpty> createCheckTaskListIsEmpty(CheckTaskListIsEmpty value) {
        return new JAXBElement<CheckTaskListIsEmpty>(_CheckTaskListIsEmpty_QNAME, CheckTaskListIsEmpty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckTaskListIsEmptyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "checkTaskListIsEmptyResponse")
    public JAXBElement<CheckTaskListIsEmptyResponse> createCheckTaskListIsEmptyResponse(CheckTaskListIsEmptyResponse value) {
        return new JAXBElement<CheckTaskListIsEmptyResponse>(_CheckTaskListIsEmptyResponse_QNAME, CheckTaskListIsEmptyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "createTask")
    public JAXBElement<CreateTask> createCreateTask(CreateTask value) {
        return new JAXBElement<CreateTask>(_CreateTask_QNAME, CreateTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "createTaskResponse")
    public JAXBElement<CreateTaskResponse> createCreateTaskResponse(CreateTaskResponse value) {
        return new JAXBElement<CreateTaskResponse>(_CreateTaskResponse_QNAME, CreateTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "deleteTask")
    public JAXBElement<DeleteTask> createDeleteTask(DeleteTask value) {
        return new JAXBElement<DeleteTask>(_DeleteTask_QNAME, DeleteTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTaskByIdProjecr }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "deleteTaskByIdProjecr")
    public JAXBElement<DeleteTaskByIdProjecr> createDeleteTaskByIdProjecr(DeleteTaskByIdProjecr value) {
        return new JAXBElement<DeleteTaskByIdProjecr>(_DeleteTaskByIdProjecr_QNAME, DeleteTaskByIdProjecr.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTaskByIdProjecrResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "deleteTaskByIdProjecrResponse")
    public JAXBElement<DeleteTaskByIdProjecrResponse> createDeleteTaskByIdProjecrResponse(DeleteTaskByIdProjecrResponse value) {
        return new JAXBElement<DeleteTaskByIdProjecrResponse>(_DeleteTaskByIdProjecrResponse_QNAME, DeleteTaskByIdProjecrResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "deleteTaskResponse")
    public JAXBElement<DeleteTaskResponse> createDeleteTaskResponse(DeleteTaskResponse value) {
        return new JAXBElement<DeleteTaskResponse>(_DeleteTaskResponse_QNAME, DeleteTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "findAllTask")
    public JAXBElement<FindAllTask> createFindAllTask(FindAllTask value) {
        return new JAXBElement<FindAllTask>(_FindAllTask_QNAME, FindAllTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "findAllTaskResponse")
    public JAXBElement<FindAllTaskResponse> createFindAllTaskResponse(FindAllTaskResponse value) {
        return new JAXBElement<FindAllTaskResponse>(_FindAllTaskResponse_QNAME, FindAllTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTaskByProjectName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "getTaskByProjectName")
    public JAXBElement<GetTaskByProjectName> createGetTaskByProjectName(GetTaskByProjectName value) {
        return new JAXBElement<GetTaskByProjectName>(_GetTaskByProjectName_QNAME, GetTaskByProjectName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTaskByProjectNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "getTaskByProjectNameResponse")
    public JAXBElement<GetTaskByProjectNameResponse> createGetTaskByProjectNameResponse(GetTaskByProjectNameResponse value) {
        return new JAXBElement<GetTaskByProjectNameResponse>(_GetTaskByProjectNameResponse_QNAME, GetTaskByProjectNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenTaskByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "openTaskByName")
    public JAXBElement<OpenTaskByName> createOpenTaskByName(OpenTaskByName value) {
        return new JAXBElement<OpenTaskByName>(_OpenTaskByName_QNAME, OpenTaskByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenTaskByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "openTaskByNameResponse")
    public JAXBElement<OpenTaskByNameResponse> createOpenTaskByNameResponse(OpenTaskByNameResponse value) {
        return new JAXBElement<OpenTaskByNameResponse>(_OpenTaskByNameResponse_QNAME, OpenTaskByNameResponse.class, null, value);
    }

}
