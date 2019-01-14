package com.gmail.sdima9999.repository;

import com.gmail.sdima9999.entity.Task;

import java.util.ArrayList;

public class TaskRepository {

    private static ArrayList<Task> taskList = new ArrayList<>();

    public static void addTask(Task task) {
        taskList.add(task);
    }
    public static void getTaskList() {
        for (Task x: taskList)
        System.out.println(x.getName());
    }
    public static void openTask(String name) {
        for (Task z: taskList)
            if (z.getName().equals(name)) {
                System.out.println("Name: " + z.getName());
                System.out.println("TaskID: " + z.getId());
                System.out.println("TaskDateBegin: " + z.getDateBegin());
                System.out.println("TaskDateEnd: " + z.getDateEnd());
            } else System.out.println("Invalid name Task!"); 
    }
    public void removeTaskList(String name) { taskList.remove(name); }

    public void changeTaskList(String name, String newName) {
            int i = taskList.indexOf(name);
//            taskList.add(i, newName);
            taskList.remove(i + 1);
    }
}
