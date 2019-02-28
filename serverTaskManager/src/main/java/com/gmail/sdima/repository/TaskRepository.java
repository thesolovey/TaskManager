package com.gmail.sdima.repository;
import com.gmail.sdima.api.ITaskRepository;
import com.gmail.sdima.entity.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class TaskRepository implements ITaskRepository {

    @PersistenceContext private EntityManager manager;

    @Override
    @Transactional
    public void addTask(final Task task) {
        manager.persist(task);
    }

    @Override
    @Transactional
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
