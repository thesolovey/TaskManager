package com.gmail.sdima9999.service;

import com.gmail.sdima9999.entity.Task;
import com.gmail.sdima9999.repository.TaskRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) { this.taskRepository = taskRepository; }

    public Boolean checkTaskListIsEmpty() {
        List<Task> taskList = taskRepository.getTaskList();
        return taskList == null || taskList.isEmpty();
    }

    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    public List<Task> getAllTaskFromList() { return taskRepository.getTaskList(); }

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

    public void deleteTask(String idTask) {
        final List<Task> taskList = taskRepository.getTaskList();
        for (Task task : taskList)
            if (task.getId().equals(idTask)) {
                taskList.remove(task);
            }
    }

    public void updateTask(String name, String newName, Date newDateEnd) {
        final List<Task> taskList = taskRepository.getTaskList();
        for (Task task : taskList)
            if (task.getName().equals(name)) {
                task.setName(newName);
                task.setDateEnd(newDateEnd);
            }
    }

    public void writeObject() {

    }

    public List<Task> readObject() {
        return null;
    }
}

