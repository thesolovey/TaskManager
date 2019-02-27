package com.gmail.sdima.repository;
import com.gmail.sdima.api.ITaskHibernate;
import com.gmail.sdima.entity.Task;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
@Transactional
public class TaskRepository implements ITaskHibernate {

    @Inject private EntityManager manager;

    @Override
    public void addTask(final Task task) {
        manager.persist(task);
    }

    @Override
    public void deleteTask(Task task) {
       task = manager.merge(task);
       manager.remove(task);
    }

    @Override
    public List<Task> getTaskList() {
        TypedQuery<Task> query = manager.createNamedQuery("Task.getAll", Task.class);
        return query.getResultList();
    }
}
