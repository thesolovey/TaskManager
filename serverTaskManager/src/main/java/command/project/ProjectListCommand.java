package command.project;

import bootstrap.Bootstrap;
import command.AbstractCommand;

public class ProjectListCommand extends AbstractCommand {
    public ProjectListCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "project-list";

    public void execute() {
        System.out.println("[PROJECT LIST]");

//        boolean projectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
//                if (projectListIsEmpty) {
//            System.out.println("!!! You don't have any project now !!!");
//            System.out.println("!!!   Try command 'project-createProject' !!!");
//        } else {
//        final List<Project> allProject = bootstrap.getProjectService().getAllProjectFromList();
//        final User user = bootstrap.getiUserService().getCurrentUser();
//        for (Project project : allProject)
//            if (project.getUserLogin().equals(user.getLogin()))
//                System.out.println(project.getName());
//                }
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
