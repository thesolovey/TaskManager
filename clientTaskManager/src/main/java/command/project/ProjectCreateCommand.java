package command.project;

import bootstrap.BootstrapClient;
import command.AbstractCommand;
import command.ReadFromConsole;
import endpoint.AccessForbiddenException_Exception;
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
        User user = new User();
        try {
            user = getBootstrap().getEndpointUser().getUserById(BootstrapClient.getSessionCurrentUser(), session.getUserId());
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
        }
        final String name = ReadFromConsole.readInputFromConsole("Input name Project: ");
        project.setName(name);

        final String idProject = UUID.randomUUID().toString();
        project.setId(idProject);

        final Date dateBegin = new Date();
        final Calendar calendarBegin = Calendar.getInstance();
        calendarBegin.setTime(dateBegin);

//        project.setDateBegin(calendarBegin.getTime());
        project.setUserLogin(user.getLogin());
        project.setUserName(user.getUserName());

        try {
            getBootstrap().getEndpointProject().createProject(session, project);
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
        }

        System.out.println("[OK]");
            }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return "project-create"; }

    @Override
    public String description() { return "Create new project"; }
}
