package repository;
import api.IProjectHibernate;
import entity.Project;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import static domain.HibernateUtil.getEntityManager;

public class ProjectRepository implements IProjectHibernate {

    @Override
    public void addProject(final Project project) {
        final EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.persist(project);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void deleteProject(Project project) {
        final EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        project = manager.merge(project);
        manager.remove(project);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public List<Project> getProjectList() {
        final EntityManager manager = getEntityManager();
        TypedQuery<Project> query = manager.createNamedQuery("Project.getAll", Project.class);
        return query.getResultList();
    }
}