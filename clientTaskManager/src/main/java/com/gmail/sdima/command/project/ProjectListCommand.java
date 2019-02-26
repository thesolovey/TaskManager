package com.gmail.sdima.command.project;

import com.gmail.sdima.bootstrap.BootstrapClient;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.endpoint.AccessForbiddenException_Exception;
import com.gmail.sdima.endpoint.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectListCommand extends AbstractCommand {
    public ProjectListCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }
    public ProjectListCommand() { }

    public void execute() {
        System.out.println("[PROJECT LIST]");

        boolean projectListIsEmpty = bootstrap.getEndpointProject().checkProjectListIsEmpty();
                if (projectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try com.gmail.sdima.command 'project-create' !!!");
        } else {
                    List<Project> projectList = new ArrayList<>();
                    try {
                        projectList = bootstrap.getEndpointProject().getProjectByUserId(BootstrapClient.getSessionCurrentUser());
                    } catch (AccessForbiddenException_Exception e) { e.printStackTrace(); }
                    for (Project project : projectList)
                        System.out.println(project.getName());
                }
                System.out.println("[OK]");
    }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return "project-list"; }

    @Override
    public String description() { return "Shows list Projects"; }
}
