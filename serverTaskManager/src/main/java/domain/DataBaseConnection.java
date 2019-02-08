package domain;

import config.ApplicationConfig;

import java.sql.*;

public class DataBaseConnection {

    private final static String JDBC_DRIVER = ApplicationConfig.JDBC_DRIVER;
    private final static String DATABASE_URL = ApplicationConfig.DATABASE_URL;
    private final static String LOGIN = ApplicationConfig.LOGIN;
    private final static String PASSWORD = ApplicationConfig.PASSWORD;

    private Connection connection;
    public Connection getConnection() { return connection; }
    {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, LOGIN, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }
    }
}

