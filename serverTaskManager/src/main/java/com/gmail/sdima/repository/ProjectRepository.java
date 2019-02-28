package com.gmail.sdima.repository;
import com.gmail.sdima.api.IProjectRepository;
import com.gmail.sdima.entity.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProjectRepository implements IProjectRepository {

    @PersistenceContext private EntityManager manager;

    @Override
    @Transactional
    public void addProject(final Project project) {
        manager.persist(project);
    }

    @Override
    @Transactional
    public void deleteProject(Project project) {
        project = manager.merge(project);
        manager.remove(project);
    }

    @Override
    public List<Project> getProjectList() {
        TypedQuery<Project> query = manager.createNamedQuery("Project.getAll", Project.class);
        return query.getResultList();
    }
}