package com.gmail.sdima.dto;

import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.Task;
import com.gmail.sdima.entity.User;

import java.util.List;

public class Data {

    private static List<User> userList;

    private static List<Project> projectList;

    private static List<Task> taskList;

    public static List<User> getUserList() { return userList; }

    public static void setUserList(List<User> userList) { Data.userList = userList; }

    public static List<Project> getProjectList() { return projectList; }

    public static void setProjectList(List<Project> projectList) { Data.projectList = projectList; }

    public static List<Task> getTaskList() { return taskList; }

    public static void setTaskList(List<Task> taskList) { Data.taskList = taskList; }
}
