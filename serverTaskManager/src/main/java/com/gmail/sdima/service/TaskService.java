package com.gmail.sdima.service;

import com.gmail.sdima.api.ITaskRepository;
import com.gmail.sdima.api.ITaskService;
import com.gmail.sdima.dto.TaskDTO;
import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.Session;
import com.gmail.sdima.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService implements ITaskService {

    @Autowired private ITaskRepository taskRepository;

    @Override
    public boolean checkTaskListIsEmpty() {
        final List<Task> taskList = taskRepository.getTaskList();
        return taskList == null || taskList.isEmpty();
    }

    @Override
    public void addTask(final TaskDTO taskDTO, final Project project) {
        if (taskDTO == null) return;
        final Task task = new Task();
        task.setId(taskDTO.getId());
        task.setName(taskDTO.getName());
        task.setProject(project);
        task.setUserLogin(taskDTO.getUserLogin());
        task.setIdByUser(taskDTO.getIdByUser());
        task.setDateBegin(taskDTO.getDateBegin());
        task.setDateEnd(taskDTO.getDateEnd());
        taskRepository.addTask(task);
    }

    @Override
    public List<String> getTaskByUserId(final Session session) {
        if (session == null) return null;
        final List<Task> taskList = taskRepository.getTaskList();
        final List<String> taskListByUserId = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getIdByUser().equals(session.getUserId()))
                taskListByUserId.add(task.getName());
        }
        return taskListByUserId;
    }

    @Override
    public List<String> getTaskByProjectName(final String projectName) {
        if (projectName == null) return null;
        final List<Task> taskList = taskRepository.getTaskList();
        final List<String> taskByProjectName = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getProject().getName().equals(projectName))
                taskByProjectName.add(task.getName());
        }
        return taskByProjectName;
    }

    @Override
    public void deleteTaskByProjectId(final String projectId) {
        if (projectId == null) return;
        final List<Task> taskList = taskRepository.getTaskList();
        Task taskForDelete = new Task();
        if (taskList == null || taskList.isEmpty()) return;
        for (Task task : taskList)
            if (task.getProject().getId().equals(projectId)) {
                taskForDelete = task;
                taskRepository.deleteTask(taskForDelete);
            }
    }

    @Override
    public List<Task> openTaskByName(final String nameTask) {
        if (nameTask == null) return null;
        final List<Task> taskList = taskRepository.getTaskList();
        final List<Task> taskListByName = new ArrayList<>();
        for (Task task : taskList)
            if (task.getName().equals(nameTask))
                taskListByName.add(task);
        return taskListByName;
    }

    @Override
    public void deleteTask(final String idTask) {
        if (idTask == null) return;
        final List<Task> taskList = taskRepository.getTaskList();
        for (Task task: taskList) {
            if (task.getId().equals(idTask)) {
                taskRepository.deleteTask(task);
                return;
            }
        }
    }
}

