package com.gmail.sdima.command.project;

import com.gmail.sdima.bootstrap.Bootstrap;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.command.ReadFromConsole;

public class ProjectDeleteCommand extends AbstractCommand {
    public ProjectDeleteCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "project-delete";

    public void execute() {
        System.out.println("[PROJECT DELETE]");

        boolean projectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
        if (projectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!  Try command 'project-create'  !!!");
        } else {
            final String idProject = ReadFromConsole.readInputFromConsole("Input ID Project you want delete: ");

            bootstrap.getTaskService().deleteTaskByProjectId(idProject);
            bootstrap.getProjectService().deleteProject(idProject);
        }
            System.out.println("[ОК]");
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}
