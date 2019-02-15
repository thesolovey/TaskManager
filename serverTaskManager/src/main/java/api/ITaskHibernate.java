package api;

import entity.Task;

import java.sql.SQLException;
import java.util.List;

public interface ITaskHibernate {

    void addTask(Task task) throws SQLException;
    void deleteTask(Task task) throws SQLException;
    List<Task> getTaskList() throws SQLException;
}
