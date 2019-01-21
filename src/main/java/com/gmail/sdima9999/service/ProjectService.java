package com.gmail.sdima9999.service;

import com.gmail.sdima9999.entity.Project;
import com.gmail.sdima9999.repository.ProjectRepository;
import com.gmail.sdima9999.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public boolean checkProjectListIsEmty() {
        List<Project> projectList = projectRepository.getProjectList();
        return projectList == null || projectList.isEmpty();
    }

    public void addProjectByList(Project project) {
        projectRepository.addProjectByList(project);
    }

    public List<Project> getAllNameProjectFromList() {
        return projectRepository.getProjectList();
    }

    public List<Project> openProjectByName(String nameProject) {
        final List<Project> projectList = projectRepository.getProjectList();
        final List<Project> newProjectList = new ArrayList<>();
        Project projectByName = new Project();
        for (Project project : projectList) {
            if (project.getName().equals(nameProject))
                projectByName = project;
            newProjectList.add(projectByName);
        } return newProjectList;
    }

    public void clearAllProject() {
        projectRepository.clearAllProject();
    }

    public void deleteProject(String idProject) {
        final List<Project> projectList = projectRepository.getProjectList();
        for (Project project : projectList)
            if (project.getId().equals(idProject)) {
                projectList.indexOf(project);
                projectList.remove(project);
            }
    }

    public void updateNameProject(String nameProject, String newNameProject) {
        final List<Project> projectList = projectRepository.getProjectList();
        for (Project project : projectList)
            if (project.getName().equals(nameProject))
                project.setName(newNameProject);
    }
}
