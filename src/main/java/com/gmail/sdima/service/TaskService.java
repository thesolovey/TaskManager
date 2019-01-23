package com.gmail.sdima.service;

import com.gmail.sdima.entity.Task;
import com.gmail.sdima.repository.TaskRepository;

import java.io.*;
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
        if (taskRepository.getTaskList() == null) return;
        taskRepository.addTask(task);
    }

    public List<Task> getAllTaskFromList() {
        return taskRepository.getTaskList();
    }

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
        if (taskRepository.getTaskList() == null) return;
        taskRepository.clearTaskList();
    }

    public void deleteTask(String idTask) {
        if (taskRepository.getTaskList() == null) return;
        final List<Task> taskList = taskRepository.getTaskList();
        for (Task task : taskList)
            if (task.getId().equals(idTask)) {
                taskList.remove(task);
            }
    }

    public void updateTask(String name, String newName, Date newDateEnd) {
        if (taskRepository.getTaskList() == null) return;
        final List<Task> taskList = taskRepository.getTaskList();
        for (Task task : taskList)
            if (task.getName().equals(name)) {
                task.setName(newName);
                task.setDateEnd(newDateEnd);
            }
    }

    public void writeObject() {
        try {
            FileOutputStream fos = null;
            fos = new FileOutputStream("temp.txt");
            ObjectOutputStream oos = null;
            oos = new ObjectOutputStream(fos);
            oos.writeObject(taskRepository.getTaskList());
            oos.flush();
            oos.close();
        } catch (IOException e) { e.printStackTrace(); }
    }

    public List<Task> readObject () {
        List<Task> taskList = null;
        try {
            FileInputStream fis = null;
            fis = new FileInputStream("temp.txt");
            ObjectInputStream oin = null;
            oin = new ObjectInputStream(fis);
            taskList = (List<Task>) oin.readObject();
        } catch (IOException | ClassNotFoundException e) { e.printStackTrace();
        } return taskList;
    }
}

