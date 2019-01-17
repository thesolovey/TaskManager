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

    public void addProjectByList(Project project) {
        projectRepository.addProjectByList(project);
    }

    public void getProjectListByName() {
        List<Project> projectList = projectRepository.getProjectList();
        if (projectList == null || projectList.isEmpty()) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!   Try command 'project-create' !!!");
        } else
            for (Project project : projectList)
            System.out.println(project.getName());
    }

    public void openProjectByName() {
        final List<Project> projectList = projectRepository.getProjectList();
        String name = "";
        if (projectList == null || projectList.isEmpty()) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!  Try command 'project-create'  !!!");
        } else
            name = ReadFromConsole.readInputFromConsole("Enter name Project do you want open: ");
        for (Project project : projectList) {
            if (project.getName().equals(name)) {
                System.out.println("Project Name: " + project.getName());
                System.out.println("Project ID: " + project.getId());
                System.out.println("Project DateBegin: " + project.getDateBegin());
                System.out.println("Project DateEnd: " + project.getDateEnd());

                final List<Task> taskList = taskRepository.getTaskList();
                if (taskList == null || taskList.isEmpty()) {
                    System.out.println("!!!This Project don't have Task!!!");
                } else
                for (Task nameProject : taskList)
                    if (nameProject.getNameByProject().equals(name)){
                        System.out.println("Tasks from this Project: " + nameProject.getName());
                    }
            } else System.out.println("!!!Invalid name Project!!!");
        }
    }
    public void clearAllProject() {
            projectRepository.clearAllProject();
    }

    public void deleteProject() {
        final List<Project> projectList = projectRepository.getProjectList();
        if (projectList == null || projectList.isEmpty()) {
            System.out.println("!!! You don't have any project now !!!");
            System.out.println("!!!  Try command 'project-create'  !!!");
        } else
            for (Project project : projectList) {
                String name = ReadFromConsole.readInputFromConsole("Enter the name of the Project you want to delete: ");
                if (project.getName().equals(name)) {
                    projectList.remove(project);
                }
            }
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
