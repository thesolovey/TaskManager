package command.project;

import bootstrap.BootstrapClient;
import command.AbstractCommand;
import command.ReadFromConsole;
import endpoint.AccessForbiddenException_Exception;
import endpoint.Project;
import endpoint.Task;

import java.util.ArrayList;
import java.util.List;

public class ProjectOpenCommand extends AbstractCommand {
    public ProjectOpenCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "project-open";

    public void execute() {
        System.out.println("[PROJECT OPEN]");

        boolean projectListIsEmpty = bootstrap.getEndpointProject().checkProjectListIsEmpty();
        if (projectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try command 'project-create' !!!");
        } else {
            final String nameProject = ReadFromConsole.readInputFromConsole("Enter name Project do you want open: ");
            List<Project> projectList = new ArrayList<>();
            try {
                projectList = bootstrap.getEndpointProject().findAllProject(BootstrapClient.getSessionCurrentUser());
            } catch (AccessForbiddenException_Exception e) {
                e.printStackTrace();
            }
            for (Project project : projectList)
                if (project.getName().equals(nameProject)) {

                    System.out.println("Project Name: " + project.getName());
                    System.out.println("Project ID: " + project.getId());
                    System.out.println("Project DateBegin: " + project.getDateBegin());
                    System.out.println("User: " + project.getUserName());

                    boolean taskListIsEmpty = bootstrap.getEndpointTask().checkTaskListIsEmpty();
                    if (taskListIsEmpty) {
                        System.out.println("!!! This Project don't have any Task!!!");
                    }

                    final List<Task> taskByProjectName = bootstrap.getEndpointTask().getTaskByProjectName(nameProject);
                    for (Task task : taskByProjectName)
                        System.out.println("Tasks from this Project: " + task.getName());

                    System.out.println("[OK]");
            }
        }
    }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return "project-open"; }

    @Override
    public String description() { return "Open selected Project"; }
}