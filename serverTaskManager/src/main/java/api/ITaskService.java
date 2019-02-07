package api;

import entity.Session;
import entity.Task;

import java.util.List;

public interface ITaskService {
    void addTask(Task task);
    void deleteTask(String taskId);
    List<Task> getTaskByUserId(Session session);
    List<Task> openTaskByName(String name);
    List<Task> getTaskByProjectName(String projectName);
    void deleteTaskByProjectId(String projectId);
    boolean checkTaskListIsEmpty();
}
