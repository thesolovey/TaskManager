package com.gmail.sdima9999.repository;

import com.gmail.sdima9999.entity.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    private List<Project> projectList = new ArrayList<>();

    public void addProjectByList(final Project project) { projectList.add(project); }

    public List<Project> getProjectList() { return projectList; }

    public void clearAllProject() {projectList.clear();}

}
