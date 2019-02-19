package api;

import dto.TaskDTO;
import entity.Project;
import entity.Session;
import entity.Task;

import java.util.List;

public interface ITaskService {
    void addTask(TaskDTO task, Project project);
    void deleteTask(String taskId);
    List<String> getTaskByUserId(Session session);
    List<Task> openTaskByName(String name);
    List<String> getTaskByProjectName(String projectName);
    void deleteTaskByProjectId(String projectId);
    boolean checkTaskListIsEmpty();
}
