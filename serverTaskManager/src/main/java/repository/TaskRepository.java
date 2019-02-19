package repository;
import api.ITaskHibernate;
import entity.Task;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import static domain.HibernateUtil.getEntityManager;

public class TaskRepository implements ITaskHibernate {

    @Override
    public void addTask(final Task task) {
        final EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        manager.persist(task);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void deleteTask(Task task) {
        final EntityManager manager = getEntityManager();
       manager.getTransaction().begin();
       task = manager.merge(task);
       manager.remove(task);
       manager.getTransaction().commit();
       manager.close();
    }

    @Override
    public List<Task> getTaskList() {
        final EntityManager manager = getEntityManager();
        TypedQuery<Task> query = manager.createNamedQuery("Task.getAll", Task.class);
        return query.getResultList();
    }
}
