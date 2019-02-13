package repository;

import entity.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static config.DateRequired.makeSqlDate;

public class TaskRepository extends AbstractRepository {
//    public TaskRepository(Connection connection) { this.connection = connection; }

    public void addTask(final Task task) {
        final String query = "INSERT INTO task (id, name, nameByProject, idByProject, userLogin, idByUser, dateBegin, dateEnd) " +
                "VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            final PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, task.getId());
            statement.setString(2, task.getName());
            statement.setString(3, task.getNameByProject());
            statement.setString(4, task.getIdByProject());
            statement.setString(5, task.getUserLogin());
            statement.setString(6, task.getIdByUser());
            statement.setDate(7, makeSqlDate(task.getDateBegin()));
            statement.setDate(8, makeSqlDate(task.getDateEnd()));
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Task> getTaskList() {
        final List<Task> taskList = new ArrayList<>();
        final String query = "SELECT * FROM task";
        try {
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                final String id = resultSet.getString("id");
                final String name = resultSet.getString("name");
                final String nameByProject = resultSet.getString("nameByProject");
                final String idByProject = resultSet.getString("idByProject");
                final String userLogin = resultSet.getString("userLogin");
                final String idByUser = resultSet.getString("idByUser");
                final Date dateBegin = resultSet.getDate("dateBegin");
                final Date dateEnd = resultSet.getDate("dateEnd");
                final Task task = new Task();
                task.setId(id);
                task.setName(name);
                task.setNameByProject(nameByProject);
                task.setIdByProject(idByProject);
                task.setUserLogin(userLogin);
                task.setIdByUser(idByUser);
                task.setDateBegin(dateBegin);
                task.setDateEnd(dateEnd);
                taskList.add(task);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return taskList;}

    public void deleteTask(final Task task) {
        final String query = "DELETE FROM task WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, task.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void clearTaskList() {
//        taskList.clear();
    }
}
