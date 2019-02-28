package com.gmail.sdima.api;

import com.gmail.sdima.entity.Project;

import java.util.List;

public interface IProjectRepository {

    void addProject(Project project);
    void deleteProject(Project project);
    List<Project> getProjectList();
}
