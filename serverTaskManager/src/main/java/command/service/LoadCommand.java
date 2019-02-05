package command.service;

import Domain.Domain;
import bootstrap.Bootstrap;
import command.AbstractCommand;
import entity.Project;
import entity.Session;
import entity.Task;
import entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class LoadCommand extends AbstractCommand {
    public LoadCommand(Bootstrap bootstrap) { super(bootstrap); }
    private Domain domain = new Domain();

    public static final String COMMAND = "load";

    @Override
    public void execute() {
        System.out.println("[LOAD]");
        try {
            List<Session> sessionList = null;
            List<User> userList = null;
            List<Project> projectList = null;
            List<Task> taskList = null;
            FileInputStream fisUser = new FileInputStream("user.txt");
            ObjectInputStream oisUser = new ObjectInputStream(fisUser);
            userList = (List<User>) oisUser.readObject();
            domain.setUserList(userList);
//            bootstrap.getiUserService().addListUsers(userList);

            FileInputStream fisProject = new FileInputStream("project.txt");
            ObjectInputStream oisProject = new ObjectInputStream(fisProject);
            projectList = (List<Project>) oisProject.readObject();
            domain.setProjectList(projectList);
//            bootstrap.getProjectService().addListProjects(projectList);

            FileInputStream fisTask = new FileInputStream("task.txt");
            ObjectInputStream oisTask = new ObjectInputStream(fisTask);
            taskList = (List<Task>) oisTask.readObject();
            domain.setTaskList(taskList);
 //           bootstrap.getiTaskService().addListTasks(taskList);

            FileInputStream fisSession = new FileInputStream("session.txt");
            ObjectInputStream oisSession = new ObjectInputStream(fisSession);
            sessionList = (List<Session>) oisSession.readObject();
            domain.setSessionList(sessionList);

        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        System.out.println("[OK]");
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public String getKeyWord() {
        return "load";
    }

    @Override
    public String description() {
        return "Load project and task";
    }
}
