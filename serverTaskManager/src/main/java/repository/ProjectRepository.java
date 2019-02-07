package repository;

import entity.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository extends AbstractRepository {
    public ProjectRepository(Connection connection) { this.connection = connection; }

    private final List<Project> projectList = new ArrayList<>();

    public void addProject(final Project project) {
        final String query = "INSERT INTO project (id, name, userName, userLogin, userId) VALUES (?, ?, ?, ?, ?)" ;
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, project.getId());
            statement.setString(2, project.getName());
            statement.setString(3, project.getUserName());
            statement.setString(4, project.getUserLogin());
            statement.setString(5, project.getUserId());
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) { e.printStackTrace(); }
        projectList.add(project); }

    public List<Project> getProjectList() { return projectList; }

    public void clearProjectList() {projectList.clear();}

    public void deleteProject(final Project project) { projectList.remove(project); }

    public void addListProjects(final List<Project> projects) { projectList.addAll(projects); }
}


// "id = VALUE(id), name = VALUE(name), userName = VALUE(userName), userLogin = VALUE(userLogin), userId = VALUE(userId)"