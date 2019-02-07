package domain;

import config.ApplicationConfig;

import java.sql.*;

public class DataBaseConnection {

    private static String JDBC_DRIVER = ApplicationConfig.JDBC_DRIVER;
    private static String DATABASE_URL = ApplicationConfig.DATABASE_URL;
    private static String LOGIN = ApplicationConfig.LOGIN;
    private static String PASSWORD = ApplicationConfig.PASSWORD;

    private Connection connection;

    {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, LOGIN, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }
    }

    public Connection getConnection() { return connection; }

//    public static void connection() {
//
//        try {
//            Class.forName(JDBC_DRIVER);
//            Connection connection = DriverManager.getConnection(DATABASE_URL, LOGIN, PASSWORD);
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            //close connection here
//            try { connection.close(); } catch(SQLException se) { /*can't do anything */ }
//        }
//    }
}

