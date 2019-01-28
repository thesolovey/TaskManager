package repository;

import entity.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository implements Serializable {

    private final List<Task> taskList = new ArrayList<>();

    public void addTask(final Task task) {
        taskList.add(task);
    }

    public List<Task> getTaskList() { return taskList;}

    public void clearTaskList() { taskList.clear(); }

    public void deleteTask(final Task task) { taskList.remove(task); }

    public void addListTasks(List<Task> tasks) { taskList.addAll(tasks); }
}
