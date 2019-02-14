package api;

import entity.Session;
import entity.Task;

import java.sql.SQLException;
import java.util.List;

public interface ITaskHibernate {

    boolean checkTaskListIsEmpty() throws SQLException;
    void addTask(Task task) throws SQLException;
    List<Task> getTaskByUserId(Session session) throws SQLException;
    List<Task> getTaskByProjectName(String projectName) throws SQLException;
    void deleteTaskByProjectId(String projectId) throws SQLException;
    List<Task> openTaskByName(String taskName) throws SQLException;
    void deleteTask(String taskId) throws SQLException;
}
