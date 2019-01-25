package com.gmail.sdima.service;

import com.gmail.sdima.entity.Project;
import com.gmail.sdima.repository.ProjectRepository;
import com.gmail.sdima.repository.TaskRepository;

import java.util.List;

public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
    }

    public boolean checkProjectListIsEmty() {
        final List<Project> projectList = projectRepository.getProjectList();
        return projectList == null || projectList.isEmpty();
    }

    public void addProjectByList(Project project) {
        if (projectRepository.getProjectList() == null) return;
        projectRepository.addProject(project);
    }

    public List<Project> getAllProjectFromList() {
        return projectRepository.getProjectList();
    }

    public void clearAllProject() {
        if (projectRepository.getProjectList() == null) return;
        projectRepository.clearProjectList();
    }

    public void deleteProject(String idProject) {
        if (idProject == null) return;
        List<Project> projectList = projectRepository.getProjectList();

//        Iterator<Project> it = projectList.iterator(); it.hasNext();
//        Project project = it.next();
//        if (project.getId().equals(idProject))
//            it.remove();
        for (Project project : projectList)
            if (project.getId().equals(idProject))
                projectRepository.deleteProject(project);
    }

    public void updateNameProject(String id, String newNameProject) {
        if (id == null || newNameProject == null) return;
        final List<Project> projectList = projectRepository.getProjectList();
        for (Project project : projectList)
            if (project.getId().equals(id))
                project.setName(newNameProject);
    }

    public void addListProjects(List<Project> projects) {
        if (projects == null) return;
        projectRepository.addListProjects(projects);
    }
}
