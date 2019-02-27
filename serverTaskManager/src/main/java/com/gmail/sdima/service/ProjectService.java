package com.gmail.sdima.service;

import com.gmail.sdima.api.IProjectService;
import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.Session;
import com.gmail.sdima.repository.ProjectRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static com.gmail.sdima.domain.HibernateUtil.getEntityManager;

@ApplicationScoped
public class ProjectService implements IProjectService {

    @Inject private ProjectRepository projectRepository;

    @Override
    public boolean checkProjectListIsEmpty() {
        final EntityManager manager = getEntityManager();
        projectRepository.setManager(manager);
        final List<Project> projectList = projectRepository.getProjectList();
        return projectList == null || projectList.isEmpty();
    }

    @Override
    public void addProjectByList(final Project project) {
        if (project == null) return;
        final EntityManager manager = getEntityManager();
        manager.getTransaction().begin();
        projectRepository.setManager(manager);
        projectRepository.addProject(project);
        manager.getTransaction().commit();
        manager.close();
        projectRepository.setManager(manager);
    }

    @Override
    public List<Project> getProjectByUserId(final Session session) {
        final EntityManager manager = getEntityManager();
        projectRepository.setManager(manager);
        final List<Project> projectList = projectRepository.getProjectList();
        final List<Project> projectListByUserId = new ArrayList<>();
        for (Project project : projectList)
            if (project.getUserId().equals(session.getUserId()))
                projectListByUserId.add(project);
        return projectListByUserId;
    }

    @Override
    public void deleteProject(final String idProject) {
        if (idProject == null) return;
        final EntityManager manager = getEntityManager();
        projectRepository.setManager(manager);
        final List<Project> projectList = projectRepository.getProjectList();
        for (Project project: projectList) {
            if (project.getId().equals(idProject)) {
                manager.getTransaction().begin();
                projectRepository.setManager(manager);
                projectRepository.deleteProject(project);
                manager.getTransaction().commit();
                manager.close();
                projectRepository.setManager(manager);
                return;
            }
        }
    }

    @Override
    public Project getProjectById(final String idProject) {
        if (idProject == null) return null;
        Project projectById = null;
        final EntityManager manager =getEntityManager();
        projectRepository.setManager(manager);
        final List<Project> projectList = projectRepository.getProjectList();
        for (Project project: projectList)
            if (project.getId().equals(idProject))
                projectById = project;
                return projectById;
    }
}
