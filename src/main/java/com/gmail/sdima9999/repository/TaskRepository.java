package com.gmail.sdima9999.repository;

import java.util.ArrayList;

public class TaskRepository {
    public static ArrayList<String> myTaskList = new ArrayList<>();

    public static void taskListAdd(String name) {
        myTaskList.add(name);
    }
    public static void taskListRemove() {
 //       myTaskList.remove()
    }
    public static void taskListChange() {

    }
}
