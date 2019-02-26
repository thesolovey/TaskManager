package com.gmail.sdima.command.project;

import com.gmail.sdima.bootstrap.BootstrapClient;
import com.gmail.sdima.command.AbstractCommand;

public class ProjectUpdateCommand extends AbstractCommand {
    public ProjectUpdateCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }
    public ProjectUpdateCommand() { }

    public void execute() {
        System.out.println("[PROJECT UPDATE]");

//        boolean checkProjectListIsEmpty = com.gmail.sdima.bootstrap.getProjectService().checkProjectListIsEmty();
//        if (checkProjectListIsEmpty) {
//            System.out.println("!!! You don't have any project now !!!");
//            System.out.println("!!!   Try com.gmail.sdima.command 'project-create' !!!");
//        }
//
//        final String id = ReadFromConsole.readInputFromConsole("Enter ID Project you want to exchange: ");
//        final String newName = ReadFromConsole.readInputFromConsole("Enter new name: ");
//
//        com.gmail.sdima.bootstrap.getProjectService().updateNameProject(id, newName);

        System.out.println("[OK]");
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return "project-update"; }

    @Override
    public String description() { return "Update selected Project"; }
}
