package com.gmail.sdima9999.repository;

import java.util.ArrayList;

public class ProjectRepository {
    public static ArrayList<String> myProjectList = new ArrayList<>();

    public static void projectListAdd(String name) {
        myProjectList.add(name);
    }
    public static void projectListRemove() {
//        myProjectList.remove();
    }
    public static void projectListChange() {

    }
}
