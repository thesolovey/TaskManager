package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.command.ReadFromConsole;

public class ProjectClearCommand extends AbstractCommand {
    public ProjectClearCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "project-clear";

    public void execute() {
        System.out.println("[PROJECT CLEAR]");
        boolean checkProjectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
        if (checkProjectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try command 'project-create' !!!");
        } else {
            final String answerInConsole = ReadFromConsole.readInputFromConsole("Are you sure, you want to delete all Project? Input: 'yes'");
            if (answerInConsole.equals("yes")) {
                bootstrap.getProjectService().clearAllProject();
                System.out.println("[!!! Projects were deleted!!!] ");
            }
            System.out.println("[OK]");
        }
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}
