
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

    private final static QName _CreateTask_QNAME = new QName("http://endpoint/", "createTask");
    private final static QName _CreateTaskResponse_QNAME = new QName("http://endpoint/", "createTaskResponse");
    private final static QName _DeleteTask_QNAME = new QName("http://endpoint/", "deleteTask");
    private final static QName _DeleteTaskResponse_QNAME = new QName("http://endpoint/", "deleteTaskResponse");
    private final static QName _FindAllTask_QNAME = new QName("http://endpoint/", "findAllTask");
    private final static QName _FindAllTaskResponse_QNAME = new QName("http://endpoint/", "findAllTaskResponse");
    private final static QName _OpenTask_QNAME = new QName("http://endpoint/", "openTask");
    private final static QName _OpenTaskResponse_QNAME = new QName("http://endpoint/", "openTaskResponse");
    private final static QName _Run_QNAME = new QName("http://endpoint/", "run");
    private final static QName _RunResponse_QNAME = new QName("http://endpoint/", "runResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: endpoint
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link OpenTask }
     * 
     */
    public OpenTask createOpenTask() {
        return new OpenTask();
    }

    /**
     * Create an instance of {@link OpenTaskResponse }
     * 
     */
    public OpenTaskResponse createOpenTaskResponse() {
        return new OpenTaskResponse();
    }

    /**
     * Create an instance of {@link Run }
     * 
     */
    public Run createRun() {
        return new Run();
    }

    /**
     * Create an instance of {@link RunResponse }
     * 
     */
    public RunResponse createRunResponse() {
        return new RunResponse();
    }

    /**
     * Create an instance of {@link Task }
     * 
     */
    public Task createTask() {
        return new Task();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "openTask")
    public JAXBElement<OpenTask> createOpenTask(OpenTask value) {
        return new JAXBElement<OpenTask>(_OpenTask_QNAME, OpenTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenTaskResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "openTaskResponse")
    public JAXBElement<OpenTaskResponse> createOpenTaskResponse(OpenTaskResponse value) {
        return new JAXBElement<OpenTaskResponse>(_OpenTaskResponse_QNAME, OpenTaskResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Run }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "run")
    public JAXBElement<Run> createRun(Run value) {
        return new JAXBElement<Run>(_Run_QNAME, Run.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RunResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://endpoint/", name = "runResponse")
    public JAXBElement<RunResponse> createRunResponse(RunResponse value) {
        return new JAXBElement<RunResponse>(_RunResponse_QNAME, RunResponse.class, null, value);
    }

}
