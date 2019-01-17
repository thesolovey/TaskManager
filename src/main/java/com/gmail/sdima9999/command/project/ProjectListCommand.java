package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.entity.Project;

import java.util.List;

public class ProjectListCommand extends AbstractCommand {
    public ProjectListCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }
    public void execute() {
        System.out.println("[PROJECT LIST]");

        boolean projectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
                if (projectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try command 'project-create' !!!");
        }

        List<Project> allProject = bootstrap.getProjectService().getAllNameProjectFromList();
                for (Project project : allProject)
                    System.out.println(project.getName());

        System.out.println("[OK]");
    }
}
