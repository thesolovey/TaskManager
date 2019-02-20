package service;

import api.IProjectService;
import entity.Project;
import entity.Session;
import repository.ProjectRepository;
import repository.TaskRepository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static domain.HibernateUtil.getEntityManager;

public class ProjectService implements IProjectService {
    private final ProjectRepository projectRepository;
    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository; }

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

//    public void updateNameProject(String id, String newNameProject) {
//        if (id == null || newNameProject == null) return;
//        final List<Project> projectList = projectRepository.getProjectList();
//        for (Project project : projectList)
//            if (project.getId().equals(id))
//                project.setName(newNameProject);
//    }
}
