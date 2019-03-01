package com.gmail.sdima.command.service;

import com.gmail.sdima.bootstrap.Bootstrap;
import com.gmail.sdima.command.AbstractCommand;

public class LoadCommand extends AbstractCommand {
    public LoadCommand(Bootstrap bootstrap) { super(bootstrap); }
//    private Domain domain = new Domain();

    public static final String COMMAND = "load";

    @Override
    public void execute() {
        System.out.println("[LOAD]");
//        try {
//            List<Session> sessionList = null;
//            List<User> userList = null;
//            List<Project> projectList = null;
//            List<Task> taskList = null;
//            FileInputStream fisUser = new FileInputStream("user.txt");
//            ObjectInputStream oisUser = new ObjectInputStream(fisUser);
//            userList = (List<User>) oisUser.readObject();
//            com.gmail.sdima.domain.setUserList(userList);
//
//            FileInputStream fisProject = new FileInputStream("project.txt");
//            ObjectInputStream oisProject = new ObjectInputStream(fisProject);
//            projectList = (List<Project>) oisProject.readObject();
//            com.gmail.sdima.domain.setProjectList(projectList);
//
//            FileInputStream fisTask = new FileInputStream("task.txt");
//            ObjectInputStream oisTask = new ObjectInputStream(fisTask);
//            taskList = (List<Task>) oisTask.readObject();
//            com.gmail.sdima.domain.setTaskList(taskList);
//
//            FileInputStream fisSession = new FileInputStream("session.txt");
//            ObjectInputStream oisSession = new ObjectInputStream(fisSession);
//            sessionList = (List<Session>) oisSession.readObject();
//            com.gmail.sdima.domain.setSessionList(sessionList);
//
//        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        System.out.println("[OK]");
    }
}
