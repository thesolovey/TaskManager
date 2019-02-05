package api;

import entity.Project;

import java.util.List;

public interface IProjectService {
    void addProjectByList(Project project);
    void deleteProject(String projectId);
    List<Project> getAllProjectFromList();
    boolean checkProjectListIsEmpty();

}
