package api;

import entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface IProjectHibernate {

    void addProject(Project project) throws SQLException;
    void deleteProject(Project project) throws SQLException;
    List<Project> getProjectList() throws SQLException;
}
