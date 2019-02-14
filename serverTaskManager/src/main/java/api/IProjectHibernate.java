package api;

import entity.Project;
import entity.Session;

import java.sql.SQLException;
import java.util.List;

public interface IProjectHibernate {

    boolean checkProjectListIsEmpty() throws SQLException;
    void addProjectByList(Project project) throws SQLException;
    List<Project> getProjectByUserId(Session session) throws SQLException;
    void deleteProject(String projectId) throws SQLException;
}
