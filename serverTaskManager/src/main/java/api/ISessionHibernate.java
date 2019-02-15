package api;

import entity.Session;

import java.sql.SQLException;
import java.util.List;

public interface ISessionHibernate {
    void addSession(Session session) throws SQLException;
    void delete(Session session) throws SQLException;
    List<Session> getSessionList() throws SQLException;
}
