package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.command.ReadFromConsole;

public class ProjectUpdateCommand extends AbstractCommand {
    public ProjectUpdateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "project-update";

    public void execute() {
        System.out.println("[PROJECT UPDATE]");

        boolean checkProjectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
        if (checkProjectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try command 'project-create' !!!");
        }

        final String name = ReadFromConsole.readInputFromConsole("Enter the name of the Project you want to exchange: ");
        final String newName = ReadFromConsole.readInputFromConsole("Enter new name: ");

        bootstrap.getProjectService().updateNameProject(name, newName);

        System.out.println("[OK]");
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}
