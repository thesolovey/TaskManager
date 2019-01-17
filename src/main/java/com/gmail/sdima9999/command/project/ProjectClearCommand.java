package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.console.ReadFromConsole;

public class ProjectClearCommand extends AbstractCommand {
    public ProjectClearCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[PROJECT CLEAR]");
        boolean checkProjectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
        if (checkProjectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try command 'project-create' !!!");
        } else {
            String answerInConcole = ReadFromConsole.readInputFromConsole("Are you sure, you want to delete all Project? Input: 'yes'");
            if (answerInConcole.equals("yes")) {
                bootstrap.getProjectService().clearAllProject();
                System.out.println("[!!! Project were delete!!!] ");
            }
            System.out.println("[OK]");
        }
    }
}
