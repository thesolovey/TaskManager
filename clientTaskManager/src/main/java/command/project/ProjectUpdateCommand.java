package command.project;

import bootstrap.BootstrapClient;
import command.AbstractCommand;

public class ProjectUpdateCommand extends AbstractCommand {
    public ProjectUpdateCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "project-update";

    public void execute() {
        System.out.println("[PROJECT UPDATE]");

//        boolean checkProjectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
//        if (checkProjectListIsEmpty) {
//            System.out.println("!!! You don't have any project now !!!");
//            System.out.println("!!!   Try command 'project-create' !!!");
//        }
//
//        final String id = ReadFromConsole.readInputFromConsole("Enter ID Project you want to exchange: ");
//        final String newName = ReadFromConsole.readInputFromConsole("Enter new name: ");
//
//        bootstrap.getProjectService().updateNameProject(id, newName);

        System.out.println("[OK]");
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return "project-update"; }

    @Override
    public String description() { return "Update selected Project"; }
}
