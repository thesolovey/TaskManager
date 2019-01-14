package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.readfromconsole.ReadFromConsole;
import com.gmail.sdima9999.entity.Project;
import com.gmail.sdima9999.repository.ProjectRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class ProjectCreateCommand {
    public static void execute() {
        System.out.println("[PROJECT CREATE]");
        Project project = new Project();
        String name = ReadFromConsole.readInputFromConsole("Input name Project: ");
        project.setName(name);

        String idTask = UUID.randomUUID().toString();
        project.setId(idTask);

        Date dateBegin = new Date();
        Calendar calendarBegin = Calendar.getInstance();
        Calendar calendarEnd = Calendar.getInstance();
        calendarBegin.setTime(dateBegin);
        calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);

        project.setDateBegin(calendarBegin.getTime());

        project.setDateEnd(calendarEnd.getTime());

        ProjectRepository.addProjectList(project);
        System.out.println("[OK]");
    }
}
