package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.command.ReadFromConsole;

public class ProjectDeleteCommand extends AbstractCommand {
    public ProjectDeleteCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "project-delete";

    public void execute() {
        System.out.println("[PROJECT DELETE]");
        boolean checkProjectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
        if (checkProjectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!  Try command 'project-create'  !!!");
        } else {
            final String idProject = ReadFromConsole.readInputFromConsole("Input ID Project you want delete: ");
            bootstrap.getProjectService().deleteProject(idProject);
        } System.out.println("[ОК]");
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}
