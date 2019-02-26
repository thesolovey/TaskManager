import com.gmail.sdima.bootstrap.Bootstrap;
import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

public class TestEndpointProject {
    private Session session;
    private Project project;

    public Session getSession() { return session; }
    public void setSession(Session session) { this.session = session; }
    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }

    private Bootstrap bootstrap = new Bootstrap();

    @Before
    public void setData() {
        session = new Session();
        Date date = new Date();
        session.setUserId(UUID.randomUUID().toString());
        session.setStartValidPeriod(date);
        session.setSignature(UUID.randomUUID().toString());

        project = new Project();
        project.setUserId(UUID.randomUUID().toString());
        project.setUserLogin("userLogin");
        project.setUserName("userName");
        project.setName("projectName");
        project.setId(UUID.randomUUID().toString());
    }

    @Test
    public void testCreateProject() {
//        try {
//            bootstrap.getiSessionService().validateSession(session);
//        } catch (AccessForbiddenException e) {
//            e.printStackTrace();
//        }
//        bootstrap.getiProjectService().addProjectByList(project);
    }

    @After
    public void clean() {
        session = null;
        project = null;
    }
}
