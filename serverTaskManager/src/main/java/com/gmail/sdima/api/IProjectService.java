package com.gmail.sdima.api;

import com.gmail.sdima.entity.Project;
import com.gmail.sdima.entity.Session;

import java.util.List;

public interface IProjectService {
    void addProjectByList(Project project);
    void deleteProject(String projectId);
    List<Project> getProjectByUserId(Session session);
    boolean checkProjectListIsEmpty();
    Project getProjectById(final String idProject);
}
