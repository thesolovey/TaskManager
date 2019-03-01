import com.gmail.sdima.bootstrap.BootstrapClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppClient {
    public static void main(String[] args) {
//        BootstrapClient bootstrap = new BootstrapClient();
//        bootstrap.start();

        ApplicationContext context = new AnnotationConfigApplicationContext("com.gmail.sdima");
        BootstrapClient bootstrap = context.getBean(BootstrapClient.class);
        bootstrap.start();
    }
}
