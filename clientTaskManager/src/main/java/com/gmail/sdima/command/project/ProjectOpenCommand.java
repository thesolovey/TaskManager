package com.gmail.sdima.command.project;

import com.gmail.sdima.bootstrap.BootstrapClient;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.command.ReadFromConsole;
import com.gmail.sdima.endpoint.AccessForbiddenException_Exception;
import com.gmail.sdima.endpoint.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectOpenCommand extends AbstractCommand {
    public ProjectOpenCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }
    public ProjectOpenCommand() { }

    public void execute() {
        System.out.println("[PROJECT OPEN]");

        boolean projectListIsEmpty = bootstrap.getEndpointProject().checkProjectListIsEmpty();
        if (projectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try com.gmail.sdima.command 'project-create' !!!");
        } else {
            final String nameProject = ReadFromConsole.readInputFromConsole("Enter name Project do you want open: ");
            List<Project> projectList = new ArrayList<>();
            try {
                projectList = bootstrap.getEndpointProject().getProjectByUserId(BootstrapClient.getSessionCurrentUser());
            } catch (AccessForbiddenException_Exception e) { e.printStackTrace(); }
            for (Project project : projectList)
                if (project.getName().equals(nameProject)) {

                    System.out.println("Project Name: " + project.getName());
                    System.out.println("Project ID: " + project.getId());
                    System.out.println("User: " + project.getUserName());

                    boolean taskListIsEmpty = bootstrap.getEndpointTask().checkTaskListIsEmpty();
                    if (taskListIsEmpty) {
                        System.out.println("!!! This Project don't have any Task!!!");
                    }

                    List<String> taskByProjectName = new ArrayList<>();
                    try {
                        taskByProjectName = bootstrap.getEndpointTask().getTaskByProjectName(BootstrapClient.getSessionCurrentUser(), nameProject);
                    } catch (AccessForbiddenException_Exception e) { e.printStackTrace(); }
                    for (String task : taskByProjectName)
                        System.out.println("Tasks from this Project: " + task);

                    System.out.println("[OK]");
            }
        }
    }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return "project-open"; }

    @Override
    public String description() { return "Open selected Project"; }
}