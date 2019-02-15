package api;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserHibernate {
    void addUserByList(User user) throws SQLException;
    List<User> getUsersList() throws SQLException;
}
