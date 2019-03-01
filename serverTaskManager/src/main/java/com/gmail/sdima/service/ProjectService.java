package com.gmail.sdima.service;

import com.gmail.sdima.api.IProjectRepository;
import com.gmail.sdima.api.IProjectService;
import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService implements IProjectService {

    @Autowired private IProjectRepository projectRepository;

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
        for (Project project: projectList) {
            if (project.getId().equals(idProject)) {
                projectRepository.deleteProject(project);
                return;
            }
        }
    }

    @Override
    public Project getProjectById(final String idProject) {
        if (idProject == null) return null;
        Project projectById = null;
        final List<Project> projectList = projectRepository.getProjectList();
        for (Project project: projectList)
            if (project.getId().equals(idProject))
                projectById = project;
                return projectById;
    }
}
