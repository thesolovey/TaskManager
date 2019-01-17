package com.gmail.sdima9999.command.project;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;
import com.gmail.sdima9999.console.ReadFromConsole;
import com.gmail.sdima9999.entity.Project;
import com.gmail.sdima9999.repository.ProjectRepository;


import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class ProjectCreateCommand extends AbstractCommand {
    public ProjectCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }

    public void execute() {
        System.out.println("[PROJECT CREATE]");
        Project project = new Project();
        String name = ReadFromConsole.readInputFromConsole("Input name Project: ");
        project.setName(name);

        String idProject = UUID.randomUUID().toString();
        project.setId(idProject);

        Date dateBegin = new Date();
        Calendar calendarBegin = Calendar.getInstance();
        Calendar calendarEnd = Calendar.getInstance();
        calendarBegin.setTime(dateBegin);
        calendarEnd.add(Calendar.WEEK_OF_MONTH, 2);

        project.setDateBegin(calendarBegin.getTime());

        project.setDateEnd(calendarEnd.getTime());

        bootstrap.getProjectService().addProjectByList(project);

        System.out.println("[OK]");
    }
}
