package command.project;

import bootstrap.BootstrapClient;
import command.AbstractCommand;
import endpoint.AccessForbiddenException_Exception;
import endpoint.Project;

import java.util.ArrayList;
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

        List<Project> projectList = new ArrayList<>();
                    try {
                        projectList = bootstrap.getEndpointProject().getProjectByUserId(BootstrapClient.getSessionCurrentUser());
                    } catch (AccessForbiddenException_Exception e) {
                        e.printStackTrace();
                    }
                    for (Project project : projectList)
            System.out.println(project.getName());
                }
                System.out.println("[OK]");
    }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return "project-list"; }

    @Override
    public String description() { return "Shows list Projects"; }
}
