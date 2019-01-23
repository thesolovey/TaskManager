package com.gmail.sdima.command.project;

import com.gmail.sdima.bootstrap.Bootstrap;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.command.ReadFromConsole;
import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.User;


import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class ProjectCreateCommand extends AbstractCommand {
    public ProjectCreateCommand(Bootstrap bootstrap) {
        super(bootstrap);
    }
    public static final String COMMAND = "project-create";

    public void execute() {
        System.out.println("[PROJECT CREATE]");
        final Project project = new Project();
        final User user = bootstrap.getUserService().getCurrentUser();
        final String name = ReadFromConsole.readInputFromConsole("Input name Project: ");
        project.setName(name);

        final String idProject = UUID.randomUUID().toString();
        project.setId(idProject);

        final Date dateBegin = new Date();
        Calendar calendarBegin = Calendar.getInstance();
        calendarBegin.setTime(dateBegin);

        project.setDateBegin(calendarBegin.getTime());
        project.setUserLogin(user.getLogin());
        project.setUserName(user.getUserName());

        bootstrap.getProjectService().addProjectByList(project);
        bootstrap.getProjectService().writeObject();

        System.out.println("[OK]");
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