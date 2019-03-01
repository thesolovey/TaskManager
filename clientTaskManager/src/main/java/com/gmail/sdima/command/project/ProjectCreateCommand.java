package com.gmail.sdima.command.project;

import com.gmail.sdima.bootstrap.BootstrapClient;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.command.ReadFromConsole;
import com.gmail.sdima.endpoint.AccessForbiddenException_Exception;
import com.gmail.sdima.endpoint.Project;
import com.gmail.sdima.endpoint.Session;
import com.gmail.sdima.endpoint.User;

import java.util.UUID;

public class ProjectCreateCommand extends AbstractCommand {
//    public ProjectCreateCommand(BootstrapClient bootstrap) {
//        super(bootstrap);
//    }
//    public ProjectCreateCommand() { }

    public void execute() {
        System.out.println("[PROJECT CREATE]");
        final Project project = new Project();
        final Session session = BootstrapClient.getSessionCurrentUser();
        User user = new User();
        try {
            user = getBootstrap().getEndpointUser().getUserById(BootstrapClient.getSessionCurrentUser(), session.getUserId());
        } catch (AccessForbiddenException_Exception e) { e.printStackTrace(); }

        final String name = ReadFromConsole.readInputFromConsole("Input name Project: ");
        final String idProject = UUID.randomUUID().toString();
        project.setName(name);
        project.setId(idProject);
        project.setUserLogin(user.getLogin());
        project.setUserName(user.getUserName());
        project.setUserId(user.getId());

        try {
            getBootstrap().getEndpointProject().createProject(session, project);
        } catch (AccessForbiddenException_Exception e) { e.printStackTrace(); }
        System.out.println("[OK]");
            }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return "project-create"; }

    @Override
    public String description() { return "Create new project"; }
}
