package com.gmail.sdima.command.task;

import com.gmail.sdima.bootstrap.Bootstrap;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.Task;
import com.gmail.sdima.command.ReadFromConsole;
import com.gmail.sdima.entity.User;

import java.util.*;

public class TaskCreateCommand extends AbstractCommand {
    public TaskCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public static final String COMMAND = "task-create";

    public void execute() {
        final List<Project> projectList = bootstrap.getProjectRepository().getProjectList();
        if (projectList == null || projectList.isEmpty()) {
            System.out.println("!!!  You must have any Project   !!!");
            System.out.println("!!! Try command 'project-create' !!!");
        } else {
            System.out.println("[TASK CREATE]");
            final Task task = new Task();
            final String name = ReadFromConsole.readInputFromConsole("Input name Task: ");
            final User user = bootstrap.getUserService().getCurrentUser();
            task.setName(name);
            final String idTask = UUID.randomUUID().toString();
            task.setId(idTask);
            final Date dateBegin = new Date();
            Calendar calendarBegin = Calendar.getInstance();
            Calendar calendarEnd = Calendar.getInstance();
            calendarBegin.setTime(dateBegin);

            System.out.println("How many days to complete this Task?: ");
            Scanner scanner = new Scanner(System.in);
            int dateEnd = scanner.nextInt();
            calendarEnd.add(Calendar.DATE, dateEnd);

            task.setDateBegin(calendarBegin.getTime());
            task.setDateEnd(calendarEnd.getTime());
            task.setUserLogin(user.getLogin());
            task.setUserName(user.getUserName());

            final String nameProject = ReadFromConsole.readInputFromConsole("Input name Project for this Task: ");
            for (Project project: projectList) {
                        if (project.getName().equals(nameProject)) {
                            task.setNameByProject(nameProject);
                            bootstrap.getTaskService().addTask(task);
                        }
            } System.out.println("[OK]");
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
