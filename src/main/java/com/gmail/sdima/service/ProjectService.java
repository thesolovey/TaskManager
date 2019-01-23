package com.gmail.sdima.service;

import com.gmail.sdima.entity.Project;
import com.gmail.sdima.repository.ProjectRepository;
import com.gmail.sdima.repository.TaskRepository;

import java.io.*;
import java.util.List;

public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
    }

    public boolean checkProjectListIsEmty() {
//        final List<Project> projectList = projectRepository.getProjectList();
        final List<Project> projectList = this.readObject();
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
        if (projectRepository.getProjectList() == null) return;
        List<Project> projectList = projectRepository.getProjectList();
        for (Project project : projectList)
            if (project.getId().equals(idProject))
                projectRepository.deleteProject(project);
    }

    public void updateNameProject(String id, String newNameProject) {
        if (projectRepository.getProjectList() == null) return;
        final List<Project> projectList = projectRepository.getProjectList();
        for (Project project : projectList)
            if (project.getId().equals(id))
                project.setName(newNameProject);
    }

    public void writeObject() {
        try {
            FileOutputStream fos = null;
            fos = new FileOutputStream("temp.txt");
            ObjectOutputStream oos = null;
            oos = new ObjectOutputStream(fos);
            oos.writeObject(projectRepository.getProjectList());
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Project> readObject () {
        List<Project> projectList = null;
        try {
             FileInputStream fis = null;
             fis = new FileInputStream("temp.txt");
             ObjectInputStream ois = null;
             ois = new ObjectInputStream(fis);
             projectList = (List<Project>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {e.printStackTrace();}
        return projectList;
    }
}
