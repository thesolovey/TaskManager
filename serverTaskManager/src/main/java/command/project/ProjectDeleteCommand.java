package command.project;

import bootstrap.Bootstrap;
import command.AbstractCommand;

public class ProjectDeleteCommand extends AbstractCommand {
    public static final String COMMAND = "project-deleteProject";

    public ProjectDeleteCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[PROJECT DELETE]");

//        boolean projectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
//        if (projectListIsEmpty) {
//            System.out.println("!!! You don't have any project now !!!");
//            System.out.println("!!!  Try command 'project-createProject'  !!!");
//        } else {
//            final String idProject = ReadFromConsole.readInputFromConsole("Input ID Project you want deleteProject: ");
//
//            bootstrap.getiTaskService().deleteTaskByProjectId(idProject);
//            bootstrap.getProjectService().deleteProject(idProject);
        }
//    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return "project-deleteProject"; }

    @Override
    public String description() { return "Delete selected project"; }
}
