package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.console.ReadFromConsole;

public class ProjectUpdateCommand extends AbstractCommand {
    public ProjectUpdateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[PROJECT UPDATE]");

        boolean checkProjectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
        if (checkProjectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try command 'project-create' !!!");
        }

        String name = ReadFromConsole.readInputFromConsole("Enter the name of the Project you want to exchange: ");
        String newName = ReadFromConsole.readInputFromConsole("Enter new name: ");

        bootstrap.getProjectService().updateNameProject(name, newName);

        System.out.println("[OK]");
    }

    @Override
    public void secure() {

    }
}
