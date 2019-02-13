package service;

import api.IProjectMapper;
import api.IProjectService;
import domain.ConnectionMybatis;
import entity.Project;
import entity.Session;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class ProjectService implements IProjectService {
//    private final ProjectRepository projectRepository;
//    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
//        this.projectRepository = projectRepository;
//    }

    public boolean checkProjectListIsEmpty() {
        SqlSession session = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            IProjectMapper projectMapper = session.getMapper(IProjectMapper.class);
            final List<Project> projectList = projectMapper.getProjectList();
            return projectList == null || projectList.isEmpty();
        } finally {
            session.close();
        }
    }

    public void addProjectByList(Project project) {
        if (project == null) return;
//        projectRepository.addProject(project);
        SqlSession session = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            IProjectMapper projectMapper = session.getMapper(IProjectMapper.class);
            projectMapper.addProject(project);
            session.commit();
        } finally {
            session.close();
        }
    }

    public List<Project> getProjectByUserId(Session session) {
        SqlSession sqlSession = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            IProjectMapper projectMapper = sqlSession.getMapper(IProjectMapper.class);
            final List<Project> projectList = projectMapper.getProjectList();
            final List<Project> projectListByuserId = new ArrayList<>();
            for (Project project : projectList)
                if (project.getUserId().equals(session.getUserId()))
                    projectListByuserId.add(project);
            return projectListByuserId;
        } finally {
            sqlSession.close();
        }
    }

    public void deleteProject(String idProject) {
        if (idProject == null) return;
        SqlSession session = ConnectionMybatis.getSqlSessionFactory().openSession();
        try {
            IProjectMapper projectMapper = session.getMapper(IProjectMapper.class);
            final List<Project> projectList = projectMapper.getProjectList();
            for (Project project : projectList) {
            if (project.getId().equals(idProject)) {
                projectMapper.deleteProject(project);
                return; }
            } session.commit();
        } finally {
            session.close();
        }
    }

    public void clearAllProject(Session session) {
//        projectRepository.clearProjectList();
    }

    public void updateNameProject(String id, String newNameProject) {
//        if (id == null || newNameProject == null) return;
//        final List<Project> projectList = projectRepository.getProjectList();
//        for (Project project : projectList)
//            if (project.getId().equals(id))
//                project.setName(newNameProject);
    }
}
