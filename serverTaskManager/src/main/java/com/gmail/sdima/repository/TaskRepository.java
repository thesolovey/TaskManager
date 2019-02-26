package com.gmail.sdima.repository;
import com.gmail.sdima.api.ITaskHibernate;
import com.gmail.sdima.entity.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class TaskRepository implements ITaskHibernate {

    private EntityManager manager;
    public EntityManager getManager() { return manager; }
    public void setManager(EntityManager manager) { this.manager = manager; }

    @Override
    public void addTask(final Task task) {
        getManager().persist(task);
    }

    @Override
    public void deleteTask(Task task) {
       task = getManager().merge(task);
       getManager().remove(task);
    }

    @Override
    public List<Task> getTaskList() {
        TypedQuery<Task> query = getManager().createNamedQuery("Task.getAll", Task.class);
        return query.getResultList();
    }
}
