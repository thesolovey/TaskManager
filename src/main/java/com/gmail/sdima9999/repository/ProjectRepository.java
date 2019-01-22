package com.gmail.sdima9999.repository;

import com.gmail.sdima9999.entity.Project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository implements Serializable {

    private List<Project> projectList = new ArrayList<>();

    public void addProjectByList(final Project project) { projectList.add(project); }

    public List<Project> getProjectList() { return projectList; }

    public void deleteProject (Project project) { projectList.remove(project); }

    public void clearAllProject() {projectList.clear();}
}
