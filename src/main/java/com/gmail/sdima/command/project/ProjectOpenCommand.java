package com.gmail.sdima.command.project;

import com.gmail.sdima.bootstrap.Bootstrap;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.command.ReadFromConsole;
import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.Task;

import java.util.List;

public class ProjectOpenCommand extends AbstractCommand {
    public ProjectOpenCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "project-open";

    public void execute() {
        System.out.println("[PROJECT OPEN]");

        boolean projectListIsEmpty = bootstrap.getProjectService().checkProjectListIsEmty();
        if (projectListIsEmpty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try command 'project-create' !!!");
        } else {
            final String nameProject = ReadFromConsole.readInputFromConsole("Enter name Project do you want open: ");
//            final List<Project> projectList = bootstrap.getProjectService().getAllProjectFromList();
            final List<Project> projectList = bootstrap.getProjectService().readObject();
            for (Project project : projectList)
                if (project.getName().equals(nameProject)) {

                    System.out.println("Project Name: " + project.getName());
                    System.out.println("Project ID: " + project.getId());
                    System.out.println("Project DateBegin: " + project.getDateBegin());
                    System.out.println("User: " + project.getUserName());

                    boolean taskListIsEmpty = bootstrap.getTaskService().checkTaskListIsEmpty();
                    if (taskListIsEmpty) {
                        System.out.println("!!! This Project don't have any Task!!!");
                    }

                    final List<Task> taskByProjectName = bootstrap.getTaskService().getTaskFromListByProjectName(nameProject);
                    for (Task task : taskByProjectName)
                        if (task.getNameByProject().equals(nameProject)) {
                            System.out.println("Tasks from this Project: " + task.getName());
                        }
                    System.out.println("[OK]");
            }
        }
    }

    @Override
    public boolean secure() { return true; }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}