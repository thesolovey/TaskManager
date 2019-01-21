package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.command.ReadFromConsole;
import com.gmail.sdima9999.entity.Project;
import com.gmail.sdima9999.entity.Task;

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
            final List<Project> projectByName = bootstrap.getProjectService().openProjectByName(nameProject);
            for (Project project : projectByName) {
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
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}