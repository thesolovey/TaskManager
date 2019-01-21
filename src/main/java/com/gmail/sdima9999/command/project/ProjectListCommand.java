package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.entity.Project;
import com.gmail.sdima9999.entity.User;

import java.util.List;

public class ProjectListCommand extends AbstractCommand {
    public ProjectListCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "project-list";

    public void execute() {
        System.out.println("[PROJECT LIST]");

        boolean projectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
                if (projectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try command 'project-create' !!!");
        }

        final List<Project> allProject = bootstrap.getProjectService().getAllNameProjectFromList();
        final User user = bootstrap.getUserService().getCurrentUser();
                for (Project project : allProject)
                    if (project.getUserLogin().equals(user.getLogin()))
                    System.out.println(project.getName());

        System.out.println("[OK]");
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}
