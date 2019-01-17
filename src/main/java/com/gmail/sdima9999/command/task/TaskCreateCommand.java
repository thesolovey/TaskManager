package com.gmail.sdima9999.command.task;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.entity.Project;
import com.gmail.sdima9999.entity.Task;
import com.gmail.sdima9999.console.ReadFromConsole;
import com.gmail.sdima9999.repository.ProjectRepository;
import com.gmail.sdima9999.repository.TaskRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TaskCreateCommand extends AbstractCommand {
    public TaskCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        final List<Project> projectList = bootstrap.getProjectRepository().getProjectList();
        if (projectList == null || projectList.isEmpty()) {
            System.out.println("!!!  You must have any Project   !!!");
            System.out.println("!!! Try command 'project-create' !!!");
        } else {
            System.out.println("[TASK CREATE]");
            Task task = new Task();
            String name = ReadFromConsole.readInputFromConsole("Input name Task: ");
            task.setName(name);
            String idTask = UUID.randomUUID().toString();
            task.setId(idTask);
            Date dateBegin = new Date();
            Calendar calendarBegin = Calendar.getInstance();
            Calendar calendarEnd = Calendar.getInstance();
            calendarBegin.setTime(dateBegin);
            calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);
            task.setDateBegin(calendarBegin.getTime());
            task.setDateEnd(calendarEnd.getTime());
            TaskRepository taskRepository = new TaskRepository();
            taskRepository.addTask(task);

            String nameProject = ReadFromConsole.readInputFromConsole("Input name Project for this Task: ");
            for (Project x: projectList) {
                        if (x.getName().equals(nameProject)) {
                            task.setNameByProject(nameProject);
                            bootstrap.getTaskService().addTask(task);
                        } else System.out.println("!!! Invalid name Project !!!");
            }
            System.out.println("[OK]");
        }
    }
}
