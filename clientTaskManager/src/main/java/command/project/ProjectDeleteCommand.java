package command.project;

import bootstrap.BootstrapClient;
import command.AbstractCommand;
import command.ReadFromConsole;
import endpoint.AccessForbiddenException_Exception;

public class ProjectDeleteCommand extends AbstractCommand {
    public ProjectDeleteCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "project-delete";

    public void execute() {
        System.out.println("[PROJECT DELETE]");

        boolean projectListIsEmpty = bootstrap.getEndpointProject().checkProjectListIsEmpty();
        if (projectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!  Try command 'project-create'  !!!");
        } else {
            final String idProject = ReadFromConsole.readInputFromConsole("Input ID Project you want delete: ");
            try {
                bootstrap.getEndpointTask().deleteTaskByIdProjecr(BootstrapClient.getSessionCurrentUser(), idProject);
            } catch (AccessForbiddenException_Exception e) { e.printStackTrace(); }
            try {
                bootstrap.getEndpointProject().deleteProject(BootstrapClient.getSessionCurrentUser(), idProject);
            } catch (AccessForbiddenException_Exception e) { e.printStackTrace(); }
        }
            System.out.println("[ОК]");
    }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return "project-delete"; }

    @Override
    public String description() { return "Delete selected Project"; }
}
