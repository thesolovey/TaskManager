package repository;

import entity.User;

import java.util.List;

public class UserRepository {
//    public UserRepository(Connection connection) { this.connection = connection; }

    public void addUser(final User user) {
//        final String query = "INSERT INTO user (id, login, password, userName) VALUE (?, ?, ?, ?)";
//        try {
//            final PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, user.getId());
//            statement.setString(2, user.getLogin());
//            statement.setInt(3, user.getPassword());
//            statement.setString(4, user.getUserName());
//            statement.executeUpdate();
//            statement.close();
//        } catch (SQLException e) { e.printStackTrace(); }

//        SqlSession session = ConnectionMybatis.getSqlSessionFactory().openSession();
//        try {
//            IUserMapper userMapper = session.getMapper(IUserMapper.class);
//            userMapper.incert(user);
//            session.commit();
//        } finally {
//            session.close();
//        }
    }


    public List<User> getUsersList() {
//        SqlSession session = ConnectionMybatis.getSqlSessionFactory().openSession();
//        try {
//            IUserMapper userMapper = session.getMapper(IUserMapper.class);
//            return userMapper.getUsersList();
//        } finally {
//            session.close();
//        }
        return null;
    }
//        final List<User> usersList = new ArrayList<>();
//        final String query = "SELECT * FROM user";
//        try {
//            final Statement statement = connection.createStatement();
//            final ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                final String id = resultSet.getString("id");
//                final String login = resultSet.getString("login");
//                final int password = resultSet.getInt("password");
//                final String userName = resultSet.getString("userName");
//
//                final User user = new User();
//                user.setId(id);
//                user.setLogin(login);
//                user.setPassword(password);
//                user.setUserName(userName);
//                usersList.add(user);
//            }
//        } catch (SQLException e) { e.printStackTrace(); }


    public void deleteUser(final User user) {
//        SqlSession session = ConnectionMybatis.getSqlSessionFactory().openSession();
//        try {
//            IUserMapper userMapper = session.getMapper(IUserMapper.class);
//            userMapper.delete(user);
//            session.commit();
//        } finally {
//            session.close();
        }
//        final String query = "DELETE FROM user WHERE id = ?";
//        try {
//            final PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, user.getId());
//            statement.executeUpdate();
//            statement.close();
//        } catch (SQLException e) { e.printStackTrace(); }
//    }

    public void clearUsersList() {
//        usersList.clear();
    }
}
