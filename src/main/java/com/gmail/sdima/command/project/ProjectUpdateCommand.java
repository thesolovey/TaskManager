package com.gmail.sdima.command.project;

import com.gmail.sdima.bootstrap.Bootstrap;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.command.ReadFromConsole;

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

        final String id = ReadFromConsole.readInputFromConsole("Enter ID Project you want to exchange: ");
        final String newName = ReadFromConsole.readInputFromConsole("Enter new name: ");

        bootstrap.getProjectService().updateNameProject(id, newName);
        bootstrap.getProjectService().writeObject();

        System.out.println("[OK]");
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}
