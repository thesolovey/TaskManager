package com.gmail.sdima9999.service;

import com.gmail.sdima9999.console.ReadFromConsole;
import com.gmail.sdima9999.entity.Project;
import com.gmail.sdima9999.entity.Task;
import com.gmail.sdima9999.repository.ProjectRepository;
import com.gmail.sdima9999.repository.TaskRepository;

import java.util.List;

public class ProjectService {
    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }
    public  boolean checkProjectListIsEmty() {
        List<Project> projectList = projectRepository.getProjectList();
        return projectList == null || projectList.isEmpty();
    }

    public void addProjectByList(Project project) {
        projectRepository.addProjectByList(project);
    }

    public List<Project> getAllNameProjectFromList() { return projectRepository.getProjectList(); }

    public Project openProjectByName(String nameProject) {
        final List<Project> projectList = projectRepository.getProjectList();
        Project projectByName = new Project();
        for (Project project : projectList)
            if (project.getName().equals(nameProject))
                projectByName = project;
                return projectByName;
    }

    public void clearAllProject() {
            projectRepository.clearAllProject();
    }

    public void deleteProject(String nameProject) {
        final List<Project> projectList = projectRepository.getProjectList();
        for (Project project : projectList)
            if (project.getName().equals(nameProject))
                projectList.remove(project);
    }

    public void updateNameProject() {
        String name;
        String newName;
        final List<Project> projectList = projectRepository.getProjectList();
        if (projectList == null || projectList.isEmpty()) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!  Try command 'project-create'  !!!");
        } else
            for (Project project : projectList) {
                name = ReadFromConsole.readInputFromConsole("Enter the name of the Project you want to exchange: ");
                if (project.getName().equals(name)) {
                    newName = ReadFromConsole.readInputFromConsole("Enter new name: ");
                    name = newName;
                     } else System.out.println("!!! Invalid name Project !!!");
                 }
    }
}
