package command.project;

import bootstrap.BootstrapClient;
import command.AbstractCommand;
import command.ReadFromConsole;

public class ProjectClearCommand extends AbstractCommand {
    public ProjectClearCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "project-clear";

    public void execute() {
        System.out.println("[PROJECT CLEAR]");
        boolean checkProjectListIsEmpty = bootstrap.getEndpointProject().checkProjectListIsEmpty();
        if (checkProjectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try command 'project-create' !!!");
        } else {
            final String answerInConsole = ReadFromConsole.readInputFromConsole("Are you sure, you want to delete all Project? Input: 'yes'");
            if (answerInConsole.equals("yes")) {
                bootstrap.getEndpointProject().clearAllProjectList();
                System.out.println("[!!! Projects were deleted!!!] ");
            }
            System.out.println("[OK]");
        }
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return "project-clear"; }

    @Override
    public String description() { return "Delete all projects"; }
}
