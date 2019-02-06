package config;

import java.io.IOException;
import java.util.Properties;

public class ApplicationConfig {
    public static String secretKey;
    public static int saltCount;
    public static int sessionLifeTime;

    public ApplicationConfig() throws IOException {
        final Properties prop = new Properties();
        try {
            prop.load(ApplicationConfig.class.getClassLoader().getResourceAsStream("config.properties"));
            secretKey = prop.getProperty("secretKey");
            saltCount = Integer.parseInt(prop.getProperty("saltCount"));
            sessionLifeTime = Integer.parseInt(prop.getProperty("sessionLifeTime"));
        } catch (IOException e) { e.printStackTrace(); }
    }
}
