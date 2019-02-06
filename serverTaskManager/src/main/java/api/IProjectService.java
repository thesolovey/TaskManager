package api;

import entity.Project;
import entity.Session;

import java.util.List;

public interface IProjectService {
    void addProjectByList(Project project);
    void deleteProject(String projectId);
    List<Project> getProjectByUserId(Session session);
    boolean checkProjectListIsEmpty();
    void clearAllProject(Session session);
}
