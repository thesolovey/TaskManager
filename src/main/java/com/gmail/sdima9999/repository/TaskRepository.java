package com.gmail.sdima9999.repository;

import com.gmail.sdima9999.entity.Task;

import java.io.Serializable;
import java.util.ArrayList;

public class TaskRepository implements Serializable {

    private final ArrayList<Task> taskList = new ArrayList<>();

    public void addTask(final Task task) {
        taskList.add(task);
    }

    public ArrayList<Task> getTaskList() { return taskList;}

    public void clearTaskList() { taskList.clear(); }
}
