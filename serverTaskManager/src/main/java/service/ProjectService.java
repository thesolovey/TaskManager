package service;

import api.IProjectHibernate;
import api.IProjectService;
import entity.Project;
import entity.Session;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

import static domain.HibernateUtil.getEntityManager;

public class ProjectService implements IProjectService, IProjectHibernate {

    public boolean checkProjectListIsEmpty() {
        final EntityManager manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            TypedQuery<Project> namedQuery = manager.createNamedQuery("Project.getAll", Project.class);
            final List<Project> projectList = namedQuery.getResultList();
            return projectList == null || projectList.isEmpty();
        } finally { manager.close(); }
    }

    public void addProjectByList(final Project project) {
        if (project == null) return;
        final EntityManager manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(project);
            manager.getTransaction().commit();
        } finally { manager.close(); }
    }

    public List<Project> getProjectByUserId(final Session session) {
        final EntityManager manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            TypedQuery<Project> namedQuery = manager.createNamedQuery("Project.getAll", Project.class);
            final List<Project> projectList = namedQuery.getResultList();
            final List<Project> projectListByuserId = new ArrayList<>();
            for (Project project : projectList)
                if (project.getUserId().equals(session.getUserId()))
                    projectListByuserId.add(project);
            return projectListByuserId;
        } finally {
            manager.close();
        }
    }

    public void deleteProject(final String idProject) {
        if (idProject == null) return;
        final EntityManager manager = getEntityManager();
        try {
            manager.getTransaction().begin();
            TypedQuery<Project> namedProject = manager.createNamedQuery("Project.getAll", Project.class);
            final List<Project> projectList = namedProject.getResultList();
            for (Project project : projectList) {
            if (project.getId().equals(idProject)) {
                manager.remove(project);
                manager.getTransaction().commit();
                return; }
            }
        } finally { manager.close(); }
    }

    public void updateNameProject(String id, String newNameProject) {
//        if (id == null || newNameProject == null) return;
//        final List<Project> projectList = projectRepository.getProjectList();
//        for (Project project : projectList)
//            if (project.getId().equals(id))
//                project.setName(newNameProject);
    }
}
