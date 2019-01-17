package com.gmail.sdima9999.service;

import com.gmail.sdima9999.console.ReadFromConsole;
import com.gmail.sdima9999.entity.Task;
import com.gmail.sdima9999.repository.TaskRepository;

import java.util.List;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task) {
        taskRepository.addTask(task);
    }

    public void getTaskListByName() {
        final List<Task> tasksList = taskRepository.getTaskList();
        if (tasksList == null || tasksList.isEmpty()) {
            System.out.println("!!!  You don't have any Task  !!!");
            System.out.println("!!! Try command 'task-create' !!!");
        } else
            for (Task task : tasksList)
                System.out.println(task.getName());
    }

    public void openTaskByName() {
        final List<Task> taskList = taskRepository.getTaskList();
        String name = "";
        if (taskList == null || taskList.isEmpty()) {
            System.out.println("!!!  You don't have any Task  !!!");
            System.out.println("!!! Try command 'task-create' !!!");
        } else
            name = ReadFromConsole.readInputFromConsole("Enter Task you want open: ");
        for (Task x : taskList) {
            if (x.getName().equals(name)) {
                System.out.println("Project Name: " + x.getNameByProject());
                System.out.println("Name Task: " + x.getName());
                System.out.println("Task ID: " + x.getId());
                System.out.println("Task Date Begin: " + x.getDateBegin());
                System.out.println("Task Date End: " + x.getDateEnd());
                System.out.println("Name Project for this Task: " + x.getNameByProject());
            } else
                System.out.println("!!! Invalid name Task !!!");
        }
    }

    public void clearTaskList() {
        final List<Task> taskList = taskRepository.getTaskList();
        String answerFromConcole = "";
        if (taskList == null || taskList.isEmpty()) {
            System.out.println("!!!  You don't have any Task  !!!");
            System.out.println("!!! Try command 'task-create' !!!");
        } else
            answerFromConcole = ReadFromConsole.readInputFromConsole("Are you sure, you want to delete all Task? Input: 'yes'");
        if (answerFromConcole.equals("yes")) {
            taskRepository.clearTaskList();
            System.out.println("[!!! Tasks were delete!!!] ");
        }
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

