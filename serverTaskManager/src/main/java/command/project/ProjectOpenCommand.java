package command.project;

import bootstrap.Bootstrap;
import command.AbstractCommand;

public class ProjectOpenCommand extends AbstractCommand {
    public static final String COMMAND = "project-open";

    public ProjectOpenCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[PROJECT OPEN]");

//        boolean projectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
//        if (projectListIsEmpty) {
//            System.out.println("!!! You don't have any project now !!!");
//            System.out.println("!!!   Try command 'project-createProject' !!!");
//        } else {
//            final String nameProject = ReadFromConsole.readInputFromConsole("Enter name Project do you want open: ");
//            final List<Project> projectList = bootstrap.getProjectService().getProjectByUserId();
//            for (Project project : projectList)
//                if (project.getName().equals(nameProject)) {
//
//                    System.out.println("Project Name: " + project.getName());
//                    System.out.println("Project ID: " + project.getId());
//                    System.out.println("Project DateBegin: " + project.getDateBegin());
//                    System.out.println("User: " + project.getUserName());
//
//                    boolean taskListIsEmpty = bootstrap.getiTaskService().checkTaskListIsEmpty();
//                    if (taskListIsEmpty) {
//                        System.out.println("!!! This Project don't have any Task!!!");
//                    }
//
//                    final List<Task> taskByProjectName = bootstrap.getiTaskService().getTaskByProjectName(nameProject);
//                    for (Task task : taskByProjectName)
//                        System.out.println("Tasks from this Project: " + task.getName());

                    System.out.println("[OK]");
//            }
 //      }
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return "project-open"; }

    @Override
    public String description() { return "Open selected Project"; }
}