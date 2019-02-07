package repository;

import entity.Task;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository extends AbstractRepository {
    public TaskRepository(Connection connection) { this.connection = connection; }

    private final List<Task> taskList = new ArrayList<>();

    public void addTask(final Task task) {
        taskList.add(task);
    }

    public List<Task> getTaskList() { return taskList;}

    public void clearTaskList() { taskList.clear(); }

    public void deleteTask(final Task task) { taskList.remove(task); }

    public void addListTasks(final List<Task> tasks) { taskList.addAll(tasks); }
}
