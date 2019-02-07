package config;

import java.io.IOException;
import java.util.Properties;

public class ApplicationConfig {
    public static String secretKey;
    public static int saltCount;
    public static int sessionLifeTime;
//DataBaseConnection
    public static String DATABASE_URL;
    public static String JDBC_DRIVER;
    public static String LOGIN;
    public static String PASSWORD;

    static {
        final Properties prop = new Properties();
        try {
            prop.load(ApplicationConfig.class.getClassLoader().getResourceAsStream("config.properties"));
            secretKey = prop.getProperty("secretKey");
            saltCount = Integer.parseInt(prop.getProperty("saltCount"));
            sessionLifeTime = Integer.parseInt(prop.getProperty("sessionLifeTime"));

            DATABASE_URL = prop.getProperty("DATABASE_URL");
            JDBC_DRIVER = prop.getProperty("JDBC_DRIVER");
            LOGIN = prop.getProperty("LOGIN");
            PASSWORD = prop.getProperty("PASSWORD");

        } catch (IOException e) { e.printStackTrace(); }
    }
}
