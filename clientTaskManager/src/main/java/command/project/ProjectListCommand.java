package command.project;

import bootstrap.BootstrapClient;
import command.AbstractCommand;
import endpoint.Project;
import endpoint.User;

import java.util.List;

public class ProjectListCommand extends AbstractCommand {
    public ProjectListCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "project-list";

    public void execute() {
        System.out.println("[PROJECT LIST]");

        boolean projectListIsEmpty = bootstrap.getEndpointProject().checkProjectListIsEmpty();
                if (projectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try command 'project-create' !!!");
        } else {

        final List<Project> allProject = bootstrap.getEndpointProject().findAllProject(BootstrapClient.getSessionCurrentUser());
        final User user = new User();
//                bootstrap.getEndpointUser().getCurrentUser();
        for (Project project : allProject)
            if (project.getUserLogin().equals(user.getLogin()))
                System.out.println(project.getName());
                }
                System.out.println("[OK]");
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public String getKeyWord() { return "project-list"; }

    @Override
    public String description() { return "Shows list Projects"; }
}
