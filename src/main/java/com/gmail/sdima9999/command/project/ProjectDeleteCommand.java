package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.console.ReadFromConsole;

public class ProjectDeleteCommand extends AbstractCommand {
    public ProjectDeleteCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[PROJECT DELETE]");
        boolean checkProjectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
        if (checkProjectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!  Try command 'project-create'  !!!");
        } else {
            String nameProject = ReadFromConsole.readInputFromConsole("Input name Project you want delete: ");
            bootstrap.getProjectService().deleteProject(nameProject);
        } System.out.println("[ОК]");
    }

    @Override
    public void secure() {

    }
}
