package com.gmail.sdima9999.repository;

import java.util.ArrayList;

public class TaskRepository {
    public static ArrayList<String> myTaskList = new ArrayList<>();

    public static void addTaskList(String name) {
        myTaskList.add(name);
    }
    public static void removeTaskList(String name) { myTaskList.remove(name); }
    public static void changeTaskList(String name, String newName) {
            int i = myTaskList.indexOf(name);
            myTaskList.add(i, newName);
            myTaskList.remove(i + 1);
    }
}
