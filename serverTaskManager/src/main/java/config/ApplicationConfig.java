package config;

import java.io.IOException;
import java.util.Properties;

public class ApplicationConfig {
    public static String SECRET_KEY;
    public static int SALT_COUNT;
    public static int SESSION_LIFE_TIME;
//DataBaseConnection
    public static String DATABASE_URL;
    public static String JDBC_DRIVER;
    public static String LOGIN;
    public static String PASSWORD;

    static {
        final Properties prop = new Properties();
        try {
            prop.load(ApplicationConfig.class.getClassLoader().getResourceAsStream("config.properties"));
            SECRET_KEY = prop.getProperty("SECRET_KEY");
            SALT_COUNT = Integer.parseInt(prop.getProperty("SALT_COUNT"));
            SESSION_LIFE_TIME = Integer.parseInt(prop.getProperty("SESSION_LIFE_TIME"));

            DATABASE_URL = prop.getProperty("DATABASE_URL");
            JDBC_DRIVER = prop.getProperty("JDBC_DRIVER");
            LOGIN = prop.getProperty("LOGIN");
            PASSWORD = prop.getProperty("PASSWORD");
        } catch (IOException e) { e.printStackTrace(); }
    }
}
