import com.gmail.sdima.bootstrap.BootstrapClient;
import com.gmail.sdima.endpoint.AccessForbiddenException_Exception;
import com.gmail.sdima.endpoint.Project;
import com.gmail.sdima.endpoint.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.UUID;

public class TestCreateProject {
    private BootstrapClient bootstrapClient = new BootstrapClient();
    private Project project = new Project();
    private Session session = new Session();
    private XMLGregorianCalendar calendar = null;

    @Before
    public void setData() {
        project.setUserId(UUID.randomUUID().toString());
        project.setId(UUID.randomUUID().toString());
        project.setName("testProject");
        project.setUserLogin("testUser");
        project.setUserName("testUser");

        session.setSignature(UUID.randomUUID().toString());
        session.setStartValidPeriod(calendar);
        session.setUserId(UUID.randomUUID().toString());
    }

    @Test
    public void testCreateProjectCommand() throws AccessForbiddenException_Exception {
        bootstrapClient.getEndpointProject().createProject(session, project);
    }

    @After
    public void clean() {
        session = null;
        project = null;
    }
}
