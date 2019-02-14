package repository;

//public class ProjectRepository extends AbstractRepository {
////    public ProjectRepository(Connection connection) { this.connection = connection; }

//    public void addProject(final Project project) {
//        final String query = "INSERT INTO project (id, name, userName, userLogin, userId) VALUES (?, ?, ?, ?, ?)";
//        try {
//            final PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, project.getId());
//            statement.setString(2, project.getName());
//            statement.setString(3, project.getUserName());
//            statement.setString(4, project.getUserLogin());
//            statement.setString(5, project.getUserId());
//            statement.executeUpdate();
//            statement.close();
//        } catch (SQLException e) { e.printStackTrace(); }
//    }

//    public List<Project> getProjectList() {
//        final List<Project> projectList = new ArrayList<>();
//        final String query = "SELECT * FROM project";
//        try {
//            final Statement statement = connection.createStatement();
//            final ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                final String id = resultSet.getString("id");
//                final String name = resultSet.getString("name");
//                final String userName = resultSet.getString("userName");
//                final String userLogin = resultSet.getString("userLogin");
//                final String userId = resultSet.getString("userId");
//
//                final Project project = new Project();
//                project.setId(id);
//                project.setName(name);
//                project.setUserName(userName);
//                project.setUserLogin(userLogin);
//                project.setUserId(userId);
//                projectList.add(project);
//            }
//        } catch (SQLException e) { e.printStackTrace(); }
//        return projectList;

 //       SqlSession session = ConnectionMybatis.getSqlSessionFactory().openSession();
  //      return session.selectList("getProjectList");
 //   }

//    public void deleteProject(final Project project) {
//        final String query = "DELETE FROM project WHERE id = ?";
//        try {
//            final PreparedStatement statement = connection.prepareStatement(query);
//            statement.setString(1, project.getId());
//            statement.executeUpdate();
//            statement.close();
//        } catch (SQLException e) { e.printStackTrace(); }
//    }
//    public void clearProjectList() {
////        projectList.clear();
//    }
//}