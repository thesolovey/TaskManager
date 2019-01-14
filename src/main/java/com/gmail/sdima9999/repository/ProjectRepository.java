package com.gmail.sdima9999.repository;

import com.gmail.sdima9999.entity.Project;

import java.util.ArrayList;

public class ProjectRepository {
    private static ArrayList<Project> projectList = new ArrayList<>();

    public static void addProjectList(final Project project) {
        projectList.add(project);
    }

    public static void getProjectList() {
        for (Project x: projectList)
        System.out.println(x.getName());
    }

    public static void openProject(String name) {
        for (Project z : projectList) {
            if (z.getName().equals(name)) {
                System.out.println("Project Name: " + z.getName());
                System.out.println("Project ID: " + z.getId());
                System.out.println("Project DateBegin: " + z.getDateBegin());
                System.out.println("Project DateEnd: " + z.getDateEnd());
            } else System.out.println("Invalid name Project");
        }
    }

    public static void changeProjectList(String name, String newName) {
            int i = projectList.indexOf(name);
//            projectList.add(i, newName);
            projectList.remove(i + 1);
    }
}
