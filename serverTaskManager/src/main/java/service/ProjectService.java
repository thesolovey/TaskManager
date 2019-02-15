package service;

import api.IProjectService;
import entity.Project;
import entity.Session;
import repository.ProjectRepository;
import repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class ProjectService implements IProjectService {
    private final ProjectRepository projectRepository;
    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository; }

    @Override
    public boolean checkProjectListIsEmpty() {
        final List<Project> projectList = projectRepository.getProjectList();
        return projectList == null || projectList.isEmpty();
    }

    @Override
    public void addProjectByList(final Project project) {
        if (project == null) return;
        projectRepository.addProject(project);
    }

    @Override
    public List<Project> getProjectByUserId(final Session session) {
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
        final List<Project> projectList = projectRepository.getProjectList();
        for (Project project : projectList) {
            if (project.getId().equals(idProject)) {
                projectRepository.deleteProject(project);
                return;
            }
        }
    }

//    public void updateNameProject(String id, String newNameProject) {
//        if (id == null || newNameProject == null) return;
//        final List<Project> projectList = projectRepository.getProjectList();
//        for (Project project : projectList)
//            if (project.getId().equals(id))
//                project.setName(newNameProject);
//    }
}
