package command.project;

import bootstrap.Bootstrap;
import command.AbstractCommand;
import command.ReadFromConsole;

public class ProjectClearCommand extends AbstractCommand {
    public static final String COMMAND = "project-clear";

    public ProjectClearCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[PROJECT CLEAR]");
        boolean checkProjectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
        if (checkProjectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try command 'project-createProject' !!!");
        } else {
            final String answerInConsole = ReadFromConsole.readInputFromConsole("Are you sure, you want to deleteProject all Project? Input: 'yes'");
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
    public String getKeyWord() { return "project-clear"; }

    @Override
    public String description() { return "Delete all Projects"; }
}
