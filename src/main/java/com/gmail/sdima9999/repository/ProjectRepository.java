package com.gmail.sdima9999.repository;

import java.util.ArrayList;

public class ProjectRepository {
    public static ArrayList<String> myProjectList = new ArrayList<>();

    public static void addProjectList(String name) {
        myProjectList.add(name);
    }
    public static void removeProjectList(String name) { myProjectList.remove(name); }
    public static void changeProjectList(String name, String newName) {
            int i = myProjectList.indexOf(name);
            myProjectList.add(i, newName);
            myProjectList.remove(i + 1);
    }
}
