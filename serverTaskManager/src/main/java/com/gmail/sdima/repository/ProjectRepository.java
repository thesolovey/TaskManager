package com.gmail.sdima.repository;
import com.gmail.sdima.api.IProjectHibernate;
import com.gmail.sdima.entity.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class ProjectRepository implements IProjectHibernate {

    private EntityManager manager;
    public EntityManager getManager() { return manager; }
    public void setManager(EntityManager manager) { this.manager = manager; }

    @Override
    public void addProject(final Project project) {
        getManager().persist(project);
    }

    @Override
    public void deleteProject(Project project) {
        project = getManager().merge(project);
        getManager().remove(project);
    }

    @Override
    public List<Project> getProjectList() {
        TypedQuery<Project> query = getManager().createNamedQuery("Project.getAll", Project.class);
        return query.getResultList();
    }
}