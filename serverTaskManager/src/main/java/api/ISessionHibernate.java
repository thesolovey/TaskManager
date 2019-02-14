package api;

import entity.Session;

import java.sql.SQLException;

public interface ISessionHibernate {
    Session getNewSession(String userId) throws SQLException;
//    void validateSession(Session session) throws SQLException, AccessForbiddenException;
    void logOut(Session session) throws SQLException;
    Session getSessionById(String userId) throws SQLException;
}
