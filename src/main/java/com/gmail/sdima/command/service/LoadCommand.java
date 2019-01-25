package com.gmail.sdima.command.service;

import com.gmail.sdima.bootstrap.Bootstrap;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.dto.Data;
import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.Task;
import com.gmail.sdima.entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class LoadCommand extends AbstractCommand {
    public LoadCommand(Bootstrap bootstrap) { super(bootstrap); }
    public static final String COMMAND = "load";

    @Override
    public void execute() {
        System.out.println("[LOAD]");
        List<User> userList = null;
        List<Project> projectList = null;
        List<Task> taskList = null;
        try {
            FileInputStream fisUser = new FileInputStream("user.txt");
            ObjectInputStream oisUser = new ObjectInputStream(fisUser);
            userList = (List<User>) oisUser.readObject();
            Data.setUserList(userList);

            FileInputStream fisProject = new FileInputStream("project.txt");
            ObjectInputStream oisProject = new ObjectInputStream(fisProject);
            projectList = (List<Project>) oisProject.readObject();
            Data.setProjectList(projectList);

            FileInputStream fisTask = new FileInputStream("task.txt");
            ObjectInputStream oisTask = new ObjectInputStream(fisTask);
            taskList = (List<Task>) oisTask.readObject();
            Data.setTaskList(taskList);

        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        System.out.println("[OK]");
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public String getKeyWord() {
        return null;
    }

    @Override
    public String description() {
        return null;
    }
}
