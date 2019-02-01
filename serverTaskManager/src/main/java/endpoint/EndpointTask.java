package endpoint;

import api.ServiceLocator;
import entity.Task;
import repository.ProjectRepository;
import repository.TaskRepository;
import service.TaskService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class EndpointTask {

    private ServiceLocator serviceLocator;
    public EndpointTask(ServiceLocator serviceLocator) { this.serviceLocator = serviceLocator; }

    private final TaskRepository taskRepository = new TaskRepository();
    private final ProjectRepository projectRepository = new ProjectRepository();
    private final TaskService taskService = new TaskService(taskRepository, projectRepository);

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

    @WebMethod
    public void deleteTaskByIdProjecr(String idProject) { taskService.deleteTaskByProjectId(idProject); }

    @WebMethod
    public boolean checkTaskListIsEmpty() { return taskService.checkTaskListIsEmpty(); }

    @WebMethod
    public List<Task> getTaskByProjectName(String nameProject) { return taskService.getTaskByProjectName(nameProject); }
}
