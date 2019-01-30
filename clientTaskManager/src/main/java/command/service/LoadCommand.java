package command.service;

import bootstrap.BootstrapClient;
import command.AbstractCommand;

public class LoadCommand extends AbstractCommand {
    public LoadCommand(BootstrapClient bootstrap) { super(bootstrap); }
    public static final String COMMAND = "load";

    @Override
    public void execute() {
//        System.out.println("[LOAD]");
//        List<User> userList = null;
//        List<Project> projectList = null;
//        List<Task> taskList = null;
//        try {
//            FileInputStream fisUser = new FileInputStream("user.txt");
//            ObjectInputStream oisUser = new ObjectInputStream(fisUser);
//            userList = (List<User>) oisUser.readObject();
//            Data.setUserList(userList);
//            bootstrap.getUserService().addListUsers(userList);
//
//            FileInputStream fisProject = new FileInputStream("project.txt");
//            ObjectInputStream oisProject = new ObjectInputStream(fisProject);
//            projectList = (List<Project>) oisProject.readObject();
//            Data.setProjectList(projectList);
//            bootstrap.getProjectService().addListProjects(projectList);
//
//            FileInputStream fisTask = new FileInputStream("task.txt");
//            ObjectInputStream oisTask = new ObjectInputStream(fisTask);
//            taskList = (List<Task>) oisTask.readObject();
//            Data.setTaskList(taskList);
//            bootstrap.getTaskService().addListTasks(taskList);
//
//        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
//        System.out.println("[OK]");
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
        return "Loads previously saved data";
    }
}
