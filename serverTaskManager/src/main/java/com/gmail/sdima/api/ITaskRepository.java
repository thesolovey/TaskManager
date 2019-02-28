package com.gmail.sdima.api;

import com.gmail.sdima.entity.Task;

import java.util.List;

public interface ITaskRepository {

    void addTask(Task task);
    void deleteTask(Task task);
    List<Task> getTaskList();
}
