package com.gmail.sdima.api;

import com.gmail.sdima.dto.TaskDTO;
import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.Session;
import com.gmail.sdima.entity.Task;

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
