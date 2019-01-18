package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.console.ReadFromConsole;
import com.gmail.sdima9999.entity.Project;
import com.gmail.sdima9999.entity.Task;

import java.util.List;

public class ProjectOpenCommand extends AbstractCommand {
    public ProjectOpenCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[PROJECT OPEN]");

        boolean projectListIsEmty = bootstrap.getProjectService().checkProjectListIsEmty();
        if (projectListIsEmty) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try command 'project-create' !!!");
        } else {

            String nameProject = ReadFromConsole.readInputFromConsole("Enter name Project do you want open: ");
            Project projectByName = bootstrap.getProjectService().openProjectByName(nameProject);

            System.out.println("Project Name: " + projectByName.getName());
            System.out.println("Project ID: " + projectByName.getId());
            System.out.println("Project DateBegin: " + projectByName.getDateBegin());
            System.out.println("Project DateEnd: " + projectByName.getDateEnd());

            boolean taskListIsEmpty = bootstrap.getTaskService().checkTaskListIsEmpty();
            if (taskListIsEmpty) {
                System.out.println("!!! You don't have any Task!!!");
            }

            List<Task> taskByProjectName = bootstrap.getTaskService().getTaskFromListByProjectName(nameProject);
            for (Task task : taskByProjectName)
                if (task.getNameByProject().equals(nameProject)) {
                    System.out.println("Tasks from this Project: " + task.getName());
                }
            System.out.println("[OK]");
        }
    }

    @Override
    public void secure() {

    }
}