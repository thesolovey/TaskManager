package command.project;

import bootstrap.BootstrapClient;
import command.AbstractCommand;
import command.ReadFromConsole;
import endpoint.Project;
import endpoint.Session;
import endpoint.User;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class ProjectCreateCommand extends AbstractCommand {
    public ProjectCreateCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }
    public static final String COMMAND = "project-create";

    public void execute() {
        System.out.println("[PROJECT CREATE]");
        final Project project = new Project();
        final Session session = BootstrapClient.getSessionCurrentUser();
        final User user = getBootstrap().getEndpointUser().getUserById(session.getUserId());
        final String name = ReadFromConsole.readInputFromConsole("Input name Project: ");
        project.setName(name);

        final String idProject = UUID.randomUUID().toString();
        project.setId(idProject);

        final Date dateBegin = new Date();
        Calendar calendarBegin = Calendar.getInstance();
        calendarBegin.setTime(dateBegin);

//        project.setDateBegin(calendarBegin.getTime());
        project.setUserLogin(user.getLogin());
        project.setUserName(user.getUserName());

        getBootstrap().getEndpointProject().createProject(session, project);

        System.out.println("[OK]");
            }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public String getKeyWord() { return "project-create"; }

    @Override
    public String description() { return "Create new project"; }
}