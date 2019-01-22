package com.gmail.sdima9999.service;

import com.gmail.sdima9999.entity.Project;
import com.gmail.sdima9999.repository.ProjectRepository;
import com.gmail.sdima9999.repository.TaskRepository;

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

    public void addProjectByList(Project project) { projectRepository.addProjectByList(project); }

    public List<Project> getAllProjectFromList() { return projectRepository.getProjectList(); }

    public void clearAllProject() { projectRepository.clearAllProject(); }

    public void deleteProject(String idProject) {
        List<Project> projectList = projectRepository.getProjectList();
        for (Project project : projectList)
            if (project.getId().equals(idProject))
                projectRepository.deleteProject(project);
    }

    public void updateNameProject(String id, String newNameProject) {
        final List<Project> projectList = projectRepository.getProjectList();
        for (Project project : projectList)
            if (project.getId().equals(id))
                project.setName(newNameProject);
    }

    public void writeObject() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("temp.txt");
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) { e.printStackTrace(); }

        try {
            if (oos != null) {
                oos.writeObject(projectRepository.getProjectList());
            }
        } catch (IOException e) { e.printStackTrace(); }

        try {
            if (oos != null) {
                oos.flush();
            }
        } catch (IOException e) { e.printStackTrace(); }

        try {
            oos.close();
        } catch (IOException e) { e.printStackTrace(); }
    }

    public List<Project> readObject() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("temp.txt");
        } catch (FileNotFoundException e) { e.printStackTrace(); }

        ObjectInputStream oin = null;
        try {
            oin = new ObjectInputStream(fis);
        } catch (IOException e) { e.printStackTrace(); }

        List<Project> projectList = null;
        try {
            projectList = (List<Project>) oin.readObject();
        } catch (IOException | ClassNotFoundException e) { e.printStackTrace(); }
        return projectList;
    }
}
