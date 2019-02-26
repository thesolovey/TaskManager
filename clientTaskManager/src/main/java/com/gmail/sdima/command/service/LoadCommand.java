package com.gmail.sdima.command.service;

import com.gmail.sdima.bootstrap.BootstrapClient;
import com.gmail.sdima.command.AbstractCommand;

public class LoadCommand extends AbstractCommand {
    public LoadCommand(BootstrapClient bootstrap) { super(bootstrap); }
    public LoadCommand() { }

    @Override
    public void execute() {
        System.out.println("[LOAD]");

//        List<User> userList = null;
//        List<Project> projectList = null;
//        List<Task> taskList = null;
//        List<Session> sessionList = null;
//
//        try {
//            FileInputStream fisUser = new FileInputStream("user.txt");
//            ObjectInputStream oisUser = new ObjectInputStream(fisUser);
//            userList = (List<User>) oisUser.readObject();
//            Data.setUserList(userList);
//            com.gmail.sdima.bootstrap.getEndpointUser().addListUsers(userList);
//
//            FileInputStream fisProject = new FileInputStream("project.txt");
//            ObjectInputStream oisProject = new ObjectInputStream(fisProject);
//            projectList = (List<Project>) oisProject.readObject();
//            Data.setProjectList(projectList);
//            com.gmail.sdima.bootstrap.getEndpointProject().addListProjects(projectList);
//
//            FileInputStream fisTask = new FileInputStream("task.txt");
//            ObjectInputStream oisTask = new ObjectInputStream(fisTask);
//            taskList = (List<Task>) oisTask.readObject();
//            Data.setTaskList(taskList);
//            com.gmail.sdima.bootstrap.getEndpointTask().addListTasks(taskList);
//
//            FileInputStream fisSession = new FileInputStream("session.txt");
//            ObjectInputStream oisSession = new ObjectInputStream(fisSession);
//            sessionList = (List<Session>) oisSession.readObject();
//
//            com.gmail.sdima.bootstrap.getEndpointDataBase().save(projectList, taskList, userList, sessionList);
//
//        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        System.out.println("[OK]");
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public String getKeyWord() {
        return "load";
    }

    @Override
    public String description() {
        return "Loads previously saved data";
    }
}
