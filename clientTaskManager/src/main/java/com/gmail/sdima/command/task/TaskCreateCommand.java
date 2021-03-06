package com.gmail.sdima.command.task;

import com.gmail.sdima.bootstrap.BootstrapClient;
import com.gmail.sdima.command.AbstractCommand;
import com.gmail.sdima.command.ReadFromConsole;
import com.gmail.sdima.endpoint.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.*;

public class TaskCreateCommand extends AbstractCommand {
    public TaskCreateCommand(BootstrapClient bootstrap) {
        super(bootstrap);
    }
    public TaskCreateCommand() { }

    public void execute() {
        List<Project> projectList = new ArrayList<>();
        try {
            projectList = bootstrap.getEndpointProject().getProjectByUserId(BootstrapClient.getSessionCurrentUser());
        } catch (AccessForbiddenException_Exception e) {
            e.printStackTrace();
        }
        if (projectList == null || projectList.isEmpty()) {
            System.out.println("!!!  You must have any Project   !!!");
            System.out.println("!!! Try com.gmail.sdima.command 'project-create' !!!");
        } else {
            System.out.println("[TASK CREATE]");
            final TaskDTO task = new TaskDTO();
            final String name = ReadFromConsole.readInputFromConsole("Input name Task: ");
            User user = new User();
            try {
                user = bootstrap.getEndpointUser().getUserById(BootstrapClient.getSessionCurrentUser(), BootstrapClient.getSessionCurrentUser().getUserId());
            } catch (AccessForbiddenException_Exception e) {
                e.printStackTrace();
            }
            task.setName(name);
            final String idTask = UUID.randomUUID().toString();
            task.setId(idTask);
            final Date dateBegin = new Date();
            final GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(dateBegin);
            XMLGregorianCalendar myDate = null;
            try {
                myDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
            } catch (DatatypeConfigurationException e) { e.printStackTrace(); }
            task.setDateBegin(myDate);

            System.out.println("How many days to complete this Task?: ");
            final Scanner scanner = new Scanner(System.in);
            final int dateEnd = scanner.nextInt();
            final long countDay = dateEnd * 86400000;
            final long finalDate = dateBegin.getTime() + countDay;
            final Date endDate = new Date(finalDate);
            final GregorianCalendar gcEnd = new GregorianCalendar();
            gcEnd.setTime(endDate);
            XMLGregorianCalendar myDateEnd = null;
            try {
                myDateEnd = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcEnd);
            } catch (DatatypeConfigurationException e) { e.printStackTrace(); }
            task.setDateEnd(myDateEnd);

            task.setUserLogin(user.getLogin());
            task.setIdByProject(user.getUserName());
            task.setIdByUser(user.getId());

            final String idProject = ReadFromConsole.readInputFromConsole("Input ID Project for this Task: ");
            for (Project project: projectList) {
                if (project.getId().equals(idProject)) {
                    String projectName = project.getName();
                    task.setNameByProject(projectName);
                    task.setIdByProject(idProject);
                    try {
                        bootstrap.getEndpointTask().createTask(BootstrapClient.getSessionCurrentUser(), task);
                    } catch (AccessForbiddenException_Exception e) {
                        e.printStackTrace();
                    }
                }
            } System.out.println("[OK]");
        }
    }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return "task-create"; }

    @Override
    public String description() { return "Create new Task"; }
}
