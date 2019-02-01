package Domain;

import entity.Project;
import entity.Session;
import entity.Task;
import entity.User;

import java.util.List;

public class Domain {

    private List<User> userList;

    private List<Project> projectList;

    private List<Task> taskList;

    private List<Session> sessionList;

    public List<User> getUserList() { return userList; }

    public void setUserList(List<User> userList) { this.userList = userList; }

    public List<Project> getProjectList() { return projectList; }

    public void setProjectList(List<Project> projectList) { this.projectList = projectList; }

    public List<Task> getTaskList() { return taskList; }

    public void setTaskList(List<Task> taskList) { this.taskList = taskList; }

    public List<Session> getSessionList() { return sessionList; }

    public void setSessionList(List<Session> sessionList) { this.sessionList = sessionList; }
}
