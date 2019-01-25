package com.gmail.sdima.repository;

import com.gmail.sdima.entity.Project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository implements Serializable {
    private final List<Project> projectList = new ArrayList<>();

    public void addProject(final Project project) { projectList.add(project); }

    public List<Project> getProjectList() { return projectList; }

    public void clearProjectList() {projectList.clear();}

    public void deleteProject(final Project project) { projectList.remove(project); }

    public void addListProjects(List<Project> projects) { projectList.addAll(projects); }
}
