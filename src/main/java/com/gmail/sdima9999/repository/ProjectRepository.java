package com.gmail.sdima9999.repository;

import java.util.ArrayList;

public class ProjectRepository {
    public static ArrayList<String> projectList = new ArrayList<>();
    public static ArrayList<String> idProjectList = new ArrayList<>();

    public static void addProjectList(String name) {
        projectList.add(name);
    }
    public static void removeProjectList(String name) { projectList.remove(name); }
    public static void changeProjectList(String name, String newName) {
            int i = projectList.indexOf(name);
            projectList.add(i, newName);
            projectList.remove(i + 1);
    }
}
