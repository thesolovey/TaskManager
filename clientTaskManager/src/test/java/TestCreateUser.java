import com.gmail.sdima.bootstrap.BootstrapClient;
import com.gmail.sdima.endpoint.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

public class TestCreateUser {

    private BootstrapClient bootstrapClient = new BootstrapClient();
    private User testUser = new User();

    @Before
    public void setData() {
        testUser.setId(UUID.randomUUID().toString());
        testUser.setLogin("testUser");
        testUser.setPassword(000);
        testUser.setUserName("testUser");
    }

    @Test
    public void testCreateUserCommand() {
        bootstrapClient.getEndpointUser().createUser(testUser);
    }

    @After
    public void clean() {
        testUser = null;
    }
}
