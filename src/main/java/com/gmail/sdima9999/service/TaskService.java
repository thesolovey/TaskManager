package com.gmail.sdima9999.service;

import com.gmail.sdima9999.console.ReadFromConsole;
import com.gmail.sdima9999.entity.Task;
import com.gmail.sdima9999.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    public Boolean checkTaskListIsEmpty() {
        List<Task> taskList = taskRepository.getTaskList();
        return taskList == null || taskList.isEmpty();
    }

    public List<Task> getAllNameTaskFromList() { return taskRepository.getTaskList(); }

    public List<Task> getTaskFromListByProjectName(String projectName) {
        final List<Task> taskList = taskRepository.getTaskList();
        final List<Task> taskByProjectName = new ArrayList<>();
        for (Task task : taskList)
            if (task.getNameByProject().equals(projectName))
                taskByProjectName.add(task);
            return taskByProjectName;
    }

    public List<Task> openTaskByName(String nameTask) {
        final List<Task> taskList = taskRepository.getTaskList();
        final List<Task> taskListByName = new ArrayList<>();
        for (Task task : taskList)
            if (task.getName().equals(nameTask))
                taskListByName.add(task);
            return taskListByName;
    }

    public void clearTaskList() {
        taskRepository.clearTaskList();
    }

    public void deleteTask() {
        final List<Task> taskList = taskRepository.getTaskList();
        String name = "";
        if (taskList == null || taskList.isEmpty()) {
            System.out.println("!!!  You don't have any Task  !!!");
            System.out.println("!!! Try command 'task-create' !!!");
        } else
            name = ReadFromConsole.readInputFromConsole("Enter the name of the Task you want to delete: ");
        for (Task task : taskList) {
            if (task.getName().equals(name)) {
                taskList.remove(task);
            }
        }
    }
}

