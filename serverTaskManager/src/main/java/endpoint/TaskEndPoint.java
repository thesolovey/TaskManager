package endpoint;

import entity.Task;
import repository.ProjectRepository;
import repository.TaskRepository;
import service.TaskService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.List;

@WebService
public class TaskEndPoint {

    private final TaskRepository taskRepository = new TaskRepository();
    private final ProjectRepository projectRepository = new ProjectRepository();
    private final TaskService taskService = new TaskService(taskRepository, projectRepository);

    @WebMethod
    public void run() {
        Endpoint.publish("http://localhost:8080/task?wsdl", new TaskEndPoint());
    }

    @WebMethod
    public void createTask(Task task) {
        taskService.addTask(task);
    }

    @WebMethod
    public void deleteTask(String idTask) {
        taskService.deleteTask(idTask);
    }

    @WebMethod
    public List<Task> findAllTask() {
        return taskService.getAllTaskFromList();
    }

    @WebMethod
    public List<Task> openTask(String name) {
        return taskService.openTaskByName(name);
    }
}
