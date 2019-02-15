package repository;

import entity.Session;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessionRepository extends AbstractRepository {
//    public SessionRepository(Connection connection) { this.connection = connection; }

    public void addSession(final Session session) {
//        final String query = "INSERT INTO session (userId, signature, startValidPeriod) VALUE (?, ?, ?)";
//        try {
//            final PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, session.getUserId());
//            statement.setString(2, session.getSignature());
//            statement.setDate(3, makeSqlDate(session.getStartValidPeriod()));
//            statement.executeUpdate();
//            statement.close();
//        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void delete(final Session session) {
        final String query = "DELETE FROM session WHERE userId = ?";
        try {
            final PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, session.getUserId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) { e.printStackTrace(); }

    }

    public List<Session> getSessionList () {
        final List<Session> sessionList = new ArrayList<>();
        final String query = "SELECT * FROM session";
        try {
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                final String userId = resultSet.getString("userId");
                final String signature = resultSet.getString("signature");
                final Date startValidPeriod = resultSet.getDate("startValidPeriod");
                final Session session = new Session();
                session.setUserId(userId);
                session.setSignature(signature);
                session.setStartValidPeriod(startValidPeriod);
                sessionList.add(session);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return sessionList; }
}
