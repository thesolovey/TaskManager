package repository;

import entity.User;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends AbstractRepository {
    public UserRepository(Connection connection) { this.connection = connection; }

    private final List<User> usersList = new ArrayList<>();

    public void addUser(final User user) { usersList.add(user); }

    public List<User> getUsersList() { return usersList; }

    public void clearUsersList() { usersList.clear();}

    public void deleteUser(final User user) { usersList.remove(user); }

    public void addListUser(final List<User> users) { usersList.addAll(users); }
}
